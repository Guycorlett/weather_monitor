/*  Store_measurements.java
    
    This is a program to store weather measurements to our MySQL database
    
*/


import java.lang.*;
import java.sql.*;
import java.util.*;

public class Store_measurement
{
  // The JDBC Connector Class.
  private static final String dbClassName = "com.mysql.jdbc.Driver";

  // Connection string. measurements is the database the program
  // is connecting to.

  // private static final String CONNECTION = "jdbc:mysql://127.0.0.1/weather_measurements";

    private Double temperature, humidity;
    private String CONNECTION_URL;
    private Long DB_MAX_SIZE;
    private String user;
    private String password;
    private String database_name;
    private String table_name;
    private String date_field;
    private String temperature_field;
    private String humidity_field;


    public Store_measurement(Database_properties DB_Properties, Measurement weather_measurement)
    {
        this.temperature=weather_measurement.access_temp(); 
        this.humidity=weather_measurement.access_humidity();
        
        this.CONNECTION_URL=DB_Properties.get_connection();
        this.DB_MAX_SIZE=DB_Properties.get_DB_MAX_SIZE();
        this.user=DB_Properties.get_user();
        this.password=DB_Properties.get_password();
        this.database_name=DB_Properties.get_database_name();
        this.table_name=DB_Properties.get_table_name();
        this.date_field=DB_Properties.get_date_field();
        this.temperature_field=DB_Properties.get_temperature_field();
        this.humidity_field=DB_Properties.get_humidity_field();
        
        
    }


  public boolean write_to_db()
  {
      // Need to think about catching error where database gets over size limit
      // Maybe this needs to be done in MySQL
      try 
      {
          
            System.out.println("Using the following JDBC Connector Class: " + dbClassName);
            // Class.forName(xxx) loads the jdbc classes and
            // creates a drivermanager class factory
            Class.forName(dbClassName);
            
        
            // Properties for user and password. 
            // Consider whether to include more things in this property field (eg database max size, database address)
            Properties p = new Properties();
            p.put("user",this.user);
            p.put("password",this.password);
            
        
        
            // Now try to connect
            Connection c = DriverManager.getConnection(this.CONNECTION_URL,p);
        
            // Prepare SQL statement to insert line into database
            // Consider whether to change the string below so that it feeds in the DB column names from a properties file
            String query = "insert into "+this.table_name+" ("+this.date_field+", "+this.temperature_field+", "+this.humidity_field+") " + "values (?,?,?)";
            
            // The following line is for debug purposes
            System.out.println("This is the SQL query that is about to be executed: "+query);
            
            PreparedStatement preparedStmt = c.prepareStatement(query);
            
            // Assign values to each of the "?" above
            preparedStmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            preparedStmt.setDouble (2, this.temperature);
            preparedStmt.setDouble (3, this.humidity);  
            
            // execute the preparedstatement
            preparedStmt.execute();

            // Print out confirmation of measurement take to system terminal...
            java.util.Date myDate = new java.util.Date();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("[yyyy-MM-dd:HH-mm-ss]");
            String myDateString = sdf.format(myDate);
            System.out.println(myDateString+ " - Weather Measurement recorded...");

            c.close();
            preparedStmt.close();   

            return true;
          
      } 
      
      catch(ClassNotFoundException e) 
      {
          e.printStackTrace();
          return false;
      }

      catch(SQLException e) 
      {
          e.printStackTrace();
          return false;
      }
     

    
  }
}
