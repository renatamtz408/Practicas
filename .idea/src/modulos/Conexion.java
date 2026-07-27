package modulos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static String server="localhost";
    public static String port="1433";
    public static String db="PlataformaStreaming";
    public static String user="Dearrollador";
    public static String psw="1234";

    public static String getCadenaConexion(){
        return String.format("jdbc:sqlserver://%s:%s;" +
                "databaseName=%s;" +
                "user=%s;" +
                "password=%s;" +
                "encrypt=true;" +
                "trustServerCertificate=true;",
                server,port,db,user,psw
        );
    }

    public static Connection getConexion()throws Exception{
        return DriverManager.getConnection(getCadenaConexion());
    }
}
