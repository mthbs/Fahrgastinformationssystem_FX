package de.fis.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Unterwegshalte {

    @JsonProperty("route_id")
    private String routeId;

    @JsonProperty("ziel")
    private String ziel;

    @JsonProperty("route")
    private String[] route;

    public String getRouteId() {
        return routeId;
    }

    public String[] getRoute() {
        return route;
    }
}
