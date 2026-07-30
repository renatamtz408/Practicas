public class Auto extends Vehiculo{
    public Auto(String placa, int horasestacionado, String tipo, Tarifa tarifa) {
        super(placa, horasestacionado, tipo, tarifa);
    }

    public Auto(int id, String placa, int horasestacionado, String tipo, Tarifa tarifa) {
        super(id, placa, horasestacionado, tipo, tarifa);
    }
}
