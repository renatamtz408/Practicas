public class TarifaCamion implements Tarifa{
    @Override
    public double Calcular(int horas) {
        return (horas*4)+5;
    }
}
