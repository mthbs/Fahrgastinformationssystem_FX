package de.fis.model;

import de.fis.database.DBConnection;

import java.sql.SQLException;


public class Route {

    private String routeId;

    private String zielbf;

    public Route(final String routeId) throws SQLException {
        this.routeId = routeId;
        loadZielbf();
    }

    private void loadZielbf() throws SQLException {
        DBConnection dba = new DBConnection("root", "root");
        zielbf = dba.getZielbf(routeId);
    }

    public String getRouteId() {
        return routeId;
    }

    public String getZielbf() {
        return zielbf;
    }

}
