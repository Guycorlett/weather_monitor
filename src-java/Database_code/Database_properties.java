// This is a class which contains the properties needed for database access

public class Database_properties
{
    // Database property variables
    // These are to be read from the parameter or config file
    
    private String CONNECTION_URL;
    private Long DB_MAX_SIZE;
    private String user;
    private String password;
    private String database_name;
    private String table_name; 
    private String date_field;
    private String temperature_field;
    private String humidity_field;
    
    public String get_connection() { return this.CONNECTION_URL; }
    public Long get_DB_MAX_SIZE() { return this.DB_MAX_SIZE; }
    public String get_user() { return this.user; }
    public String get_password() { return this.password; } 
    public String get_database_name() { return this.database_name; }
    public String get_table_name() { return this.table_name; }
    public String get_date_field() { return this.date_field; }
    public String get_temperature_field() { return this.temperature_field; }
    public String get_humidity_field() { return this.humidity_field; }
    
    public void set_connection(String connection) { this.CONNECTION_URL=connection; }
    public void set_DB_MAX_SIZE(Long max_size) { this.DB_MAX_SIZE=max_size; }
    public void set_user(String username) { this.user=username; }
    public void set_password(String pw) { this.password=pw; } 
    public void set_database_name(String db) { this.database_name=db; }
    public void set_table_name(String table) {this.table_name=table; }
    public void set_date_field(String date) { this.date_field=date; }
    public void set_temperature_field(String temperature) { this.temperature_field=temperature; }
    public void set_humidity_field(String humidity) { this.humidity_field=humidity; }
    
    
    // Next method is for debug purposes
    public void print_DB_properties()
    {
        System.out.println("User=["+this.get_user()+"]");
        System.out.println("Connection=["+this.get_connection()+"]");
        System.out.println("DB_MAX_SIZE=["+this.get_DB_MAX_SIZE()+"]");
        System.out.println("password=["+this.get_password()+"]");
        System.out.println("database_name=["+this.get_database_name()+"]");
        System.out.println("table_name=["+this.get_table_name()+"]");
        System.out.println("date_field=["+this.get_date_field()+"]");
        System.out.println("temperature_field=["+this.get_temperature_field()+"]");
        System.out.println("humidity_field=["+this.get_humidity_field()+"]");
    }
}