import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Paqueteria {
    public ArrayList<paqueteEnvio> listapaquetes;

    public Paqueteria() {
        this.listapaquetes = new ArrayList<>();
    }

    public void registrarpaquetes(paqueteEnvio p){
        listapaquetes.add(p);
    }

    public int save(paqueteEnvio p)throws Exception{
        try(Connection con=Conexion.getConexion();
            PreparedStatement stmt= con.prepareStatement("insert into Paquetes (destinatario,peso,estrategia,costo) values (?,?,?,?)");
        ){
            stmt.setString(1,p.getNombredestinatario());
            stmt.setDouble(2,p.getPesokg());
            stmt.setString(3,p.getTipo());
            stmt.setDouble(4,p.obtenerCosto());
            return stmt.executeUpdate();
        }
    }

    public ArrayList<paqueteEnvio> getAll()throws Exception{
        try(Connection con=Conexion.getConexion();
        PreparedStatement stmt= con.prepareStatement("select * from Paquetes");
        ){
            ArrayList<paqueteEnvio> lista=new ArrayList<>();
            ResultSet rs= stmt.getGeneratedKeys();
            while(rs.next()){
                int id=rs.getInt("id");
                String nombre=rs.getString("destinatario");
                double peso=rs.getDouble("peso");
                String estrategia=rs.getString("estrategia");
                double costo=rs.getDouble("costo");

                paqueteEnvio p=null;
                String tip="";

                if(estrategia.equals("Envío Estandar")){
                    tip="Estandar";
                    p= new paqueteEnvio(id,nombre,peso,tip, new EnvioEstandar());
                }else if(estrategia.equals("Envío Express")){
                    tip="Express";
                    p=new paqueteEnvio(id,nombre,peso,tip, new EnvioExpress());
                }else if(estrategia.equals("Envío Internacional")){
                    tip="Intenacional";
                    p=new paqueteEnvio(id,nombre,peso,tip,new EnvioInternacional());
                }

                if(p!=null){
                    lista.add(p);
                }
            }
            return lista;
        }
    }
}
