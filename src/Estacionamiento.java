import java.lang.classfile.instruction.StackInstruction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Estacionamiento {
    private ArrayList<Vehiculo> listaVehiculos;

    public Estacionamiento() {
        this.listaVehiculos = new ArrayList<>();
    }

    public void registro(Vehiculo v) {
        listaVehiculos.add(v);
    }

    public int save(Vehiculo v) throws Exception{
        try(Connection con=Conexion.getConexion();
        PreparedStatement stmt = con.prepareStatement("insert into Vehiculos (placa,horas,tipo,costo) values (?,?,?,?)");
        ){
            stmt.setString(1, v.placa);
            stmt.setInt(2,v.horasestacionado);
            stmt.setString(3,v.tipo);
            stmt.setDouble(4,v.calcularCostoEstacionamiento());
            return stmt.executeUpdate();
        }
    }

    public static List<Vehiculo> getAll() throws Exception{
        try(Connection con=Conexion.getConexion();
            PreparedStatement stmt= con.prepareStatement("select * from Vehiculos");
            ResultSet rs= stmt.executeQuery();
        ){
            List<Vehiculo> listavehiculos= new ArrayList<>();
            while (rs.next()){
               int id=rs.getInt("id");
               String placa=rs.getString("placa");
               int horas=rs.getInt("horas");
               String tipo=rs.getString("tipo");

               Vehiculo v=null;

               if(tipo.equals("Auto")){
                   v = new Auto(id, placa, horas, tipo, new TarifaAuto());
               } else if (tipo.equalsIgnoreCase("Moto")) {
                   v = new Moto(id, placa, horas, tipo, new TarifaMoto());
               } else if (tipo.equalsIgnoreCase("Camion")) {
                   v = new Camion(id, placa, horas, tipo, new TarifaCamion());
               }

                if (v != null) {
                    listavehiculos.add(v);
                }
            }
            return listavehiculos;
        }
    }

    public static int deleteid(int id)throws Exception{
        try(Connection con= Conexion.getConexion();
            PreparedStatement stmt= con.prepareStatement("delete from Vehiculos where id= ?");
        ){
            stmt.setInt(1,id);
            return stmt.executeUpdate();
        }
    }

    public static void contador()throws Exception{
        try(Connection con=Conexion.getConexion();
        PreparedStatement stmt= con.prepareStatement("select tipo, count(id) as total from Vehiculos group by tipo");
        ResultSet rs= stmt.executeQuery();
        ){
            while(rs.next()){
                String tipo=rs.getString("tipo");
                int cantidad =rs.getInt("total");
                System.out.println("------------------------");
                System.out.println("Tipo de Vehiculo: " +tipo+" | Cantidad: "+cantidad);
                System.out.println("------------------------");
            }

        }
    }

    public void imprimirReporte() {
        double dineroTotal = 0;
        System.out.println("REPORTE");
        for (Vehiculo v : listaVehiculos) {
            double costo = v.calcularCostoEstacionamiento();
            dineroTotal = dineroTotal + costo;

            String tipoVehiculo = "";
            if (v instanceof Auto) {
                tipoVehiculo = "Auto";
            } else if (v instanceof Moto) {
                tipoVehiculo = "Moto";
            } else if (v instanceof Camion) {
                tipoVehiculo = "Camion";
            }

            System.out.println("Tipo: " + tipoVehiculo +
                    " - Placa: " + v.getPlaca() +
                    " - Horas: " + v.getHorasestacionado() +
                    " - Total: $" + costo + " USD");
        }
        System.out.println("DINERO RECAUDADO EN EL DÍA: $" + dineroTotal + " USD");
    }
}
