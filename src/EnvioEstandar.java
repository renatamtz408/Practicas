public class EnvioEstandar implements Envio{
    @Override
    public double CalcularCosto(double pesokg) {
        return pesokg*2;
    }
}
