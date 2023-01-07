package de.fis.controllers.zwischenhalte;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.fis.model.Unterwegshalt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class ZwischenhalteController {

    private static ObjectMapper objectMapper = new ObjectMapper();

    private static Unterwegshalt[] allConnections;


    public void createList() throws IOException {
        allConnections = objectMapper.readValue(new File(
                        "resources/JSON/routes.json"),
                Unterwegshalt[].class);
    }


    public String[] getTripForId(String id) throws IOException {
        for (Unterwegshalt u : allConnections) {
            if (u.getRouteId().equals(id)) {
                return u.getRoute();
            }
        }
        return new String[0];
    }

    public void addNewJSONEntry(Unterwegshalt routeObject) throws IOException {

        String newEntryJSON = objectMapper.writeValueAsString(routeObject);
        JsonNode allExistingEntries = objectMapper.readTree(new File("resources/JSON/routes.json"));
        String allEntriesJSON = allExistingEntries.toString();
        allEntriesJSON.lastIndexOf("]");
        System.out.println(allEntriesJSON);
        StringBuilder sb = new StringBuilder(allEntriesJSON);
        sb.replace(allEntriesJSON.length()-1,allEntriesJSON.length()-1,"," + newEntryJSON);
        System.out.println(sb.toString());
        try (FileWriter writer = new FileWriter("resources/JSON/routes.json")){
            writer.write(sb.toString().replace("[{","[\n{").replace("},{","},\n{"));
        }

    }

}
