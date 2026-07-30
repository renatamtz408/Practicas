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
                System.out.println("3. Lista de Vehiculos");
                System.out.println("5. Reporte del Dia");
                System.out.println("6. Salir");
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
                        String tipos= "";
                        if (tipo == 1) {
                            tipos="Auto";
                            Auto auto = new Auto (placa, horasestacionado, tipos,new TarifaAuto());
                            estacionamiento.save(auto);
                        } else if (tipo == 2) {
                            tipos="Moto";
                            Moto moto = new Moto(placa, horasestacionado,tipos,new TarifaMoto());
                            estacionamiento.save(moto);

                        } else if (tipo == 3) {
                            tipos="Camion";
                            Camion camion = new Camion(placa, horasestacionado,tipos, new TarifaCamion());
                            estacionamiento.save(camion);

                        } else {
                            System.out.println("Opcion invalida.");
                        }
                        break;
                    case 3:
                        System.out.println("---LISTA DE VEHICULOS---");
                        estacionamiento.get
                    case 5:
                        estacionamiento.imprimirReporte();
                        break;
                    default:
                        System.out.println("bye...");
                }
            } catch (Exception e) {
                System.out.println("Ingrese una opccion valida");
                e.printStackTrace();
                e.getMessage();
                teclado.nextLine();
            }
        } while (opc != 4);
    }
}
