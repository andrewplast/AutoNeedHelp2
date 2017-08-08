package ordersservice.controller;

import cardriversservice.model.CarDriver;
import ordersservice.model.Order;
import ordersservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@SpringBootApplication
//@RibbonClient(name = "cardriversservice", configuration = BalancerConfig.class)
@Path("/orders")
public class OrdersController {

    private OrderService orderService;

    // @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Collection<Order> getAllOrders() throws Exception {
        return orderService.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Order addOrder(Order order) throws Exception {
        orderService.add(order);
        return order;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Order getOrder(@PathParam("id") Integer id) throws Exception {
        return orderService.getById(id);
    }

    @POST
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response updateOrder(@PathParam("id") Integer id, Order order) throws Exception {
        try {
            orderService.update(order.getId(), order);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteOrder(@PathParam("id") Integer id) throws Exception {
        try {
            orderService.delete(id);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}/cardriverresponse/{idCarDriver}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Order setCarDriverResponse(@PathParam("id") Integer idOrder, @PathParam("idCarDriver") Integer idCarDriver) throws Exception {
        String url = "http://cardrivers-service/{id}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", Integer.toString(idCarDriver));
        orderService.setCarDriverResponse(idOrder, this.restTemplate.getForObject(url, CarDriver.class, params));
        return orderService.getById(idOrder);
    }

    @GET
    @Path("/cardriverneedhelp/{id}")
    @Produces(APPLICATION_JSON + ";charset=utf-8")
    public Collection<Order> getCarDriverNeedHelpOrders(@PathParam("id") Integer id) throws Exception {
        String url = "http://cardrivers-service/{id}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", Integer.toString(id));
        return orderService.getByCarDriverNeedHelp(this.restTemplate.getForObject(url, CarDriver.class, params));
    }

    @GET
    @Path("/cardriverresponse/{id}/")
    @Produces(APPLICATION_JSON + ";charset=utf-8")
    public Collection<Order> getCarDriverResponseOrders(@PathParam("id") Integer id) throws Exception {
        String url = "http://cardrivers-service/{id}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", Integer.toString(id));
        return orderService.getByCarDriverResponse(this.restTemplate.getForObject(url, CarDriver.class, params));
    }


}
