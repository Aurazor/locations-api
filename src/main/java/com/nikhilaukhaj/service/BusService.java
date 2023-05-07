package com.nikhilaukhaj.service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.nikhilaukhaj.data.model.BusRoute;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class BusService {
    @Inject
    MongoClient mongoClient;

    private static Logger LOGGER = LoggerFactory.getLogger(BusService.class);

    public List<BusRoute> getBusRoutes(){
        List<BusRoute> busRoutes = new ArrayList<>();
        MongoCursor<Document> cursor = getBusRouteCollection().find().iterator();
        try{
            while(cursor.hasNext()){
                Document document = cursor.next();
                BusRoute busRoute = new BusRoute();
                busRoute.setId(String.valueOf(document.getObjectId("_id")));
                busRoute.setName("Route 1");
                busRoute.setDestinationFrom("Port Louis");
                busRoute.setDestinationTo("Rose Hill");
                busRoutes.add(busRoute);
            }
        }finally {
            cursor.close();
        }
        return busRoutes;
    }

    public void add(BusRoute busRoute){
        Document document = new Document()
                .append("name", busRoute.getName())
                .append("destinationFrom", busRoute.getDestinationFrom())
                .append("destinationTo", busRoute.getDestinationTo());
        getBusRouteCollection().insertOne(document);

        LOGGER.info("New object created: {}", document.getObjectId("_id"));
    }



    public MongoCollection getBusRouteCollection(){
        return mongoClient.getDatabase("busRoutes").getCollection("busRoute");
    }
}
