
import modulos.Alumnos;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    int opc= 0;
    do{
        try{
            System.out.println("------- MENÚ -------");
            System.out.println("1) Registrar Estudiante");
            System.out.println("2) Ver lista de Alumnos");
            System.out.println("3) Modificar correo de Alumno");
            System.out.println("4) Eliminar Alumno");
            System.out.println("5) Contador por genero");
            System.out.println("6) Salir");
            System.out.println("Seleccione una opción:");
            opc= sc.nextInt();
            switch (opc){
                case 1:
                    System.out.println("---REGISTRO DE ESTUDIANTE---");
                    System.out.println("Ingrese la matricula:");
                    String matricula= sc.next();
                    System.out.println("Ingrese el nombre:");
                    String nombre = sc.next();
                    System.out.println("Ingrese la edad");
                    int edad=sc.nextInt();
                    System.out.println("Ingrese el sexo: (F/M)");
                    sc.nextLine();
                    String sexo=sc.next();
                    System.out.println("Ingrese el correo:");
                    String correo =sc.next();
                    Alumnos alumno =new Alumnos(matricula,nombre,edad,sexo,correo);
                    int resultado= alumno.save();
                    if(resultado>0){
                        System.out.println("Alumno registrado correctamente.");
                        System.out.println("ID Asignado: "+alumno.getId());
                        System.out.println("----------------------");
                    } else {
                        System.out.println("No se ha podido registrar el alumno.");
                    }
                    break;
                case 2:
                    System.out.println("---LISTA DE ALUMNOS---");
                    List<Alumnos> lista= Alumnos.getAll();
                    for (Alumnos a : lista) {
                        System.out.println("Id: " + a.getId() +
                                " Matricula: " + a.getMatricula() +
                                " Nombre: " + a.getNombre() +
                                " Edad: " + a.getEdad() +
                                " Sexo: " + a.getSexo() +
                                " Correo: " + a.getCorreo());
                        System.out.println("___________________________");
                    }
                    break;
                case 3:
                    System.out.println("---MODIFICAR CORREO DE ALUMNO---");
                    System.out.println("Ingrese la matricula del alumno: ");
                    String matriculamod=sc.next();
                    System.out.println("Ingrese el nuevo correo: ");
                    String nuevocorreo= sc.next();
                    int filasCambiadas= Alumnos.update(nuevocorreo,matriculamod);
                    if(filasCambiadas>0){
                        System.out.println("Cambio registrado con éxito.");
                    }else{
                        System.out.println("No se encontro la matricula.");
                    }
                    break;
                case 4:
                    System.out.println("---ELIMINAR ALUMNO---");
                    System.out.println("Ingrese la matricula del alumno: ");
                    String matriculaEliminar=sc.next();
                    int filasAfectadas= Alumnos.delete(matriculaEliminar);
                    break;
                case 5:

                case 6:
                    System.out.println("Hasta pronto...");
                    break;
                default:
                    System.out.println("Ingrese una opciòn del menù.");
            }
        } catch (Exception e) {
            System.out.println("Error real: " + e.getMessage()); // <-- Cambia esto
            e.printStackTrace();
        }
    } while (opc != 6);
}
}