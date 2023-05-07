package com.nikhilaukhaj.api;

import com.nikhilaukhaj.data.model.BusRoute;
import com.nikhilaukhaj.service.BusService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.List;


@Path("/bus")
public class BusController {
    @Inject
    BusService busService;

    @GET
    public List<BusRoute> busRoutes(){
        return busService.getBusRoutes();
    }

    @POST
    public List<BusRoute> addBusRoute(BusRoute busRoute){
        busService.add(busRoute);
        return busRoutes();
    }
}
