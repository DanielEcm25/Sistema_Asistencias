package Modelo;
public class Estudiante {
    private String Nombre_Apellido = "";
    private String identificacion = "";
    private String tipo_doc = "";
    //Constructora con parámetros
    public Estudiante(String Nombre_Apellido, String identificacion, String tipo_doc){
        this.Nombre_Apellido = Nombre_Apellido;
        this.identificacion = identificacion;
        this.tipo_doc = tipo_doc;
    }
    //Constructora sin parámetros
    public Estudiante(){
    }
    //Getters and Setters
    public String getNombre_Apellido() {
        return Nombre_Apellido;
    }
    public void setNombre_Apellido(String nombre_Apellido) {
        Nombre_Apellido = nombre_Apellido;
    }
    public String getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    public String getTipo_doc() {
        return tipo_doc;
    }
    public void setTipo_doc(String tipo_doc) {
        this.tipo_doc = tipo_doc;
    }
}