package Controlador;
import Modelo.Asignatura;
import Modelo.Asistencia;
import Modelo.Departamento;
import Modelo.Estudiante;

import java.util.ArrayList;
public class Elcontrolador {
    private Departamento departamento = null;

    //Constructora sin parámetro
    public Elcontrolador() {
        this.departamento = Departamento.singleton();
        this.departamento.setNombre("Ingeniería de sistemas y computación");
    }

    //GETTERS and SETTERS del departamento
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    //CRUD del departamento con solo el nombre
    //READ
    public String consultarNombreDepartamento() {
        return departamento.getNombre();
    }

    //UPDATE
    public boolean modificarDepartamento(String nuevo_nombre) {
        departamento.setNombre(nuevo_nombre);
        return true;
    }

    //DELETE
    //No tiene mucho sentido eliminar el departamento
    //Agregar estudiantes
    public boolean agregarEstudiantesDpto(String nombre, String doc, String tipo_doc) {
        departamento.agregarEstudiantes(nombre, doc, tipo_doc);
        return true;
    }

    //CRUD para Asignatura
    //CREATE
    public boolean agregarAsignatura(String nombre, String creditos, String codigo, String grupo, String semestre) {
        departamento.agregarAsignatura(nombre, Integer.parseInt(creditos), codigo, grupo, semestre);
        return true;
    }

    //READ
    public Asignatura consultarAsignatura(String codigo, String grupo, String semestre) {
        return departamento.consultarAsignatura(codigo, grupo, semestre);
    }

    //UPDATE
    public boolean modificarAsignatura(String codigo, String grupo, String semestre, String nombre, String creditos) {
        departamento.modificarAsignatura(codigo, grupo, semestre, nombre, Integer.parseInt(creditos));
        return true;
    }

    //DELETE
    public boolean eliminarAsignatura(String codigo, String grupo, String semestre) {
        departamento.eliminarAsignatura(codigo, grupo, semestre);
        return true;
    }

    public boolean AdicionarEstudiantesAsign(String codigo, String grupo, String semestre, String codigoEst, String name, String tipodoc) {
        departamento.consultarAsignatura(codigo, grupo, semestre).AgregarEstudiantes(codigoEst, name, tipodoc);
        return true;
    }
    public boolean AdicionarCodigosEst(String codigo, String grupo, String semestre, String codigoEst) {
        departamento.consultarAsignatura(codigo, grupo, semestre).agregarCodigos(codigoEst);
        return true;
    }
    public boolean AdicionarTiposEst(String codigo, String grupo, String semestre, String tipoEst) {
        departamento.consultarAsignatura(codigo, grupo, semestre).agregarTipos(tipoEst);
        return true;
    }
    //CRUD para Asistencia
    //CREATE
    public boolean adicionarAsistencia(String codigo, String grupo, String semestre, String fecha, String horaInicio, String horaFinal, ArrayList<String> codigosEstudiantes, ArrayList<String> estados){
        Asignatura asignatura = departamento.consultarAsignatura(codigo, grupo, semestre);
        if(asignatura != null){
            return asignatura.adicionarAsistencia(fecha, horaInicio, horaFinal, codigosEstudiantes, estados);
        }
        return false;
    }
    //READ
    public Asistencia consultarAsistencia(String codigo, String grupo, String semestre, String fecha, String horaInicio, String horaFinal){
        Asignatura asignatura = departamento.consultarAsignatura(codigo, grupo, semestre);
        if(asignatura != null){
            return asignatura.consultarAsistencia(fecha, horaInicio, horaFinal);
        }
        return null;
    }
    //UPDATE
    public boolean modificarAsistencia(String codigo, String grupo, String semestre, String fecha, String hora_de_inicio, String hora_final, ArrayList<String> codigos, ArrayList<String> estados){
        Asignatura asignatura = departamento.consultarAsignatura(codigo, grupo, semestre);
        if(asignatura!=null){
            boolean resultado = asignatura.modificarAsistencia(fecha,hora_de_inicio,hora_final,codigos,estados);
            return resultado;
        }
        return false;
    }
    //DELETE (no tiene mucho sentido eliminar una asistencia)
}