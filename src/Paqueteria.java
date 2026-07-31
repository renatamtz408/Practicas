import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class Paqueteria {
    public ArrayList<paqueteEnvio> listapaquetes;

    public Paqueteria() {
        this.listapaquetes = listapaquetes;
    }

    public void registrarpaquetes(paqueteEnvio p){
        listapaquetes.add(p);
    }

    public int save(paqueteEnvio p)throws Exception{
        try(Connection con=Conexion.getConexion();
            PreparedStatement stmt= con.prepareStatement("insert into Paquete (destinatario,peso,estrategia,costo) values (?,?,?,?)");
        ){
            stmt.setString(1,p.getNombredestinatario());
            stmt.setDouble(2,p.getPesokg());
            stmt.setString(3,p.getEstrategiaenvio());
            stmt.setDouble(4,p.obtenerCosto());
        }
    }
}
