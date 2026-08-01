import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static String server="localhost";
    private static String port="1433";
    private static String db="Paquetes";
    private static String user="Desarrollador";
    private static String psw="1234";

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
