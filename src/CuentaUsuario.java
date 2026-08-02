public abstract class CuentaUsuario {
    private int id;
    private String correoElectronico;
    private int mesesActivo;
    private String plan;
    public PlanSuscripcion planSuscripcion;

    public double obtenerTotalAPagar(){
        return planSuscripcion.calcularCosto(mesesActivo);
    }

    public CuentaUsuario(int id, int mesesActivo, String correoElectronico, String plan, PlanSuscripcion planSuscripcion) {
        this.id = id;
        this.mesesActivo = mesesActivo;
        this.correoElectronico = correoElectronico;
        this.plan = plan;
        this.planSuscripcion = planSuscripcion;
    }

    public CuentaUsuario(String correoElectronico, int mesesActivo, String plan, PlanSuscripcion planSuscripcion) {
        this.correoElectronico = correoElectronico;
        this.mesesActivo = mesesActivo;
        this.plan = plan;
        this.planSuscripcion = planSuscripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getMesesActivo() {
        return mesesActivo;
    }

    public void setMesesActivo(int mesesActivo) {
        this.mesesActivo = mesesActivo;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public PlanSuscripcion getPlanSuscripcion() {
        return planSuscripcion;
    }

    public void setPlanSuscripcion(PlanSuscripcion planSuscripcion) {
        this.planSuscripcion = planSuscripcion;
    }
}
