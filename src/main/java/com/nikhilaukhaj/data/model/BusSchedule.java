package com.nikhilaukhaj.data.model;

import lombok.Data;

@Data
public class BusSchedule {
    public String busRoute;
    public String day;
    public String firstDayTime;
    public String lastDayTime;
    public String destination;
}
