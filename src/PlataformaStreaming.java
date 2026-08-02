import java.util.ArrayList;

public class PlataformaStreaming {
    ArrayList<Usuario> listausuarios;

    public PlataformaStreaming() {
        this.listausuarios = new ArrayList<>();
    }

    public void registrarusuario(Usuario u){
        listausuarios.add(u);
    }
}
