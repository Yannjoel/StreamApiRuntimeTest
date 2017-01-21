package javastreamruntimetest.database;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseInitializer {

    public static void main(String[] args) throws Exception {
        initDatabase();
    }
    
    
    /**
     * Initializes the whole productiv db
     *
     * @throws SQLException
     * @throws Exception
     */
    public static void initDatabase() throws SQLException, Exception {
        if (reallyInitializeDb()) {
            Properties properties = DbAccessPropertiesReader.getProperties();
            String databaseName = properties.getProperty("mysqlproductivdatabase");
            System.out.println("Database-Initialization: starting database-initialization");
            System.out.println("Database-Initialization: setting up Connection to the database");
            Connection con = MysqlConnector.connectToProductivDatabaseUsingPropertiesFile();
            runInit(databaseName, con);
            System.out.println("finished database-initialization");
        } else {
            System.out.println("Canceled Initialisation");
        }
    }

    /**
     * Initializes the given database
     *
     * @param databaseName
     * @param con
     * @throws SQLException
     */
    private static void runInit(String databaseName, Connection con) throws SQLException {
        try (Statement statements = con.createStatement()) {
            System.out.println("Database-Initialization: deleting old Database - " + databaseName);
            statements.executeUpdate("DROP DATABASE IF EXISTS " + databaseName);

            System.out.println("Database-Initialization: creating new Databse");
            statements.executeUpdate("CREATE DATABASE " + databaseName);
            statements.executeUpdate("USE " + databaseName);

            statements.executeUpdate("CREATE TABLE javastreamtest ("+
                    "ID INT(32) UNSIGNED AUTO_INCREMENT PRIMARY KEY, "+
                    " VARCHAR(80) NOT NULL UNIQUE)"
            );

        }
    }

    private static boolean reallyInitializeDb() {
        try {
            System.out.println("Do you really want to initialize the database? This will delete all data inside of the database (Y/N)");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String input = in.readLine();
            if (input.equals("Y") | input.equals("y")) {
                return true;
            } else if (input.equals("N") | input.equals("n")) {
                return false;
            }
            else{
                System.out.println("Unknown input");
                return reallyInitializeDb();
            }
        } catch (Exception ex) {
            return false;
        }
    }
}
