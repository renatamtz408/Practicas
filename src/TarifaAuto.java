public class TarifaAuto implements Tarifa{
    @Override
    public double Calcular(int horas) {
        return horas*2;
    }
}
