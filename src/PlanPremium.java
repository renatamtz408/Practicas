public class PlanPremium implements PlanSuscripcion{
    @Override
    public double calcularCosto(int meses) {
        return (14*meses)+3;
    }
}
