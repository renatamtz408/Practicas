public class PlanBasico implements PlanSuscripcion {
    @Override
    public double calcularCosto(int meses) {
        return meses*5;
    }
}
