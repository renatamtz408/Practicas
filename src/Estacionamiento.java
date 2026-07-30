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
            List<Vehiculo> listavehiculos= new ArrayList<>()
            while (rs.next()){
                listavehiculos.add(new Vehiculo(rs.getInt("id"),rs.getString("placa"),rs.getInt("horas"),rs.getString("tipo"),rs.getDouble("costo")));
            }
            return listavehiculos;
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
