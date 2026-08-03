import java.util.Scanner;

public class main {
    Scanner sc= new Scanner(System.in);
    PlataformaStreaming plataformaStreaming=new PlataformaStreaming();
    int opc=0;
    do{
        try{
            System.out.println("      MENÚ      ");
            System.out.println("1) Consultar planes.");
            System.out.println("2) Registrar usuario.");
            System.out.println("Seleccione una opcion del menú: ");
            opc=sc.nextInt();
            sc.nextLine();
            switch (opc){
                case 1:
                    System.out.println("1) Plan Básico: $5.00 USD por mes (Permite 1 pantalla, calidad SD).");
                    System.out.println("2) Plan Estándar: $9.00 USD por mes (Permite 2 pantallas, calidad Full.");
                    System.out.println("3) Plan Premium: $14.00 USD por mes + un recargo único de $3.00 USD " +
                            "en la primera factura por habilitar acceso a contenido 4K Ultra HD y audio espacial.");
                    break;
                case 2:
                    System.out.println("---REGISTRO DE USUARIO---");
                    System.out.println("Ingrese correo electronico:");
                    String correo=sc.nextLine();
                    System.out.println("Ingrese los meses de contrato:");
                    int meses = sc.nextInt();
                    System.out.println("1) Plan Básico");
                    System.out.println("2) Plan Estandar");
                    System.out.println("3) Plan Premium");
                    System.out.println("Seleccione el plan que desea contatar:");
                    int plan= sc.nextInt();
                    sc.nextLine();
                    String tipo="";
                    if(plan==1){
                        tipo="Básico";
                        Usuario u = new Usuario(correo,meses,tipo,new PlanBasico());
                        plataformaStreaming.registrarusuario(u);
                        plataformaStreaming.save(u);
                    }else if(plan==2){
                        tipo="Estandar";
                        Usuario u=new Usuario(correo,meses,tipo,new PlanEstandar());
                        plataformaStreaming.save(u);
                        plataformaStreaming.registrarusuario(u);
                    } else if (plan==3){
                        tipo="Premium";
                        Usuario u =new Usuario(correo,meses,tipo,new PlanPremium());
                        plataformaStreaming.save(u);
                        plataformaStreaming.registrarusuario(u);
                    }else{
                        System.out.println("Opcción inválida.");
                    }

            }
        } catch (Exception e) {
            System.out.println("Ingrese un dato válido.");
            sc.nextLine();
            e.getMessage();
            e.printStackTrace();
        }
    } while(opc!=3)
}
