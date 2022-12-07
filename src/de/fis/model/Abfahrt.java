package de.fis.model;

import de.fis.addon.time.Time;

import java.sql.SQLException;


public class Abfahrt {
    private String id;
    private Time abfahrt;
    private String zugnr;
    private String gleis;
    private String routeId; // Fremdschlüssel
    private Route route;

    public Abfahrt(final String id, final Time abfahrt, final String zugnr, final String gleis, final String routeId) throws SQLException {
        this.id = id;
        this.abfahrt = abfahrt;
        this.zugnr = zugnr;
        this.gleis = gleis;
        this.routeId = routeId;
        route = new Route(routeId);
    }


    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public Time getAbfahrt() {
        return abfahrt;
    }

    public void setAbfahrt(final Time abfahrt) {
        this.abfahrt = abfahrt;
    }

    public String getZugnr() {
        return zugnr;
    }

    public void setZugnr(final String zugnr) {
        this.zugnr = zugnr;
    }

    public String getGleis() {
        return gleis;
    }

    public void setGleis(final String gleis) {
        this.gleis = gleis;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(final String routeId) {
        this.routeId = routeId;
    }


    public Route getRoute() {
        return route;
    }

    public void setRoute(final Route route) {
        this.route = route;
    }
}
