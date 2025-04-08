package Modelo;
import java.util.ArrayList;
public class Departamento {
    private String nombre;
    private static ArrayList<Asignatura> asignaturas = null;
    private static ArrayList<Estudiante> estudiantes = null;
    private static Departamento instancia = null;
    //Constructora sin parámetros
    public Departamento() {

    }
    //Constructora con parámetros
    public Departamento(ArrayList<Asignatura> asignaturas, ArrayList<Estudiante> estudiantes){
        this.nombre = "Ingeniería de sistemas y computación";
        this.asignaturas = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
    }
    //Getters and Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public ArrayList<Asignatura> getAsignaturas() {
        if (asignaturas == null){
            asignaturas = new ArrayList<>();
        }
        return asignaturas;
    }
    public static ArrayList<Estudiante> getEstudiantes() {
        if(estudiantes == null){
            estudiantes = new ArrayList<>();
        }
        return estudiantes;
    }

    public static void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        Departamento.estudiantes = estudiantes;
    }
    //Método singleton (crear una única instancia)
    public static Departamento singleton() {
        if (instancia == null) {
            instancia = new Departamento();
        }
        return instancia;
    }
    //CRUD de asignatura
    //CREATE
    public boolean agregarAsignatura(String nombre, int creditos, String codigo, String grupo, String semestre) {
        Asignatura asignatura = new Asignatura(codigo, grupo, semestre, nombre, creditos);
        return getAsignaturas().add(asignatura);
    }

    //READ
    public Asignatura consultarAsignatura(String codigo, String grupo, String semestre) {
        if(asignaturas==null){
            return null;
        }
        for (int vc = 0; vc < asignaturas.size(); vc++) {
            Asignatura copia = asignaturas.get(vc);
            if (copia.getCodigo().equalsIgnoreCase(codigo) && copia.getGrupo().equalsIgnoreCase(grupo) && copia.getSemestre().equalsIgnoreCase(semestre) == true) {
                return copia;
            }
        }
        return null;
    }

    //Update
    public boolean modificarAsignatura(String codigo, String grupo, String semestre, String nombre, int creditos) {
        Asignatura asignatura = this.consultarAsignatura(codigo, grupo, semestre);
        if (asignatura != null) {
            asignatura.setNombre(nombre);
            asignatura.setCreditos(creditos);
            return true;
        }
        return false;
    }

    //Delete
    public boolean eliminarAsignatura(String codigo, String grupo, String semestre) {
        for (int vc = 0; vc < asignaturas.size(); vc++) {
            Asignatura copia = asignaturas.get(vc);
            if (copia.getCodigo().equalsIgnoreCase(codigo) && copia.getGrupo().equalsIgnoreCase(grupo) && copia.getSemestre().equalsIgnoreCase(semestre)) {
                asignaturas.remove(vc);
                return true;
            }
        }
        return false;
    }
    public boolean agregarEstudiantes(String nombre, String doc, String tipo_doc){
        Estudiante student = new Estudiante(nombre, doc, tipo_doc);
        return getEstudiantes().add(student);
    }
}