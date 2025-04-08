package Modelo;
import java.util.ArrayList;
public class Asignatura {
    private String codigo = "";
    private String grupo = "";
    private String semestre = "";
    private String nombre = "";
    private int creditos = 0;
    private ArrayList<Asistencia> asistencias = new ArrayList<Asistencia>();
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private ArrayList<String> codigos = new ArrayList<>();
    private ArrayList<String> tipos = new ArrayList<>();
    //Constructora con parámetros
    public Asignatura(String codigo, String grupo, String semestre, String nombre, int creditos){
        this.codigo = codigo;
        this.grupo = grupo;
        this.semestre = semestre;
        this.nombre = nombre;
        this.creditos = creditos;
    }
    //Constructora sin parámetros
    public Asignatura(){
        //creditos = 0;
    }
    //Getters and Setters
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getGrupo() {
        return grupo;
    }
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    public String getSemestre() {
        return semestre;
    }
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCreditos() {
        return creditos;
    }
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    public ArrayList<Asistencia> getAsistencias() {
        if (asistencias == null){
            return new ArrayList<>();
        }
        return asistencias;
    }
    public ArrayList<Estudiante> getEstudiantes() {
        if(estudiantes == null){
            return new ArrayList<>();
        }
        return estudiantes;
    }
    public ArrayList<String> getCodigos(){
        if(codigos == null){
            return new ArrayList<>();
        }
        return codigos;
    }
    public ArrayList<String>getTipos(){
        if(tipos == null){
            return new ArrayList<>();
        }
        return tipos;
    }
    //Método para mostrar toda la información de la asignatura
    @Override
    public String toString(){
        return "Información de la asignatura: \nNombre: "+nombre+"\nCódigo: "+codigo+"\nGrupo: "+grupo+"\nSemestre: "+semestre+"\nCréditos: "+creditos;
    }

    public boolean AgregarEstudiantes(String codigoEst, String name, String tipodoc){
        Estudiante student = new Estudiante(name, codigoEst, tipodoc);
        estudiantes.add(student);
        return true;
    }
    public boolean agregarCodigos(String codigoEst){
        String codigo = codigoEst;
        codigos.add(codigo);
        return true;
    }
    public boolean agregarTipos(String tipoEst){
        String codigo = tipoEst;
        codigos.add(tipoEst);
        return true;
    }
    //CRUD de asistencias
    //CREATE
    public boolean adicionarAsistencia(String fecha, String hora_de_incio, String hora_final, ArrayList<String> codigos, ArrayList<String> estados){
        Asistencia asistencia = new Asistencia(fecha, hora_de_incio, hora_final);
        for(int vc = 0; vc<codigos.size();vc++){
            String codigo = codigos.get(vc);
            String estado = estados.get(vc);
            asistencia.generarListaAsistencia(codigo, estado);
        }
        asistencias.add(asistencia);
        return true;
    }
    //READ
    public Asistencia consultarAsistencia(String fecha, String hora_de_inicio, String hora_final){
        for(int vc = 0; vc<asistencias.size();vc++){
            if(asistencias.get(vc).getFecha().equalsIgnoreCase(fecha) && asistencias.get(vc).getHora_de_inicio().equalsIgnoreCase(hora_de_inicio) && asistencias.get(vc).getHora_final().equalsIgnoreCase(hora_final)){
                return asistencias.get(vc);
            }
        }return null;
    }
    //UPDATE
    public boolean modificarAsistencia(String fecha, String hora_de_inicio, String hora_final, ArrayList<String> codigos, ArrayList<String> estados) {
        Asistencia laasistencia = this.consultarAsistencia(fecha, hora_de_inicio, hora_final);
        if (laasistencia != null) {
            laasistencia.setCodigos(codigos);
            laasistencia.setEstados(estados);
            return true;
        }
        return false;
    }
    //DELETE (no tiene mucho sentido eliminar una asistencia)
}
