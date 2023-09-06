import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esta clase es donde se crea la vista para el usuario
 * 
 * @author: Dulce Ambrosio
 * @version: 06/09/2023
 */
public class Principal {
    /**
     * Método para llamar a las otras clases
     */
    public static void main(String[] args) {
        Universidad universidad = new Universidad(new ArrayList<>());
        Scanner teclado = new Scanner(System.in);

        while (true) { // se crea el menú
            System.out.println("-------------------------------");
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("1. Agregar una sede");
            System.out.println("2. Ingresar datos de un estudiante");
            System.out.println("3. Mostrar los datos de los estudiantes y las sedes creadas");
            System.out.println("4. Mostrar datos analíticos");
            System.out.println("5. Salir");
            System.out.println("Ingrese el número de opción que desea: ");

            int opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) { // se piden y se leen los datos de las sedes
                case 1:
                    System.out.println("Ingrese los datos de la sede: ");
                    System.out.print("Lugar de la sede: ");
                    String lugarSede = teclado.nextLine();
                    System.out.print("Nombre de la nueva sede: ");
                    String nombreSede = teclado.nextLine();

                    Sede nuevaSede = new Sede(lugarSede, nombreSede, new ArrayList<>());
                    universidad.agregarSede(nuevaSede);
                    System.out.println("La nueva sede se ha creado");
                    break;
                case 2:// se piden y se leen los datos de los estudiantes
                    System.out.println("------------------------------------------");
                    System.out.println("Ingrese los siguientes datos del estudiante: ");
                    System.out.print("Nombre: ");
                    String nombreEstu = teclado.nextLine();
                    System.out.print("Apellido: ");
                    String apellidoEstu = teclado.nextLine();
                    System.out.print("Correo: ");
                    String correoEstu = teclado.nextLine();
                    System.out.print("Código único: ");
                    int codigoEstu = teclado.nextInt();
                    teclado.nextLine();
                    System.out.print("Nombre de la sede: ");
                    String sedeEstu = teclado.nextLine();

                    Estudiante estudiante = new Estudiante(nombreEstu, apellidoEstu, codigoEstu, sedeEstu, correoEstu,
                            new ArrayList<>());

                    System.out.print("Materia del examen realizado: ");
                    String materiaEstu = teclado.nextLine(); // se agregan a las listas
                    System.out.print("Nota del examen realizado: ");
                    double notaEstu = teclado.nextDouble();// se agregan a las listas

                    Resultado resultado = new Resultado(materiaEstu, notaEstu);
                    estudiante.AgregarMateria(resultado);// se agregan a las listas

                    for (Sede sede : universidad.getSedes()) {
                        if (sede.getNuevaSede().equals(sedeEstu)) {
                            sede.registrarEstudiante(estudiante);
                            break;// se agregan a las listas
                        }
                    }

                    System.out.println("Estudiante ingresado de manera correcta :)");
                    break;
                case 3: // ciclo para mostrar las sedes y datos analiticos
                    universidad.mostrarSedes();
                    for (Sede sede : universidad.getSedes()) {
                        sede.mostrarEstudiantes();
                    }
                    break;
                case 4:
                    if (universidad.getSedes().isEmpty()) {
                        System.out.println("No hay sedes ni estudiantes registrados.");
                    } else {
                        for (Sede sede : universidad.getSedes()) {
                            System.out.println("Sede: " + sede.getNuevaSede());
                            ArrayList<Double> notas = new ArrayList<>();
                            int cantidadAlumnos = 0;
                            double notaMasAlta = Double.MIN_VALUE;
                            double notaMasBaja = Double.MAX_VALUE;

                            for (Estudiante estudiantes : sede.getEstudiante()) {
                                for (Resultado resultados : estudiantes.getResultados()) {
                                    double nota = resultados.getNota();
                                    notas.add(nota);

                                    if (nota > notaMasAlta) {
                                        notaMasAlta = nota;
                                    }
                                    if (nota < notaMasBaja) {
                                        notaMasBaja = nota;
                                    }
                                }
                                cantidadAlumnos++;
                            }

                            if (notas.isEmpty()) {
                                System.out.println("No hay notas registradas para esta sede.");
                            } else {
                                // Calcular el promedio
                                double promedio = calcularPromedio(notas);
                                System.out.println("Promedio de notas: " + promedio);

                                // Calcular la mediana
                                double mediana = calcularMediana(notas);
                                System.out.println("Mediana de notas: " + mediana);

                                // Calcular la moda
                                double moda = calcularModa(notas);
                                System.out.println("Moda de notas: " + moda);

                                // Calcular la desviación estándar
                                double desviacionEstandar = calcularDesviacionEstandar(notas, promedio);
                                System.out.println("Desviación estándar de notas: " + desviacionEstandar);

                                // Mostrar cantidad de alumnos, nota más alta y nota más baja
                                System.out.println("Cantidad de alumnos: " + cantidadAlumnos);
                                System.out.println("Nota más alta: " + notaMasAlta);
                                System.out.println("Nota más baja: " + notaMasBaja);
                            }
                        }
                    }
                    break;

                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente nuevamente.");
            }
        }

    }

    /**
     * Método para calcular el promedio
     */
    private static double calcularPromedio(ArrayList<Double> notas) {
        double suma = 0.0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.size();
    }

    /**
     * Método para calcular la mediana
     */
    private static double calcularMediana(ArrayList<Double> notas) {
        int n = notas.size();
        notas.sort(Double::compareTo);
        if (n % 2 == 0) {
            int medio1 = n / 2 - 1;
            int medio2 = n / 2;
            return (notas.get(medio1) + notas.get(medio2)) / 2.0;
        } else {
            return notas.get(n / 2);
        }
    }

    /**
     * Método para calcular la moda
     */
    private static double calcularModa(ArrayList<Double> notas) {
        double moda = 0.0;
        int maxCount = 0;

        for (int i = 0; i < notas.size(); i++) {
            int count = 0;
            for (int j = 0; j < notas.size(); j++) {
                if (notas.get(i).equals(notas.get(j))) {
                    count++;
                }
            }
            if (count > maxCount) {
                moda = notas.get(i);
                maxCount = count;
            }
        }

        return moda;
    }

    /**
     * Método para calcular la desviación estandar
     */
    private static double calcularDesviacionEstandar(ArrayList<Double> notas, double promedio) {
        double sumatoriaDiferencias = 0.0;
        for (double nota : notas) {
            double diferencia = nota - promedio;
            sumatoriaDiferencias += diferencia * diferencia;
        }
        double varianza = sumatoriaDiferencias / (notas.size() - 1);
        return Math.sqrt(varianza);
    }
}
