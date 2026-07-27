package modulos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    //FORMA 1
    //private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Alumnos;instanceName=SQLEXPRESS;trustServerCertificate=true;encrypt=false;";
    //private static final String USER = "Desarrollador";
    //private static final String PASSWORD = "1234";
    //FORMA 2
    private static String server = "localhost";
    private static String port= "1433";
    private static String database= "Alumnos";
    private static String user="Desarrollador";
    private static String psw="1234";

    public static String getCadenaConexion(){
        return String.format("jbdc:sqlserver://%s:%s;" +
                "databaseName=%s;" +
                "user=%s;" +
                "password=%s" +
                "encrypt=true;" +
                "trustCertificateServer=true;,",
                server,port,database,user,psw
        );
    }

    public static Connection getConexion()throws Exception{
        return DriverManager.getConnection(getCadenaConexion());
    }




}
