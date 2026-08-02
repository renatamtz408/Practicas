public class Usuario extends CuentaUsuario{
    public Usuario(int id, int mesesActivo, String correoElectronico, String plan, PlanSuscripcion planSuscripcion) {
        super(id, mesesActivo, correoElectronico, plan, planSuscripcion);
    }

    public Usuario(String correoElectronico, int mesesActivo, String plan, PlanSuscripcion planSuscripcion) {
        super(correoElectronico, mesesActivo, plan, planSuscripcion);
    }
}
