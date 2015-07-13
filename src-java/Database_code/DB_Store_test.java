import java.io.IOException;
import java.util.Random;

public class DB_Store_test
{
    public static void main(String [] args)
    {
        // Import database properties from config file
        Database_properties database_details = new Database_properties();
        
        // This is a bit of hack as havent figured out to correct for static method error
        Import_config_parameters temp = new Import_config_parameters();
        try
        {
            database_details = temp.getPropValues();
        }
        catch (IOException e)
        {
            System.err.println("ERROR: Failed to open config file: " + e.getMessage());
            System.exit(1);
        }
        
        /*
        
        database_details.set_DB_MAX_SIZE((long) 56465465); // This is just a placeholder for the time being
        database_details.set_connection("jdbc:mysql://127.0.0.1/weather_measurements");
        database_details.set_password("password");
        database_details.set_user("guycorlett");
        
        */
        
        Random r = new Random();
        double random_temp = 10.0 + 10 * r.nextDouble();
        double random_humidity = r.nextDouble();
        
        Measurement new_measurement = new Measurement(random_temp,random_humidity);
        
        Store_measurement open_DB_class = new Store_measurement(database_details,new_measurement);
        
        if(open_DB_class.write_to_db()==false)
        {
            System.err.println("Failed to Store measurement properly");
        }
 
    }
    
}