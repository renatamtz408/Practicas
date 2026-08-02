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
            }
        } catch (Exception e) {
            System.out.println("Ingrese un dato válido.");
            sc.nextLine();
            e.getMessage();
            e.printStackTrace();
        }
    } while(opc!=3)
}
