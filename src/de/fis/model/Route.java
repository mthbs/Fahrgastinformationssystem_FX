package de.fis.model;

import de.fis.database.DBConnection;

import java.sql.SQLException;
import java.util.List;


public class Route {
    private String routeId;
    private String zielbf;
    private String[] halte;

    public Route(final String routeId) throws SQLException {
        this.routeId = routeId;
        loadZielbf();
        loadHalte();
    }

    private void loadZielbf() throws SQLException {
        DBConnection dba = new DBConnection("root","root");
        zielbf = dba.getZielbf(routeId);
    }

    private void loadHalte() {
        // JSON
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(final String routeId) {
        this.routeId = routeId;
    }

    public String getZielbf() {
        return zielbf;
    }

    public void setZielbf(final String zielbf) {
        this.zielbf = zielbf;
    }

    public String[] getHalte() {
        return halte;
    }
}
