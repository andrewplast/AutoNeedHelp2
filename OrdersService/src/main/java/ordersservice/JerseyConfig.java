package ordersservice;

import ordersservice.controller.OrdersController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig
{
    public JerseyConfig()
    {
        register(OrdersController.class);
    }
}