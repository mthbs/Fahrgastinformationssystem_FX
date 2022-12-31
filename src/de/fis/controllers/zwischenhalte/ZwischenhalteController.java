package de.fis.controllers.zwischenhalte;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.fis.model.Unterwegshalte;

import java.io.File;
import java.io.IOException;


public class ZwischenhalteController {

    private static ObjectMapper objectMapper = new ObjectMapper();

    private static Unterwegshalte[] allConnections;


    public void createList() throws IOException {
        allConnections = objectMapper.readValue(new File(
                        "C:\\Users\\derma\\OneDrive\\Documents\\Java Projects\\Fahrgastinformationssystem_FX2\\resources\\JSON\\routes.json"),
                Unterwegshalte[].class);
    }


    public String[] getTripForId(String id) throws IOException {
        for (Unterwegshalte u : allConnections) {
            if (u.getRouteId().equals(id)) {
                return u.getRoute();
            }
        }
        return new String[0];
    }

}
