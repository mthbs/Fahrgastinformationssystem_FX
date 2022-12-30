package de.fis.model;

import de.fis.database.DBConnection;
import de.fis.database.JSONConnection;

import java.sql.SQLException;
import java.util.List;


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

    public void setRouteId(final String routeId) {
        this.routeId = routeId;
    }

    public String getZielbf() {
        return zielbf;
    }

    public void setZielbf(final String zielbf) {
        this.zielbf = zielbf;
    }

}
