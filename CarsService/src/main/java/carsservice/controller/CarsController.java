package carsservice.controller;

import carsservice.model.Car;
import carsservice.service.CarService;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Collection;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/")
public class CarsController {

    private CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GET
    @Produces(APPLICATION_JSON + ";charset=utf-8")
    public Collection<Car> getAllCars() throws Exception {
        return carService.getAll();
    }

    @POST
    @Produces(APPLICATION_JSON + ";charset=utf-8")
    public Car addCar(Car car) throws Exception {
        carService.add(car);
        return car;
    }

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON + ";charset=utf-8")
    public Car getCar(@PathParam("id") Integer id) throws Exception {
        return carService.getById(id);
    }

    @POST
    @Path("/{id}")
    @Consumes(APPLICATION_JSON)
    public Response updateCar(@PathParam("id") Integer id, Car car) throws Exception {
        try {
            carService.update(id, car);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCar(@PathParam("id") Integer id) throws Exception {
        try {
            carService.delete(carService.getById(id));
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}