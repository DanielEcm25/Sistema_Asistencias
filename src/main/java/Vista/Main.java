package Vista;
import Controlador.Elcontrolador;
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
        String nombre = "";
        while(opcion.equals("12")==false){
            System.out.println("\nMenú principal");
            System.out.println("1. Crear departamento");
            System.out.println("2. Consultar departamento");
            System.out.println("3. Modificar nombre del departamento");
            System.out.println("4. Adicionar Asignatura");
            System.out.println("5. Consultar Asignatura");
            System.out.println("6. Modificar Asignatura");
            System.out.println("7. Eliminar Asignatura");
            System.out.println("8. Registrar estudiantes en una asignatura");
            System.out.println("9. Generar lista de asistencia");
            System.out.println("10. Modificar asistencia");
            System.out.println("11. Consultar asistencia");
            System.out.println("12. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextLine();
            if (opcion.equals("1")){
                if (controlVar.getDepartamento().getNombre() == null) {
                    System.out.println("Nombre del departamento: ");
                    nombre = entrada.nextLine();
                    controlVar.nombrarDepartamento(nombre);
                    System.out.println("Departamento "+nombre+" creado.");
                }else{
                    System.out.println("El departamento ya ha sido creado.");
                }
            }else if (opcion.equals("2")){
                if(controlVar.getDepartamento().getNombre()==null){
                    System.out.println("Aun no se ha creado el departamento");
                }else{
                    System.out.println("Nombre del departamento: "+controlVar.consultarNombreDepartamento());
                }
            }else if(opcion.equals("3")){
                if(controlVar.getDepartamento().getNombre()==null){
                    System.out.println("Aún no se ha creado un departamento");
                }
                System.out.println("Ingrese el nuevo nombre del departamento");
                nombre = entrada.nextLine();
                controlVar.modificarDepartamento(nombre);
                System.out.println("El nombre del departamento se modificó");
            }else if(opcion.equals("4")){
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
            }else if(opcion.equals("5")){
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
            }else if(opcion.equals("6")){
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
            }else if(opcion.equals("7")){
                System.out.println("Ingrese la información de la asignatura a eliminar: ");
                System.out.print("Código: ");
                String codDel = entrada.nextLine();
                System.out.print("Grupo: ");
                String grupoDel = entrada.nextLine();
                System.out.print("Semestre: ");
                String semDel = entrada.nextLine();
                controlVar.eliminarAsignatura(codDel, grupoDel, semDel);
                System.out.println("La asignatura se eliminó con éxito.");
            }else if(opcion.equals("8")){
                System.out.println("Ingrese el código de la asignatura:");
                String codigo = entrada.nextLine();
                System.out.println("Ingrese el grupo de la asignatura: ");
                String grupo = entrada.nextLine();
                System.out.println("Ingrese el semestre de la asignatura: ");
                String semestre = entrada.nextLine();
                if(controlVar.consultarAsignatura(codigo,grupo,semestre) == null){
                    System.out.println("La asignatura no existe");
                }else{
                    boolean agregarmas = true;
                    while(agregarmas){
                        System.out.println("Ingrese el código del estudiante: ");
                        String codigoEst = entrada.nextLine();
                        System.out.println("Ingrese el nombre el estudiante: ");
                        String name = entrada.nextLine();
                        System.out.println("Ingrese el tipo de documento (TI ó CC)");
                        String tipodoc = entrada.nextLine();
                        controlVar.AdicionarEstudiantes(codigo,grupo,semestre,codigoEst,name,tipodoc);
                        System.out.println("¿Desea seguir agregando estuidantes (S/N)?");
                        String more = entrada.nextLine();
                        if (more.equalsIgnoreCase("N")){
                            agregarmas = false;
                        }
                    }
                    System.out.println("Proceso finalizado");
                }
            }else if(opcion.equals("9")) {
                System.out.println("Ingrese la información de la asignatura de la que va a generar la lista de asistencia: ");
                System.out.print("Código asignatura: ");
                String codigoAs = entrada.nextLine();
                System.out.print("Grupo: ");
                String grupoAs = entrada.nextLine();
                System.out.print("Semestre: ");
                String semestreAs = entrada.nextLine();
                if(controlVar.consultarAsignatura(codigoAs,grupoAs,semestreAs)==null){
                    System.out.println("La asignatura no existe");
                }else{
                    System.out.println("Ingrese información de la asistencia: ");
                    System.out.print("Fecha (aaaa/mm/dd): ");
                    String fecha = entrada.nextLine();
                    System.out.print("Hora de inicio: ");
                    String horaInicio = entrada.nextLine();
                    System.out.print("Hora final: ");
                    String horaFinal = entrada.nextLine();
                    if(controlVar.consultarAsistencia(codigoAs,grupoAs,semestreAs,fecha,horaInicio,horaFinal)!=null){
                        System.out.println("La asistencia de esta asignatura en la fecha indicada ya se generó.");
                    }else{
                        ArrayList<String>codigos = new ArrayList<>();
                        ArrayList<String>estados = new ArrayList<>();
                        for(int stu = 0; stu<controlVar.consultarAsignatura(codigoAs,grupoAs,semestreAs).getEstudiantes().size(); stu++){
                            codigos.add(controlVar.consultarAsignatura(codigoAs,grupoAs,semestreAs).getEstudiantes().get(stu).getIdentificacion());
                            estados.add("No asistió");
                        }
                        controlVar.adicionarAsistencia(codigoAs,grupoAs,semestreAs,fecha,horaInicio,horaFinal,codigos,estados);
                        System.out.println("Lista de asistencia generada");
                    }
                }
            }else if(opcion.equals("10")){
                System.out.println("Ingrese la información de la asignatura: ");
                System.out.print("Código asignatura: ");
                String codigo = entrada.nextLine();
                System.out.print("Grupo asignatura: ");
                String grupo = entrada.nextLine();
                System.out.print("Semestre asignatura: ");
                String semestre = entrada.nextLine();
                if (controlVar.consultarAsignatura(codigo,grupo,semestre) == null){
                    System.out.println("La asignatura no existe o hay algún error en la digitación de sus datos");
                }else{
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
                        for(int asis = 0; asis<controlVar.consultarAsignatura(codigo,grupo,semestre).getEstudiantes().size();asis++){
                            String nombreEst = controlVar.consultarAsignatura(codigo,grupo,semestre).getEstudiantes().get(asis).getNombre_Apellido();
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
                            if(nuevoEstado.equals("0")){
                                state = "No asistió";
                            }else if(nuevoEstado.equals("1")){
                                state = "Retraso";
                            }else if(nuevoEstado.equals("2")){
                                state = "Asistió a tiempo";
                            }
                            controlVar.consultarAsistencia(codigo, grupo, semestre, fecha, horaInicio, horaFinal).modificarAsistencia(controlVar.consultarAsignatura(codigo,grupo,semestre).getEstudiantes().get(asis).getIdentificacion(),state);
                        }
                        System.out.println("Asistencia registrada.");
                    }controlVar.modificarAsistencia(codigo,grupo,semestre,fecha,horaInicio,horaFinal,controlVar.consultarAsistencia(codigo, grupo, semestre, fecha, horaInicio, horaFinal).getCodigos(),controlVar.consultarAsistencia(codigo, grupo, semestre, fecha, horaInicio, horaFinal).getEstados());
                }
            }else if(opcion.equals("11")) {
                System.out.println("Ingrese la información de la asignatura: ");
                System.out.print("Código asignatura: ");
                String codigo = entrada.nextLine();
                System.out.print("Grupo: ");
                String grupo = entrada.nextLine();
                System.out.print("Semestre: ");
                String semestre = entrada.nextLine();
                if(controlVar.consultarAsignatura(codigo,grupo,semestre) == null){
                    System.out.println("No se encontró la asignatura");
                }else{
                    System.out.println("Ingrese la información de la asistencia: ");
                    System.out.print("Fecha: ");
                    String fecha = entrada.nextLine();
                    System.out.print("Hora de inicio: ");
                    String horaInicio = entrada.nextLine();
                    System.out.print("Hora final: ");
                    String horaFinal = entrada.nextLine();

                    if(controlVar.consultarAsistencia(codigo, grupo, semestre, fecha, horaInicio, horaFinal) == null){
                        System.out.println("No se encontró la asistencia");
                    }else{
                        System.out.println("\nAsignatura: "+controlVar.consultarAsignatura(codigo,grupo,semestre).getNombre());
                        System.out.println("Fecha: "+controlVar.consultarAsistencia(codigo, grupo, semestre, fecha, horaInicio, horaFinal).getFecha());
                        System.out.println("Listado de asistencia: \n");
                        ArrayList<String>estadoAlumno = controlVar.consultarAsistencia(codigo, grupo, semestre, fecha, horaInicio, horaFinal).getEstados();
                        for(int conAsis = 0; conAsis<controlVar.consultarAsignatura(codigo,grupo,semestre).getEstudiantes().size();conAsis++){
                            String nombreAlumno = controlVar.consultarAsignatura(codigo,grupo,semestre).getEstudiantes().get(conAsis).getNombre_Apellido();
                            System.out.println("Nombre: "+nombreAlumno);
                            String estado =  estadoAlumno.get(conAsis);
                            System.out.println("Estado: "+estado+"\n");
                        }
                    }
                }
            }else if(opcion.equals("12")){
                break;
            }else{
                System.out.println("Opción no válida");
            }
        }
        System.out.println("Gracias por usar el programa.");
        entrada.close();
    }
}