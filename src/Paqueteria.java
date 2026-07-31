import java.util.ArrayList;

public class Paqueteria {
    public ArrayList<paqueteEnvio> listapaquetes;

    public Paqueteria() {
        this.listapaquetes = listapaquetes;
    }

    public void registrarpaquetes(paqueteEnvio p){
        listapaquetes.add(p);
    }
}
