public class Moto extends Vehiculo{
    public Moto(String placa, int horasestacionado, String tipo, Tarifa tarifa) {
        super(placa, horasestacionado, tipo, tarifa);
    }

    public Moto(int id, String placa, int horasestacionado, String tipo, Tarifa tarifa) {
        super(id, placa, horasestacionado, tipo, tarifa);
    }
}
