package Vista;
import Controlador.Elcontrolador;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        /*Cree un programa que maneje la asistencia en cualquier curso de ing de sistemas y computación. El manejo de
        las asistencias que un curso puede tener
        más de un horario
        más de un grupo y tres estados en la asistencia (llego a la hora correcta, a la hora correcta
        y no llego*/
        Scanner entrada = new Scanner(System.in);
        Elcontrolador controlVar = new Elcontrolador();
        String opcion = "";
        while(opcion.equals("15")==false){
            System.out.println("\nMenú principal");
            System.out.println("1. Consultar departamento");
            System.out.println("2. Modificar nombre del departamento");
            System.out.println("3. Registrar estudiantes en el departamento");
            System.out.println("4. Consultar estudiante en el departamento");
            System.out.println("5. Modificar estudiantes del departamento");
            System.out.println("6. Adicionar Asignatura");
            System.out.println("7. Consultar Asignatura");
            System.out.println("8. Modificar Asignatura");
            System.out.println("9. Registrar estudiantes en una asignatura");
            System.out.println("10. Consultar estudiantes en asignatura");
            System.out.println("11. Generar lista de asistencia vacía");
            System.out.println("12. Llenar asistencia");
            System.out.println("13. Modificar asistencia");
            System.out.println("14. Consultar asistencia");
            System.out.println("15. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextLine();
            if (opcion.equals("1")){ //Consultar departamento
                    System.out.println("Nombre del departamento: "+controlVar.consultarNombreDepartamento());
            }else if(opcion.equals("2")) { //Modificar nombre del departamento
                    System.out.println("Ingrese el nuevo nombre del departamento");
                    String nombre = entrada.nextLine();
                    controlVar.modificarDepartamento(nombre);
                    System.out.println("El nombre del departamento se modificó");
            }else if(opcion.equals("3")) { //Registrar estudiantes en el departamento
                boolean agregarmas = true;
                while (agregarmas) {
                    System.out.println("Ingrese el código del estudiante: ");
                    String codigoEst = entrada.nextLine();
                    System.out.println("Ingrese el nombre el estudiante: ");
                    String name = entrada.nextLine();
                    System.out.println("Ingrese el tipo de documento (TI ó CC)");
                    String tipodoc = entrada.nextLine().toUpperCase();
                    controlVar.agregarEstudiantesDpto(name, codigoEst, tipodoc);
                    System.out.println("Estudiante registrado");
                    System.out.println("¿Desea seguir agregando estudiantes (S/N)?");
                    String more = entrada.nextLine();
                    if (more.equalsIgnoreCase("N")) {
                        agregarmas = false;
                    }
                }
                System.out.println("Proceso finalizado");
            }else if(opcion.equals("4")){ //Consultar estudiantes del departamento
                if(controlVar.getDepartamento().getEstudiantes().isEmpty()){
                    System.out.println("Aún no hay estudiantes inscritos en el departamento");
                }else {
                    System.out.println("Ingrese el tipo de documento del estudiante: ");
                    String tipSearch = entrada.nextLine().toUpperCase();
                    System.out.println("Ingrese el documento del estudiante: ");
                    String docSearch = entrada.nextLine();
                    boolean isencontrado = false;
                    for (int search = 0; search < controlVar.getDepartamento().getEstudiantes().size(); search++) {
                        String id = controlVar.getDepartamento().getEstudiantes().get(search).getIdentificacion();
                        String tipo = controlVar.getDepartamento().getEstudiantes().get(search).getTipo_doc();
                        if (docSearch.equalsIgnoreCase(id) && tipSearch.equalsIgnoreCase(tipo) == true) {
                            String nombStu = controlVar.getDepartamento().getEstudiantes().get(search).getNombre_Apellido();
                            System.out.println("Información del estudiante: ");
                            System.out.println("Código " + id + "(" + tipo + ")");
                            System.out.println("Nombre: " + nombStu);
                            isencontrado = true;
                        }
                    }
                    if(!isencontrado){
                        System.out.println("No se encontró al estudiante");
                    }
                }
                System.out.println("Proceso finalizado");
            }else if(opcion.equals("5")){//Modificar estudiantes del departamento
                if(controlVar.getDepartamento().getEstudiantes().isEmpty()){
                    System.out.println("Aún no hay estudiantes inscritos en el departamento");
                }else {
                    boolean isencontrado = false;
                    System.out.println("Ingrese el tipo de documento del estudiante: ");
                    String tipSearch = entrada.nextLine().toUpperCase();
                    System.out.println("Ingrese el documento del estudiante: ");
                    String docSearch = entrada.nextLine();
                    for (int search = 0; search < controlVar.getDepartamento().getEstudiantes().size(); search++) {
                        String id = controlVar.getDepartamento().getEstudiantes().get(search).getIdentificacion();
                        String tipo = controlVar.getDepartamento().getEstudiantes().get(search).getTipo_doc();
                        if (docSearch.equalsIgnoreCase(id) && tipSearch.equalsIgnoreCase(tipo) == true) {
                            System.out.println("Estudiante encontrado");
                            isencontrado = true;
                            System.out.println("Por favor indique qué desea modificar (Nombre (N) o tipo de documento (T))");
                            String eleccion = entrada.nextLine();
                            while (true) {
                                if(eleccion.equalsIgnoreCase("N")){
                                    System.out.println("Ingrese el nuevo nombre del estudiante: ");
                                    String newName = entrada.nextLine();
                                    controlVar.getDepartamento().getEstudiantes().get(search).setNombre_Apellido(newName);
                                    System.out.println("El nombre se cambió exitosamente");
                                    break;
                                }else if(eleccion.equalsIgnoreCase("T")){
                                    System.out.println("Ingrese el nuevo tipo de documento del estudiante (TI ó CC): ");
                                    String newTipo = entrada.nextLine();
                                    controlVar.getDepartamento().getEstudiantes().get(search).setTipo_doc(newTipo);
                                    System.out.println("El tipo de documento se cambió exitosamente");
                                    break;
                                }
                            }
                        }
                    }
                    if(!isencontrado){
                        System.out.println("El estudiante no se encontró");
                    }
                }
                System.out.println("Proceso finalizado");
            }else if(opcion.equals("6")) { //Adicionar Asignatura
                System.out.println("Digite la información de la asignatura.");
                System.out.print("Nombre: ");
                String name = entrada.nextLine();
                System.out.print("Créditos: ");
                String creditos = entrada.nextLine();
                System.out.print("Código: ");
                String codigo = entrada.nextLine();
                System.out.print("Grupo: ");
                String grupo = entrada.nextLine();
                System.out.print("Semestre: ");
                String semestre = entrada.nextLine();
                controlVar.agregarAsignatura(name, creditos, codigo, grupo, semestre);
                System.out.println("Asignatura agregada con éxito");
            }else if(opcion.equals("7")){ //Consultar Asignatura
                if(controlVar.getDepartamento().getAsignaturas().isEmpty()) {
                    System.out.println("Aun no se ha registrado una asignatura");
                }else{
                    System.out.print("Código: ");
                    String codConsulta = entrada.nextLine();
                    System.out.print("Grupo: ");
                    String grupoConsulta = entrada.nextLine();
                    System.out.print("Semestre: ");
                    String semConsulta = entrada.nextLine();
                    if (controlVar.consultarAsignatura(codConsulta, grupoConsulta, semConsulta) != null) {
                        System.out.println("Asignatura encontrada.");
                        System.out.println(controlVar.consultarAsignatura(codConsulta, grupoConsulta, semConsulta));
                    } else {
                        System.out.println("Asignatura no encontrada.");
                    }
                }
            }else if(opcion.equals("8")){ //Modificar Asignatura
                if(controlVar.getDepartamento().getAsignaturas().isEmpty()) {
                    System.out.println("Aun no se ha registrado una asignatura");
                }else{
                    System.out.println("Info de la asignatura a modificar");
                    System.out.print("Código: ");
                    String codModi = entrada.nextLine();
                    System.out.print("Grupo: ");
                    String grupoModi = entrada.nextLine();
                    System.out.print("Semestre: ");
                    String semModi = entrada.nextLine();
                    if(controlVar.consultarAsignatura(codModi,grupoModi,semModi)==null){
                        System.out.println("No se encontró la asignatura");
                    }else{
                        System.out.println("Solo puede modificar el nombre y los créditos");
                        System.out.print("Nuevo Nombre: ");
                        String nuevoNombre = entrada.nextLine();
                        System.out.print("Nuevos Créditos: ");
                        String nuevosCreditos = entrada.nextLine();
                        controlVar.modificarAsignatura(codModi, grupoModi, semModi, nuevoNombre, nuevosCreditos);
                        System.out.println("La asignatura se modificó con éxito");
                    }
                }
            }else if(opcion.equals("9")){ //Registrar estudiantes en una asignatura
                if(controlVar.getDepartamento().getAsignaturas().isEmpty()) {
                    System.out.println("Aun no se ha registrado una asignatura");
                }else {
                    System.out.println("Ingrese el código de la asignatura:");
                    String codigo = entrada.nextLine();
                    System.out.println("Ingrese el grupo de la asignatura: ");
                    String grupo = entrada.nextLine();
                    System.out.println("Ingrese el semestre de la asignatura: ");
                    String semestre = entrada.nextLine();
                    if (controlVar.consultarAsignatura(codigo, grupo, semestre) == null) {
                        System.out.println("La asignatura no existe");
                    }else{
                        System.out.println("Asignatura: "+controlVar.consultarAsignatura(codigo, grupo, semestre).getNombre());
                        boolean agregarmas = true;
                        while (agregarmas) {
                            System.out.println("Ingrese el código del estudiante: ");
                            String codigoEst = entrada.nextLine();
                            System.out.println("Ingrese el tipo de documento (TI ó CC)");
                            String tipodoc = entrada.nextLine().toUpperCase();
                            boolean isencontrado = false;
                            for (int add = 0; add < controlVar.getDepartamento().getEstudiantes().size(); add++) {
                                String id = controlVar.getDepartamento().getEstudiantes().get(add).getIdentificacion();
                                String tipo = controlVar.getDepartamento().getEstudiantes().get(add).getTipo_doc();
                                if (codigoEst.equalsIgnoreCase(id) && tipodoc.equalsIgnoreCase(tipo) == true) {
                                    String nombStu = controlVar.getDepartamento().getEstudiantes().get(add).getNombre_Apellido();
                                    controlVar.AdicionarEstudiantesAsign(codigo, grupo, semestre, codigoEst, nombStu, tipodoc);
                                    controlVar.AdicionarCodigosEst(codigo,grupo,semestre,codigoEst);
                                    controlVar.AdicionarTiposEst(codigo,grupo,semestre,tipodoc);
                                    isencontrado = true;
                                    System.out.println("Estudiante agregado");
                                    break;
                                }
                            }
                            if(!isencontrado) {
                                System.out.println("El estudiante que se intenta registrar no está registrado en el departamento");
                            }
                            System.out.println("¿Desea seguir agregando estudiantes (S/N)?");
                            String more = entrada.nextLine();
                            if (more.equalsIgnoreCase("N")) {
                                agregarmas = false;
                                System.out.println("Proceso finalizado");
                            }
                        }
                    }
                }
            }else if(opcion.equals("10")) { //Consultar estudiantes en asignatura
                if(controlVar.getDepartamento().getAsignaturas().isEmpty()){
                    System.out.println("Aún no hay asignaturas registradas");
                }else{
                    System.out.println("Ingrese la información de la asignatura: ");
                    System.out.println("Código:");
                    String codeSearch = entrada.nextLine();
                    System.out.println("Grupo:");
                    String grupoSearch = entrada.nextLine();
                    System.out.println("Semestre:");
                    String semestreSearch = entrada.nextLine();
                    if(controlVar.consultarAsignatura(codeSearch,grupoSearch,semestreSearch) == null){
                        System.out.println("La asignatura no existe");
                    }else{
                        String nomAsig = controlVar.consultarAsignatura(codeSearch,grupoSearch,semestreSearch).getNombre();
                        System.out.println("Asignatura: "+nomAsig);
                        System.out.println("Lista de estudiantes: ");
                        if(controlVar.consultarAsignatura(codeSearch,grupoSearch,semestreSearch).getEstudiantes().isEmpty()){
                            System.out.println("Aun no se han registrado estudiantes");
                        }else{
                            for(int info = 0; info<controlVar.consultarAsignatura(codeSearch,grupoSearch,semestreSearch).getEstudiantes().size(); info++){
                                String codigo = controlVar.consultarAsignatura(codeSearch,grupoSearch,semestreSearch).getCodigos().get(info);
                                String tipo = controlVar.consultarAsignatura(codeSearch,grupoSearch,semestreSearch).getTipos().get(info);
                                System.out.println("Documento: "+codigo);
                                System.out.println("Tipo: "+tipo+"\n");
                            }
                        }
                    }
                    System.out.println("Proceso finalizado");
                }
            }else if(opcion.equals("11")) { //Generar lista de asistencia
                if(controlVar.getDepartamento().getAsignaturas().isEmpty()){
                    System.out.println("Aun no hay asignaturas registradas");
                }else{
                    System.out.println("Ingrese la información de la asignatura de la que va a generar la lista de asistencia: ");
                    System.out.print("Código asignatura: ");
                    String codigoAs = entrada.nextLine();
                    System.out.print("Grupo: ");
                    String grupoAs = entrada.nextLine();
                    System.out.print("Semestre: ");
                    String semestreAs = entrada.nextLine();
                    if (controlVar.consultarAsignatura(codigoAs, grupoAs, semestreAs) == null) {
                        System.out.println("La asignatura no existe");
                    } else {
                        System.out.println("Asignatura: " + controlVar.consultarAsignatura(codigoAs, grupoAs, semestreAs).getNombre());
                        System.out.println("Ingrese información de la asistencia: ");
                        System.out.print("Fecha (aaaa/mm/dd): ");
                        String fecha = entrada.nextLine();
                        System.out.print("Hora de inicio (Formato 24H): ");
                        String horaInicio = entrada.nextLine();
                        System.out.print("Hora final (Formato 24H): ");
                        String horaFinal = entrada.nextLine();
                        if (controlVar.consultarAsistencia(codigoAs, grupoAs, semestreAs, fecha, horaInicio, horaFinal) != null) {
                            System.out.println("La asistencia de esta asignatura en la fecha indicada ya se generó.");
                        } else {
                            boolean hayestudiantes = false;
                            ArrayList<String> codigos = new ArrayList<>();
                            ArrayList<String> estados = new ArrayList<>();
                            for (int stu = 0; stu < controlVar.consultarAsignatura(codigoAs, grupoAs, semestreAs).getEstudiantes().size(); stu++) {
                                if (controlVar.consultarAsignatura(codigoAs, grupoAs, semestreAs).getEstudiantes().isEmpty()) {
                                    System.out.println("No hay estudiantes en esta asignatura aún");
                                } else {
                                    hayestudiantes = true;
                                    codigos.add(controlVar.consultarAsignatura(codigoAs, grupoAs, semestreAs).getEstudiantes().get(stu).getIdentificacion());
                                    estados.add("No asistió");
                                }
                            }
                            if (hayestudiantes) {
                                controlVar.adicionarAsistencia(codigoAs, grupoAs, semestreAs, fecha, horaInicio, horaFinal, codigos, estados);
                                System.out.println("Lista de asistencia generada");
                            }
                        }
                    }
                }
            }else if(opcion.equals("12")){ //Llenar asistencia
                if(controlVar.getDepartamento().getAsignaturas().isEmpty()){
                    System.out.println("Aún no se ha registrado ninguna asignatura");
                }else {
                    System.out.println("Ingrese la información de la asignatura: ");
                    System.out.print("Código asignatura: ");
                    String codigo = entrada.nextLine();
                    System.out.print("Grupo asignatura: ");
                    String grupo = entrada.nextLine();
                    System.out.print("Semestre asignatura: ");
                    String semestre = entrada.nextLine();
                    if (controlVar.consultarAsignatura(codigo, grupo, semestre) == null) {
                        System.out.println("La asignatura no existe o hay algún error en la digitación de sus datos");
                    } else {
                        System.out.print("Fecha asistencia: ");
                        String fecha = entrada.nextLine();
                        System.out.print("Hora de inicio: ");
                        String horaInicio = entrada.nextLine();
                        System.out.print("Hora final: ");
                        String horaFinal = entrada.nextLine();
                        if (controlVar.consultarAsistencia(codigo, grupo, semestre, fecha, horaInicio, horaFinal) == null) {
                            System.out.println("No se pudo encontrar la asistencia.");
                        } else {
                            System.out.println("Asistencia encontrada:");
                            System.out.println("Fecha: " + controlVar.consultarAsistencia(codigo, grupo, semestre, fecha, horaInicio, horaFinal).getFecha());
                            System.out.println("Hora de inicio: " + controlVar.consultarAsistencia(codigo, grupo, semestre, fecha, horaInicio, horaFinal).getHora_de_inicio());
                            System.out.println("Hora final: " + controlVar.consultarAsistencia(codigo, grupo, semestre, fecha, horaInicio, horaFinal).getHora_final());
                            for (int asis = 0; asis < controlVar.consultarAsignatura(codigo, grupo, semestre).getEstudiantes().size(); asis++) {
                                String nombreEst = controlVar.consultarAsignatura(codigo, grupo, semestre).getEstudiantes().get(asis).getNombre_Apellido();
                                String nuevoEstado;
                                while (true) {
                                    System.out.println("Asistencia de " + nombreEst + " (0 = No asistió, 1 = Retraso, 2 = A tiempo):");
                                    nuevoEstado = entrada.nextLine();
                                    if (nuevoEstado.equals("0") || nuevoEstado.equals("1") || nuevoEstado.equals("2")) {
                                        break;
                                    } else {
                                        System.out.println("Por favor, ingrese uno de los siguientes valores: 0, 1 ó 2.");
                                    }
                                }
                                String state = "";
                                if (nuevoEstado.equals("0")) {
                                    state = "No asistió";
                                } else if (nuevoEstado.equals("1")) {
                                    state = "Retraso";
                                } else if (nuevoEstado.equals("2")) {
                                    state = "Asistió a tiempo";
                                }
                                controlVar.consultarAsistencia(codigo, grupo, semestre, fecha, horaInicio, horaFinal).modificarAsistencia(controlVar.consultarAsignatura(codigo, grupo, semestre).getEstudiantes().get(asis).getIdentificacion(), state);
                            }
                            System.out.println("Asistencia registrada.");
                        }
                        controlVar.modificarAsistencia(codigo, grupo, semestre, fecha, horaInicio, horaFinal, controlVar.consultarAsistencia(codigo, grupo, semestre, fecha, horaInicio, horaFinal).getCodigos(), controlVar.consultarAsistencia(codigo, grupo, semestre, fecha, horaInicio, horaFinal).getEstados());
                    }
                }
            }else if(opcion.equals("13")){ //modificar asistencia de un estudiante
                if(controlVar.getDepartamento().getAsignaturas().isEmpty()){
                    System.out.println("Aun no se han registrado asignaturas");
                }else{
                    System.out.println("Ingrese la información de la asignatura: ");
                    System.out.println("Código de la asignatura: ");
                    String codigo = entrada.nextLine();
                    System.out.println("Grupo de la asignatura: ");
                    String grupo = entrada.nextLine();
                    System.out.println("Semestre de la asignatura: ");
                    String semestre = entrada.nextLine();
                    if(controlVar.consultarAsignatura(codigo,grupo,semestre) == null){
                        System.out.println("La asignatura no existe o hay algun error en la digitación de sus datos");
                    }else{
                        String nombre = controlVar.consultarAsignatura(codigo,grupo,semestre).getNombre();
                        System.out.println("Asignatura: "+nombre);
                        if(controlVar.consultarAsignatura(codigo,grupo,semestre).getAsistencias().isEmpty()){
                            System.out.println("Aun no se han registrado asistencias");
                        }else{
                            System.out.println("Digite la información de la asistencia: ");
                            System.out.println("Fecha (aaaa/mm/dd): ");
                            String fecha = entrada.nextLine();
                            System.out.println("Hora inicial (formato 24H): ");
                            String hora_inicio = entrada.nextLine();
                            System.out.println("Hora final (formato 24H): ");
                            String hora_final = entrada.nextLine();
                            if(controlVar.consultarAsistencia(codigo,grupo,semestre,fecha,hora_inicio,hora_final) == null){
                                System.out.println("No se encontró la asistencia registrada");
                            }else{
                                System.out.println("Asistencia encontrada");
                                String date = controlVar.consultarAsistencia(codigo,grupo,semestre,fecha,hora_inicio,hora_final).getFecha();
                                System.out.println("Fecha: "+date);
                                System.out.println("Ingrese la información del estudiante que desea cambiar: ");
                                System.out.println("Código: ");
                                String doc = entrada.nextLine();
                                System.out.println("Tipo de documento (CC ó TI): ");
                                String tipodoc = entrada.nextLine().toUpperCase();
                                boolean isencontrado = false;
                                for(int info = 0; info<controlVar.consultarAsignatura(codigo,grupo,semestre).getEstudiantes().size(); info++){
                                    String id = controlVar.consultarAsistencia(codigo,grupo,semestre,fecha,hora_inicio,hora_final).getCodigos().get(info);
                                    String type = controlVar.consultarAsignatura(codigo,grupo,semestre).getEstudiantes().get(info).getTipo_doc();
                                    if(id.equalsIgnoreCase(doc) && type.equalsIgnoreCase(tipodoc)){
                                        System.out.println("Estudiante encontrado");
                                        controlVar.consultarAsistencia(codigo,grupo,semestre,fecha,hora_inicio,hora_final).getEstados().set(info,"Retraso");
                                        System.out.println("Asistencia de "+id+" cambiada a: Retraso");
                                        isencontrado = true;
                                    }
                                }
                                if(!isencontrado){
                                    System.out.println("No se encontró al estudiante");
                                }
                            }
                        }
                    }
                }
                System.out.println("Proceso finalizado");
            }else if(opcion.equals("14")) {  //Consultar asistencia
                if(controlVar.getDepartamento().getAsignaturas().isEmpty()){
                    System.out.println("Aún no se ha registrado ninguna asignatura");
                }else {
                    System.out.println("Ingrese la información de la asignatura: ");
                    System.out.print("Código asignatura: ");
                    String codigo = entrada.nextLine();
                    System.out.print("Grupo asignatura: ");
                    String grupo = entrada.nextLine();
                    System.out.print("Semestre asignatura: ");
                    String semestre = entrada.nextLine();
                    if (controlVar.consultarAsignatura(codigo, grupo, semestre) == null) {
                        System.out.println("No se encontró la asignatura");
                    } else {
                        System.out.println("Asignatura encontrada");
                        System.out.println("Ingrese la información de la asistencia: ");
                        System.out.print("Fecha: ");
                        String fecha = entrada.nextLine();
                        System.out.print("Hora de inicio: ");
                        String horaInicio = entrada.nextLine();
                        System.out.print("Hora final: ");
                        String horaFinal = entrada.nextLine();
                        if (controlVar.consultarAsistencia(codigo, grupo, semestre, fecha, horaInicio, horaFinal) == null) {
                            System.out.println("No se encontró la asistencia");
                        } else {
                            System.out.println("\nAsignatura: " + controlVar.consultarAsignatura(codigo, grupo, semestre).getNombre());
                            System.out.println("Fecha: " + controlVar.consultarAsistencia(codigo, grupo, semestre, fecha, horaInicio, horaFinal).getFecha());
                            System.out.println("Listado de asistencia: \n");
                            ArrayList<String> estadoAlumno = controlVar.consultarAsistencia(codigo, grupo, semestre, fecha, horaInicio, horaFinal).getEstados();
                            for (int conAsis = 0; conAsis < controlVar.consultarAsignatura(codigo, grupo, semestre).getEstudiantes().size(); conAsis++) {
                                String nombreAlumno = controlVar.consultarAsignatura(codigo, grupo, semestre).getEstudiantes().get(conAsis).getNombre_Apellido();
                                System.out.println("Nombre: " + nombreAlumno);
                                String estado = estadoAlumno.get(conAsis);
                                System.out.println("Estado: " + estado + "\n");
                            }
                        }
                    }
                }
            }else if(opcion.equals("15")){ //Salir
                break;
            }else{
                System.out.println("Opción no válida");
            }
        }
        System.out.println("Gracias por usar el programa.");
        entrada.close();
    }
}