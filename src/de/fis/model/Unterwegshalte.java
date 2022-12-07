package de.fis.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Unterwegshalte {

    @JsonProperty("route_id")
    private String routeId;

    @JsonProperty("ziel")
    private String ziel;

    @JsonProperty("route")
    private String[] route;

    public Unterwegshalte(){}

    public Unterwegshalte(final String routeId, final String ziel, final String[] route) {
        this.routeId = routeId;
        this.ziel = ziel;
        this.route = route;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(final String routeId) {
        this.routeId = routeId;
    }

    public String getZiel() {
        return ziel;
    }

    public void setZiel(final String ziel) {
        this.ziel = ziel;
    }

    public String[] getRoute() {
        return route;
    }

    public void setRoute(final String[] route) {
        this.route = route;
    }
}
