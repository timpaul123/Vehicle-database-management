/*
 * Prepared statements for vehicle queries
 * Allows the user to add a vehicle and view all vehicles in a database
 * TODO:
 * Create more prepared statements for the rest of the GUI interface, giving the user more options
 */
package databasemanagement;

/**
 *
 * @author Tim Carrington
 */
import java.sql.*;
import java.util.List;
import java.util.ArrayList;


public class InterfaceQueries {
    private final String URL = "jdbc:derby://localhost:1527/MT Vehicles";
    private final String USERNAME = "Tim";
    private final String PASS = "**********************"; 
    
    private Connection connection;
    
    //initial prepared statements
    private PreparedStatement insertNewVehicle;
    private PreparedStatement viewAllVehicles;
    private PreparedStatement viewAllTrips;
    //private PreparedStatement updateVehicle;
    
    //constructor
    public InterfaceQueries()
    {
        try
        {
            connection = 
                    DriverManager.getConnection(URL, USERNAME, PASS);
            
            // create a query to insert a new vehicle
            insertNewVehicle = connection.prepareStatement("INSERT INTO VEHICLE" +
                                                           "(VRN, MAKEANDMODEL, ODOMETER)" +
                                                           "VALUES (?,?,?)");
            // create a query to list all the vehicles
            viewAllVehicles = connection.prepareStatement("SELECT * FROM VEHICLE");
            
            //Create a query to view all current trips
            viewAllTrips = connection.prepareStatement("SELECT * FROM TRIP");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public List< Vehicle > getAllVehicles()
    {
        List< Vehicle > vehicles = null;
        ResultSet resultSet = null;
        
        try
        {
            resultSet = viewAllVehicles.executeQuery();
            vehicles = new ArrayList<>();
            
            while(resultSet.next())
            {
                vehicles.add(new Vehicle(resultSet.getString("MAKEANDMODEL"),
                                         resultSet.getString("VRN"),
                                         resultSet.getDouble("ODOMETER")));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        } 
        finally
        {
            try
            {
                resultSet.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
                close();
            }
        }
        
        return vehicles;
    }
    
    public int insertVehicle(String makeAndModel, String VRN, double Odometer)
    {
        int result = 0;
       
        try
        {
            insertNewVehicle.setString(1, VRN);
            insertNewVehicle.setString(2, makeAndModel);
            insertNewVehicle.setString(3, Double.toString(Odometer));
            
            // insert the entry, returns the number of rows updated
            result = insertNewVehicle.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            close();
        }
        
        return result;
    }
    
    public List <Trip> getTrips(){
        List<Trip> trips = null;
        ResultSet resultSet = null;
 
        try
        {
           
            resultSet = viewAllTrips.executeQuery();
            trips = new ArrayList<>();
    
            while(resultSet.next())
            {
                trips.add(new Trip(resultSet.getString("CONTROLNUMBER"),
                                   resultSet.getDate("RETURNDATE"),
                                   resultSet.getString("LOCATIONTO"),
                                   resultSet.getString("LOCATIONFROM"),
                                   resultSet.getDate("STARTDATE")));
            }
          
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        finally
        {
            try
            {
                resultSet.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
                close();
            }
        }
       return trips;
    }
    
    public void close()
    {
        try
        {
            connection.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
