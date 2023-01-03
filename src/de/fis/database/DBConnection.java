package de.fis.database;

import de.fis.addon.time.Time;
import de.fis.model.Abfahrt;
import de.fis.model.Route;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class DBConnection {

    private String username;

    private String password;

    private Statement statement;

    public DBConnection(final String username, final String password) {
        this.username = username;
        this.password = password;
        establishConnection();
    }

    private void establishConnection() {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/activeworkbench?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<Abfahrt> getAbfahrten(Time time, int limit) throws SQLException {
        // int limit: limit=-1: Komplett, limit>0: anzahl nächster Fahrten
        String query = null;
        if(limit > 0 && time != null) {
            query = new String(" SELECT DISTINCT * FROM activeworkbench.abfahrt where abfahrt > \'" + time.getCurrentTime(true) + "\' order by" + " abfahrt limit " + limit);
        } else {
            query = new String(" SELECT DISTINCT * FROM activeworkbench.abfahrt ORDER BY abfahrt ");
        }
        return getAbfahrten(query);
    }

    public List<Abfahrt> getAbfahrten(String query) throws SQLException {
        ResultSet resultSet = statement.executeQuery(query);
        List<Abfahrt> abfahrtList = new ArrayList<>();
        while (resultSet.next()) {
            Abfahrt abfahrt = new Abfahrt(resultSet.getString("abfahrt_id"), new Time(resultSet.getString("abfahrt")),
                    resultSet.getString("zugnr"), resultSet.getString("gleis"), resultSet.getString("route_id"));
            abfahrtList.add(abfahrt);
        }
        return abfahrtList;
    }

    public String getZielbf(String routeId) throws SQLException {
        ResultSet resultSet = statement.executeQuery(" SELECT * FROM activeworkbench.route where id = \'" + routeId + "\'");
        String res = null;
        while (resultSet.next()) {
            res = resultSet.getString("ziel");
        }
        return res;
    }

    public void createZielIfNotExists(String name) throws SQLException {
        boolean alreadyExists = false;
        ResultSet resultSet = statement.executeQuery(" SELECT DISTINCT halteName FROM activeworkbench.haltepunkt ");
        while (resultSet.next()) {
            if (name.equals(resultSet.getString("halteName"))) {
                alreadyExists = true;
            }
        }
        // create new entry
        if (!alreadyExists) {
            String query = " insert into activeworkbench.haltepunkt (halteName) values (\'" + name + "\') ";
            statement.executeUpdate(query);
        }
    }

    public void createNewAbfahrt(String abfahrt, String zugnr, String gleis, String routeId) throws SQLException {
        String query = "INSERT INTO Abfahrt (abfahrt,zugnr,gleis,route_id) values (\'" + abfahrt + "\',\'" + zugnr + "\'," + Integer.parseInt(
                gleis) + ",\'" + routeId + "\')";
        statement.executeUpdate(query);
    }

    public void createNewRoute(String routeId, String zielbf) throws SQLException {
        createZielIfNotExists(zielbf);
        String query = "INSERT INTO activeworkbench.route VALUES (\'" + routeId + "\',\'" + zielbf + "\') ; ";
        statement.executeUpdate(query);
    }

    public Set<String> getAllUsedLines() throws SQLException {
        Set<String> allUsedLines = new HashSet<>();
        ResultSet resultSet = statement.executeQuery(" SELECT DISTINCT zugnr FROM activeworkbench.abfahrt ");
        while (resultSet.next()) {
            allUsedLines.add(resultSet.getString("zugnr"));
        }
        return allUsedLines;
    }

    public Set<String> getAllUsedZiele() throws SQLException {
        Set<String> allUsedZiele = new HashSet<>();
        ResultSet resultSet = statement.executeQuery(" SELECT DISTINCT halteName FROM activeworkbench.haltepunkt ");
        while (resultSet.next()) {
            allUsedZiele.add(resultSet.getString("halteName"));
        }
        return allUsedZiele;
    }

    public void executeUpdateQuery(String query) throws SQLException {
        statement.executeUpdate(query);
    }

    public boolean routeVorhanden(String routeId, String zielbf) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM activeworkbench.route WHERE id = \'"+routeId+"\' AND ziel = \'"+zielbf+
                "\' ;");
        if(!resultSet.next()){
            // resultSet is empty
            return false; // dann öffne FXML
        } else {
            // resultSet is not empty
            resultSet = statement.executeQuery("SELECT * FROM activeworkbench.haltepunkt WHERE halteName = \'"+ zielbf +"\' ;");
            if(!resultSet.next()){
                System.err.println("Haltepunkt ist nicht eingetragen");
                return false; // Haltepunkt ist nicht eingetragen
            } else {
                return true;
            }
        }
    }

}
