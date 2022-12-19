package de.fis.database;

import de.fis.addon.time.Time;
import de.fis.model.Abfahrt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DBConnection {

    private String username;

    private String password;

    private Statement statement;

    public DBConnection(final String username, final String password) {
        this.username = username;
        this.password = password;
        establishConnection();
    }

    public List<Abfahrt> getNextSix(Time time) throws SQLException {
        ResultSet resultSet = statement.executeQuery(" SELECT * FROM activeworkbench.abfahrt where abfahrt > \'" + time.getCurrentTime(
                true) + "\' order by" + " abfahrt limit 6");
        List<Abfahrt> abfahrtList = new ArrayList<>();
        while (resultSet.next()) {
            Abfahrt abfahrt = new Abfahrt(resultSet.getString("abfahrt_id"), new Time(resultSet.getString("abfahrt")), resultSet.getString(
                    "zugnr"),
                    resultSet.getString("gleis"), resultSet.getString("route_id"));
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
        System.out.println("res: " + res);
        return res;
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
}
