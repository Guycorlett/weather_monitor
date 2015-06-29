// This is a class which contains the measurement which will be written to the SQL DB containing all historical temps/humidities

public class Measurement
{
    // Hold variables for the measurement
    private double temperature_local, humidity_local;
    private long timestamp;
    
    // Initialise the measurement class
    public Measurement(double temperature, double humidity)
    {
        temperature_local = temperature;
        humidity_local = humidity;
        timestamp = System.currentTimeMillis();
    }
    
    // Access temperature
    public double access_temp(Measurement m)
    {
        return m.temperature_local;
    }
     
    // Access humidity
    public double access_humidity(Measurement m)
    {
        return m.humidity_local;
    }
    
    // Access time
    public long access_time(Measurement m)
    {
        return m.timestamp;
    }
}