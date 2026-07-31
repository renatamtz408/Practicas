public class paqueteEnvio extends Paquete {
    public paqueteEnvio(int id, String nombredestinatario, double pesokg, String tipo, Envio estrategiaenvio) {
        super(id, nombredestinatario, pesokg, tipo, estrategiaenvio);
    }

    public paqueteEnvio(String nombredestinatario, double pesokg, String tipo, Envio estrategiaenvio) {
        super(nombredestinatario, pesokg, tipo, estrategiaenvio);
    }
}
