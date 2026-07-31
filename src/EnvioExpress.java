public class EnvioExpress implements Envio{
    @Override
    public double CalcularCosto(double pesokg) {
        return (pesokg*4.5)+3;
    }
}
