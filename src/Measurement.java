// This is a class which contains the measurement which will be written to the SQL DB containing all historical temps/humidities

import java.sql;

public class Measurement
{
    // Hold variables for the measurement
    private double temperature_local, humidity_local
    private long timestamp;
    
    // Initialise the measurement class
    public Measurement(double temperature, double humidity)
    {
        temperature_local = temperature
        humidity_local = humidity
        timestamp = Timestamp.getTime()
    }
    
    // Access temperature
}