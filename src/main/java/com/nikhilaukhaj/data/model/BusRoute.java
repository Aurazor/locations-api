package com.nikhilaukhaj.data.model;

import lombok.Data;

@Data
public class BusRoute {

    private String id;
    private String name;
    private String destinationTo;
    private String destinationFrom;

}
