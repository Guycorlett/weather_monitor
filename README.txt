This is a weather monitoring app for the Raspberry Pi written in Java

When building a file the following command seems to work
javac -d /home/ubuntu/workspace/.bin -cp /usr/share/java/mysql-connector-java.jar:/home/ubuntu/workspace/.bin:/home/ubuntu/workspace/src-java/Database_code/config/ Import_config_parameters.java 

When running a file the following command seems to work
java -cp /usr/share/java/mysql-connector-java.jar:/home/ubuntu/workspace/.bin:/home/ubuntu/workspace/src-java/Database_code/config/ DB_Store_test

To run the python project need to execute
python produce_graph.py 