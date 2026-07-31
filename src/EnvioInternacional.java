public class EnvioInternacional implements Envio{
    @Override
    public double CalcularCosto(double pesokg) {
        return (pesokg*6)+10;
    }
}
