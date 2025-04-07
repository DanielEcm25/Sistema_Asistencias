package Controlador;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElcontroladorTest {

    @Test
    void getDepartamento() {
    }

    @Test
    void setDepartamento() {
    }

    @Test
    void nombrarDepartamento() {
    }

    @Test
    void consultarNombreDepartamento() {
    }

    @Test
    void modificarDepartamento() {
    }

    @Test
    void agregarAsignatura() {
    }

    @Test
    void consultarAsignatura() {
    }

    @Test
    void modificarAsignatura() {
    }

    @Test
    void eliminarAsignatura() {
    }

    @Test
    void adicionarEstudiantes() {
    }

    @Test
    void adicionarAsistencia() {
    }

    @Test
    void consultarAsistencia() {
    }

    @Test
    void modificarAsistencia() {
    }
    @Test
    void pruebaNombraryConsultar(){
        Elcontrolador control = new Elcontrolador();
        control.nombrarDepartamento("Sistemas");
        String name = control.consultarNombreDepartamento();
        assertEquals(name,"Sistemas");
    }
    @Test
    void pruebaNombrarModificaryConsultar(){
        Elcontrolador control = new Elcontrolador();
        control.nombrarDepartamento("Ing. Sistemas");
        control.modificarDepartamento("Ing. Sistemas y computación");
        String name = control.consultarNombreDepartamento();
        assertEquals(name,"Ing. Sistemas y computación");
    }
    @Test
    void pruebaAgregarAsignatura(){
        Elcontrolador control = new Elcontrolador();
        control.agregarAsignatura("Cálculo","4","554433","401M","4");
        String nombre = control.consultarAsignatura("554433","401M","4").getNombre();
        assertEquals(nombre,"Cálculo");
    }
}