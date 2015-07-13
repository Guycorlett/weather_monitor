// This is a class which contains the measurement which will be written to the SQL DB containing all historical temps/humidities


public class Measurement
{
    // Hold variables for the measurement
    // Temperature in Celsius
    // Humidity as a percentage out of 100
    private double temperature_local, humidity_local;
    
    // Initialise the measurement class
    public Measurement(double temperature, double humidity)
    {
        this.temperature_local = temperature;
        this.humidity_local = humidity;
        
    }
    
    // Access temperature
    public double access_temp()
    {
        return this.temperature_local;
    }
     
    // Access humidity
    public double access_humidity()
    {
        return this.humidity_local;
    }

}