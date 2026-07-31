import java.util.ArrayList;

public abstract class Paquete {
    private int id;
    private String nombredestinatario;
    private double pesokg;
    private String tipo;
    public Envio estrategiaenvio;

    public Paquete(int id, String nombredestinatario, double pesokg, String tipo, Envio estrategiaenvio) {
        this.id = id;
        this.nombredestinatario = nombredestinatario;
        this.pesokg = pesokg;
        this.tipo = tipo;
        this.estrategiaenvio = estrategiaenvio;
    }

    public Paquete(String nombredestinatario, double pesokg, String tipo, Envio estrategiaenvio) {
        this.nombredestinatario = nombredestinatario;
        this.pesokg = pesokg;
        this.tipo = tipo;
        this.estrategiaenvio = estrategiaenvio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double obtenerCosto(){
        return estrategiaenvio.CalcularCosto(pesokg);
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
