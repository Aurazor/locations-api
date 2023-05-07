package com.nikhilaukhaj.data.model;

import lombok.Data;

@Data
public class BusFrequency {
    public String busRoute;
    public String destination;
    public String timeInterval;
    public String timeDepartureFrequency;

}
