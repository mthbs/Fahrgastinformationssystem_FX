package de.fis.controllers.zwischenhalte;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import de.fis.model.Unterwegshalt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


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

    public void addNewJSONEntry(Unterwegshalt neuerHalt) throws IOException {
        JsonNode text = objectMapper.readTree(new File("resources/JSON/routes.json"));
        String allEntriesJSON = text.toString();
        StringBuilder sb = new StringBuilder(allEntriesJSON);
        sb.replace(allEntriesJSON.length()-1,allEntriesJSON.length()-1,"," + objectMapper.writeValueAsString(neuerHalt));
        try (FileWriter writer = new FileWriter("resources/JSON/routes.json")){
            writer.write(sb.toString().replace("[{","[\n{").replace("},{","},\n{"));
        }

    }

}
