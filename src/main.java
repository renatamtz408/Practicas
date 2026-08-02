import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Paqueteria paqueteria=new Paqueteria();
        Scanner sc=new Scanner(System.in);
        int opc= 0;
        do{
            try{
                System.out.println("        MENU        ");
                System.out.println("1) Consultar tarifas.");
                System.out.println("2) Registrar Paquete");
                System.out.println("3) Imprimir lista de paquetes");
                System.out.println("4) Modificar destinatario");
                System.out.println("5) Eliminar registro de paquete");
                System.out.println("6) Contar por Estrategia");
                System.out.println("7) Imprimir Reporte");
                System.out.println("8) Salir");
                System.out.println("SELECCIONE UNA OPCIÓN: ");
                opc= sc.nextInt();
                sc.nextLine();
                switch (opc){
                    case 1:
                        System.out.println("TIPOS DE ENVIO");
                        System.out.println(" ");

                        System.out.println("Envio estandar:");
                        System.out.println("$2.00 USD por kg (entrega en 5 a 7 días hábiles).");
                        System.out.println(" ");

                        System.out.println("Envio express");
                        System.out.println("$4.50 USD por kg + un cargo fijo de $3.00 USD por manejo prioritario (entrega\n" +
                                "en 24 a 48 horas).");
                        System.out.println(" ");

                        System.out.println("Envio internacional");
                        System.out.println("$6.00 USD por kg + un recargo único de $10.00 USD en la primera factura\n" +
                                "por trámites aduaneros y seguro obligatorio.");
                        System.out.println(" ");
                        break;
                    case 2:
                        System.out.println("---REGISTRO DE PAQUETES---");
                        System.out.println("Ingrese el nombre de destinatario:");
                        String nombre=sc.nextLine();
                        System.out.println("Ingrese el peso en Kg del paquete:");
                        Double pesokg=sc.nextDouble();
                        System.out.println("Seleccione el tipo de envio:");
                        System.out.println("1) Estandar");
                        System.out.println("2) Express");
                        System.out.println("3) Internacional");
                        int tipo = sc.nextInt();
                        int cambios=0;
                        if(tipo==1){
                            String type="Envío Estandar";
                            paqueteEnvio p = new paqueteEnvio(nombre,pesokg,type,new EnvioEstandar());
                            paqueteria.registrarpaquetes(p);
                            cambios= paqueteria.save(p);
                        } else if (tipo==2) {
                            String type="Envío Express";
                            paqueteEnvio p = new paqueteEnvio(nombre,pesokg,type,new EnvioExpress());
                            paqueteria.registrarpaquetes(p);
                            cambios=paqueteria.save(p);
                        } else if (tipo==3) {
                            String type="Envío Internacional";
                            paqueteEnvio p = new paqueteEnvio(nombre,pesokg,type,new EnvioInternacional());
                            paqueteria.registrarpaquetes(p);
                            cambios=paqueteria.save(p);
                        }else{
                            System.out.println("Seleccione 1,2 o 3.");
                        }
                        if(cambios>0){
                            System.out.println("Paquete registrado.");
                        }else{
                            System.out.println("No se pudo registarr el paquete.");
                        }
                        break;
                    case 3:
                        System.out.println("---LISTA DE PAQUETES---");
                        ArrayList<paqueteEnvio> listap = paqueteria.getAll();
                        for (paqueteEnvio p : listap){
                            System.out.println("id: "+p.getId()+" |Destinatario: "+p.getNombredestinatario()+" | Peso: "+p.getPesokg()+
                                    "Kg | Estrategia: "+p.getEstrategiaenvio()+ "| Costo $"+p.obtenerCosto());
                        }
                        break;
                    case 4:
                        System.out.println("---CAMBIO DE DESTINATARIO---");
                        System.out.println("Ingrese el id del paquete: ");
                        int id= sc.nextInt();
                        sc.nextLine();
                        System.out.println("Ingrese el nuevo destinatario: ");
                        String nuevodest= sc.nextLine();
                        int cambios2 = paqueteria.update(id,nuevodest);
                        if(cambios2>0){
                            System.out.println("Información actualizada.");
                        }else{
                            System.out.println("No se encontro un paquete con ese id.");
                        }
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        System.out.println("Hasta pronto...");
                        break;
                    default:
                        System.out.println("Ingrese una opcción del menú.");
                }
            } catch (Exception e) {
                System.out.println("Ingrese un dato válido.");
                sc.nextLine();
                e.getMessage();
                e.printStackTrace();
            }
        }while (opc!=8);

    }
}
