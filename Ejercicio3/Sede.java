
/**
 * Esta clase es donde se crea la lista de los estudiantes y la sede
 * @author: Dulce Ambrosio
 * @version: 05/09/2023
 */
import java.util.ArrayList;

public class Sede {
    // Atributos
    private String LugarSede;
    private String NuevaSede;
    private ArrayList<Estudiante> estudiante;

    // controlador
    public Sede(String lugarSede, String nuevaSede, ArrayList<Estudiante> estudiante) {
        this.LugarSede = lugarSede;
        this.NuevaSede = nuevaSede;
        this.estudiante = new ArrayList<>();
    }

    // getters y setters
    public String getLugarSede() {
        return LugarSede;
    }

    public void setLugarSede(String lugarSede) {
        LugarSede = lugarSede;
    }

    public String getNuevaSede() {
        return NuevaSede;
    }

    public void setNuevaSede(String nuevaSede) {
        NuevaSede = nuevaSede;
    }

    public ArrayList<Estudiante> getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(ArrayList<Estudiante> estudiante) {
        this.estudiante = estudiante;
    }

    /**
     * Método para añadir los atributos del estudiante a la lista
     */
    public void registrarEstudiante(Estudiante estudiantes) {
        estudiante.add(estudiantes);
    }

    /**
     * Método para mostrar los datos del estudiante
     */
    public void mostrarEstudiantes() {
        System.out.println("Estudiantes en la sede " + getNuevaSede() + ":");
        for (Estudiante estudiante : estudiante) {
            System.out.println("Nombre: " + estudiante.getNombre());
            System.out.println("Apellido: " + estudiante.getApellido());
            System.out.println("Código: " + estudiante.getCodigo());
            System.out.println("Correo: " + estudiante.getCorreo());
            System.out.println("Resultados:");
            for (Resultado resultado : estudiante.getResultados()) {
                System.out.println("  Materia: " + resultado.getMateria());
                System.out.println("  Nota: " + resultado.getNota());
            }
            System.out.println("------------------------------");
        }
    }

}