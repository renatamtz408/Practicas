import java.util.ArrayList;

public abstract class Paquete {
    private int id;
    private String nombredestinatario;
    private double pesokg;
    public Envio estrategiaenvio;

    public Paquete(int id,String nombredestinatario, double pesokg, Envio estrategiaenvio) {
        this.id=id;
        this.nombredestinatario = nombredestinatario;
        this.pesokg = pesokg;
        this.estrategiaenvio = estrategiaenvio;
    }

    public Paquete(String nombredestinatario, double pesokg, Envio estrategiaenvio) {
        this.nombredestinatario = nombredestinatario;
        this.pesokg = pesokg;
        this.estrategiaenvio = estrategiaenvio;
    }

    public void obtenerCosto(){
        estrategiaenvio.CalcularCosto(pesokg);
    }

    public String getNombredestinatario() {
        return nombredestinatario;
    }

    public void setNombredestinatario(String nombredestinatario) {
        this.nombredestinatario = nombredestinatario;
    }

    public double getPesokg() {
        return pesokg;
    }

    public void setPesokg(double pesokg) {
        this.pesokg = pesokg;
    }

    public Envio getEstrategiaenvio() {
        return estrategiaenvio;
    }

    public void setEstrategiaenvio(Envio estrategiaenvio) {
        this.estrategiaenvio = estrategiaenvio;
    }
}
