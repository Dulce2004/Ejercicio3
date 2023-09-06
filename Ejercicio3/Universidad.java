import java.util.ArrayList;

public class Universidad {
    private ArrayList<Sede> sedes;

    public Universidad(ArrayList<Sede> sedes) {

        this.sedes = new ArrayList<>();
    }

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

    public void mostrarSedes() {
        System.out.println("Sedes de la Universidad:");
        for (Sede sede : sedes) {
            System.out.println("Lugar de la sede: " + sede.getLugarSede());
            System.out.println("Nombre de la sede: " + sede.getNuevaSede());
            System.out.println("------------------------------");
        }
    }

}