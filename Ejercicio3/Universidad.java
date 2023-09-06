
/**
 * Esta clase es donde se crea lista de la sede
 * @author: Dulce Ambrosio
 * @version: 06/09/2023
 */
import java.util.ArrayList;

public class Universidad {
    // Atributos
    private ArrayList<Sede> sedes;

    // controlador
    public Universidad(ArrayList<Sede> sedes) {

        this.sedes = new ArrayList<>();
    }

    // getters y setters
    public void nuevaSede(Sede sedess) {
        sedes.add(sedess);

    }

    public ArrayList<Sede> getSedes() {
        return sedes;
    }

    public void setSedes(ArrayList<Sede> sedes) {
        this.sedes = sedes;
    }

    public void agregarSede(Sede sede) {
        sedes.add(sede);
    }

    /**
     * Método para mostrar las sedes
     */
    public void mostrarSedes() {
        System.out.println("Sedes de la Universidad:");
        for (Sede sede : sedes) {
            System.out.println("Lugar de la sede: " + sede.getLugarSede());
            System.out.println("Nombre de la sede: " + sede.getNuevaSede());
            System.out.println("------------------------------");
        }
    }

}