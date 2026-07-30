public class Vehiculo {
    protected int id;
    protected String placa;
    public int horasestacionado;
    public String tipo;
    protected Tarifa tarifa;

    public double calcularCostoEstacionamiento (){
        return tarifa.Calcular(horasestacionado);
    }

    public Vehiculo(String placa, int horasestacionado, String tipo, Tarifa tarifa) {
        this.placa = placa;
        this.horasestacionado = horasestacionado;
        this.tipo = tipo;
        this.tarifa = tarifa;
    }

    public Vehiculo(int id, String placa, int horasestacionado, String tipo, Tarifa tarifa) {
        this.id = id;
        this.placa = placa;
        this.horasestacionado = horasestacionado;
        this.tipo = tipo;
        this.tarifa = tarifa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
