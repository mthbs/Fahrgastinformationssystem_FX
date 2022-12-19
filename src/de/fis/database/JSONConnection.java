package de.fis.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.fis.model.Unterwegshalte;

import java.io.File;
import java.io.IOException;


public class JSONConnection {

    private static ObjectMapper objectMapper = new ObjectMapper();

    private static Unterwegshalte[] allConnections;


    public void createList() throws IOException {
        allConnections = objectMapper.readValue(new File(
                        "C:\\Users\\derma\\OneDrive\\Documents\\Java " + "Projects\\Fahrgastinformationssystem_FX\\resources\\JSON\\routes.json"),
                Unterwegshalte[].class);
    }


    public String[] getTripForId(String id) {
        for (Unterwegshalte u : allConnections) {
            if (u.getRouteId().equals(id)) {
                return u.getRoute();
            }
        }
        return null;
    }

}
