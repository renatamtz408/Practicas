import java.util.ArrayList;

public class Estacionamiento {
    private ArrayList<Vehiculo> listaVehiculos;

    public Estacionamiento() {
        this.listaVehiculos = new ArrayList<>();
    }

    public void registrarVehiculo(Vehiculo v) {
        listaVehiculos.add(v);
        System.out.println("El vehiculo ha sido registrado.");
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
