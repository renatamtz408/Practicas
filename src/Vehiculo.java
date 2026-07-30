public class Vehiculo {
    protected String placa;
    public int horasestacionado;
    protected Tarifa tarifa;

    public double calcularCostoEstacionamiento (){
        return tarifa.Calcular(horasestacionado);
    }

    public Vehiculo(String placa, int horasestacionado, Tarifa tarifa) {
        this.placa = placa;
        this.horasestacionado = horasestacionado;
        this.tarifa = tarifa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public int getHorasestacionado() {
        return horasestacionado;
    }

    public void setHorasestacionado(int horasestacionado) {
        this.horasestacionado = horasestacionado;
    }
}
