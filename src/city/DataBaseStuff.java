package city;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBaseStuff {

    private static final String CONN = "jdbc:sqlite:towns.db";

    public static List<Town> getTownsFromDB() throws SQLException {
        List<Town> towns = new ArrayList<>();

        String sqlQuery = "SELECT * FROM towns;";

        Connection connection = DriverManager.getConnection(CONN);
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ResultSet resultSet = preparedStatement.executeQuery();

        try(connection; preparedStatement; resultSet) {
            while (resultSet.next()) {
                String name = resultSet.getString("townName");
                int x = resultSet.getInt("townplaceX");
                int y = resultSet.getInt("townPlaceY");
                String connections = resultSet.getString("townCollections");

                List<String> connectsTo = Arrays.asList(connections.split(";"));

                Town town = new Town(name,x,y,connectsTo);
                towns.add(town);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return towns;
    }
    public static void saveTownInDB(Town town) throws SQLException {
        Connection connection = DriverManager.getConnection(CONN);

        String insertSQL = "INSERT INTO towns(townName,townplaceX,townPlaceY,townCollections) VALUES (?, ?, ?, ?);";

        PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
        try(connection; preparedStatement){

            String allconnections = "";
            for (int i = 0; i < town.getConnections().size(); i++){
                allconnections += town.getConnections().get(1) + ";";
            }

            preparedStatement.setString(1, town.getName());
            preparedStatement.setInt(2, town.getX());
            preparedStatement.setInt(3,town.getY());
            preparedStatement.setString(4,allconnections);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


}
