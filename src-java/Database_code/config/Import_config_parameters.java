import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
 
 
 
/**
 * Adjusted from Crunchify.com
 * 
 */
 
public class Import_config_parameters {
 
	public Database_properties getPropValues() throws IOException 
	{
		String result = "";
		Properties prop = new Properties();
		
	    // Consider whether need to remove this hardcoded string 
		String propFileName = "Database_config.properties";
 
 		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
 		// Following line is debug to find out how to load the Database_config.properties file when it is not in .bin
 		System.out.println("Absolute classpath ["+this.getClass().getResource("").getPath()+"]");
 
		if (inputStream != null) 
		{
			prop.load(inputStream);
		} 
		
		else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			
		}
 
		Date time = new Date(System.currentTimeMillis());
 
		// get the property value and print it out
		Database_properties DB_Properties = new Database_properties();
		DB_Properties.set_connection(prop.getProperty("CONNECTION_URL"));
		DB_Properties.set_DB_MAX_SIZE(Long.valueOf(prop.getProperty("DB_MAX_SIZE")));
		DB_Properties.set_user(prop.getProperty("user"));
		DB_Properties.set_password(prop.getProperty("password"));
		DB_Properties.set_database_name(prop.getProperty("database_name"));
		DB_Properties.set_table_name(prop.getProperty("table_name"));
		DB_Properties.set_date_field(prop.getProperty("date_field"));
		DB_Properties.set_temperature_field(prop.getProperty("temperature_field"));
		DB_Properties.set_humidity_field(prop.getProperty("humidity_field"));

		System.out.println("Config files in ["+propFileName+"] loaded at " + time);
		
		// Used for debug purposes to see whether correct properties loaded
		DB_Properties.print_DB_properties();
		
		return DB_Properties;
	}
}