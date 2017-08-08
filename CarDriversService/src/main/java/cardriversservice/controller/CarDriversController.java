package cardriversservice.controller;

import cardriversservice.model.CarDriver;
import cardriversservice.service.CarDriverService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Collection;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/cardrivers")
public class CarDriversController {

    private CarDriverService carDriverService;

    public CarDriversController(CarDriverService carDriverService) {
        this.carDriverService = carDriverService;
    }

    @GET
    @Produces(APPLICATION_JSON + ";charset=utf-8")
    public Collection<CarDriver> getAllCarDrivers() throws Exception {
        return carDriverService.getAll();
    }

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON + ";charset=utf-8")
    public CarDriver addCarDriver(CarDriver carDriver) throws Exception {
        carDriverService.add(carDriver);
        return carDriver;
    }

    @GET
    @Path("/{ID}")
    @Produces(APPLICATION_JSON)
    public CarDriver getCarDriver(@PathParam("ID") Integer id) throws Exception {
        return carDriverService.getById(id);
    }

    @POST
    @Path("/{ID}")
    @Produces(APPLICATION_JSON + ";charset=utf-8")
    public Response updateCarDriver(@PathParam("ID") Integer id, CarDriver carDriver) throws Exception {
        try {
            carDriverService.update(id, carDriver);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{ID}")
    public Response deleteCarDriver(@PathParam("ID") Integer id) throws Exception {
        try {
            carDriverService.delete(id);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
