
import java.sql.SQLOutput;
import java.util.Scanner;

public class main {
    Scanner sc = new Scanner (System.in);
    int opc=0;
    do{
        try{
            System.out.println("------- MENÚ -------");
            System.out.println("1) Registrar Estudiante");
            System.out.println("2) Ver lista de Alumnos");
            System.out.println("3) Modificar dato de Alumno");
            System.out.println("4) Eliminar Alumno");
            System.out.println("5) Contador por genero");
            System.out.println("6) Salir");
            System.out.println("Seleccione una opción:");
            opc= sc.nextInt();
            switch (opc){
                case 1:
                    System.out.println("REGISTRO DE ESTUDIANTE:");
                    System.out.println("Ingrese la matricula:");
                    System.out.println("Ingrese el nombre");
                    System.out.println("Ingrese la edad");
                    System.out.println("Ingrese el sexo: (F/M)");
                    System.out.println("Ingrese el correo:");
            }
        } catch (Exception e) {
            System.out.println("Ingrese un dato válido.");
            sc.nextLine();
        }
    }while (opc=!6);
}
