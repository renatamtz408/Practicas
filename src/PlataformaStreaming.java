import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Usuario> getAll()throws Exception{
        try(Connection con= Conexion.getConexion();
        PreparedStatement stmt= con.prepareStatement("select * from Usuarios");
            ResultSet rs= stmt.executeQuery();
        ){
            List<Usuario> lista=new ArrayList<>();
            Usuario u= null;

            while(rs.next()){
                int id=rs.getInt("id");
                String correo=rs.getString("correo");
                int meses=rs.getInt("meses");
                String plan=rs.getString("plan_suscripcion");
                double costo= rs.getDouble("costo");

                if(plan.equals("Básico")){
                    Usuario u=new Usuario(id,correo,meses,plan,new PlanBasico());
                } else if (plan.equals("Estandar")) {
                    Usuario u=new Usuario(id,correo,meses,plan,new PlanEstandar());
                }else if(plan.equals("Premium")){
                    Usuario u=new Usuario(id,correo,meses,plan,new PlanPremium());
                }

            }

        }
    }
}
