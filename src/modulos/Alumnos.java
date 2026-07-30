package modulos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Alumnos {
    private int id;
    private String matricula;
    private String nombre;
    private int edad;
    private String sexo;
    private String correo;

    public Alumnos(String matricula, String nombre, int edad, String sexo, String correo) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.correo = correo;
    }

    private Alumnos(int id, String matricula, String nombre, int edad, String sexo, String correo) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.correo = correo;
    }

    public int save()throws Exception {
        try(Connection con=Conexion.getConexion();
            PreparedStatement stmt= con.prepareStatement("Insert into Alumnos (matricula,nombre,edad,sexo,correo) values (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
        ){
            stmt.setString(1,matricula);
            stmt.setString(2,nombre);
            stmt.setInt(3,edad);
            stmt.setString(4,sexo);
            stmt.setString(5, correo);
            int filascambiadas= stmt.executeUpdate();
            ResultSet rs= stmt.getGeneratedKeys();
            if (rs.next()){
                this.id=rs.getInt(1);
            }
            return filascambiadas;
        }
    }

    public static List<Alumnos> getAll() throws Exception{
        try( Connection con= Conexion.getConexion();
        PreparedStatement stmt= con.prepareStatement("select * from Alumnos");
        ResultSet rs= stmt.executeQuery();
        ){
            List<Alumnos> listaalumnos= new ArrayList<>();
            while(rs.next()) {
                listaalumnos.add(new Alumnos(rs.getInt("id"), rs.getString("matricula"), rs.getString("nombre"), rs.getInt("edad"), rs.getString("sexo"), rs.getString("correo")));
            }
            return listaalumnos;
        }
    }

    public static int update(String correo, String matricula) throws Exception{
        try(Connection con=Conexion.getConexion();
        PreparedStatement stmt= con.prepareStatement("update Alumnos set correo=? where matricula=?");
        ){
            stmt.setString(1,correo);
            stmt.setString(2,matricula);
            return stmt.executeUpdate();
        }
    }

    public static int delete(String matricula)throws Exception{
        try(Connection con=Conexion.getConexion();
        PreparedStatement stmt= con.prepareStatement("delete from Alumnos where matricula=?")
        ){
            stmt.setString(1,matricula);
            return stmt.executeUpdate();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
