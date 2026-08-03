import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class PlataformaStreaming {
    ArrayList<Usuario> listausuarios;

    public PlataformaStreaming() {
        this.listausuarios = new ArrayList<>();
    }

    public void registrarusuario(Usuario u){
        listausuarios.add(u);
    }

    public int save(Usuario u)throws Exception{
        try(Connection con =Conexion.getConexion();
            PreparedStatement stmt= con.prepareStatement("insert into Usuarios (correo,meses,plan_suscripcion,costo) values(?,?,?,?)");
        ){
            stmt.setString(1,u.getCorreoElectronico());
            stmt.setInt(2,u.getMesesActivo());
            stmt.setString(3,u.getPlan());
            stmt.setDouble(4,u.obtenerTotalAPagar());
            return stmt.executeUpdate();
        }
    }
}
