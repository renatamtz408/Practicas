public class Camion extends Vehiculo{
    public Camion(String placa, int horasestacionado,String tipo, Tarifa tarifa) {
        super(placa, horasestacionado,tipo, tarifa);
    }

    public Camion(int id, String placa, int horasestacionado, String tipo, Tarifa tarifa) {
        super(id, placa, horasestacionado, tipo, tarifa);
    }
}
