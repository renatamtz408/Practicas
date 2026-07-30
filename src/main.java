import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        int opc = 0;
        Scanner teclado = new Scanner(System.in);
        Estacionamiento estacionamiento = new Estacionamiento();
        System.out.println("--- BIENVENIDO AL ESTACIONAMIENTO ---");
        do {
            try {
                System.out.println("MENU");
                System.out.println("1. Consultar Tarifas");
                System.out.println("2. Registrar Vehiculo");
                System.out.println("3. Reporte del Dia");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opcion: ");
                opc = teclado.nextInt();
                teclado.nextLine();
                switch (opc) {
                    case 1:
                        System.out.println("       TARIFAS   ");
                        System.out.println("Auto: $2 USD por hora.");
                        System.out.println("Moto: $1 USD por hora.");
                        System.out.println("Camion: $4 USD por hora + $5 USD por uso de suelo pesado.");
                        break;
                    case 2:
                        System.out.println("Imgrese la placa del vehiculo: ");
                        String placa = teclado.nextLine();
                        System.out.println("Ingrese las horas estacionado: ");
                        int horasestacionado = teclado.nextInt();
                        teclado.nextLine();
                        System.out.println("Seleccione el tipo de vehiculo: ");
                        System.out.println("1. Auto");
                        System.out.println("2. Moto");
                        System.out.println("3. Camion");
                        int tipo = teclado.nextInt();
                        if (tipo == 1) {
                            Auto auto = new Auto (placa, horasestacionado, new TarifaAuto());
                            estacionamiento.registrarVehiculo(auto);
                        } else if (tipo == 2) {
                            Moto moto = new Moto(placa, horasestacionado,new TarifaMoto());
                            estacionamiento.registrarVehiculo(moto);

                        } else if (tipo == 3) {
                            Camion camion = new Camion(placa, horasestacionado, new TarifaCamion());
                            estacionamiento.registrarVehiculo(camion);

                        } else {
                            System.out.println("Opcion invalida.");
                        }
                        break;

                    case 3:
                        estacionamiento.imprimirReporte();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ingrese una opccion valida");
                teclado.nextLine();
            }
        } while (opc != 4);
    }
}
