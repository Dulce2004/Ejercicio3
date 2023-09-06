import java.util.ArrayList;

public class Estudiante {
    private String Nombre;
    private String Apellido;
    private int Codigo;
    private String Fecha;
    private String Correo;
    private ArrayList<Resultado> resultados;

    public Estudiante(String nombre, String apellido, int codigo, String fecha, String correo,
            ArrayList<Resultado> resultados) {
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Codigo = codigo;
        this.Fecha = fecha;
        this.Correo = correo;
        this.resultados = new ArrayList<>();
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public ArrayList<Resultado> getResultados() {
        return resultados;
    }

    public void setResultados(ArrayList<Resultado> resultados) {
        this.resultados = resultados;
    }

    public void AgregarMateria(Resultado resultado) {
        resultados.add(resultado);
    }

    public double calcularPromedioNotas() {
        if (resultados.isEmpty()) {
            return 0.0; // En caso de que el estudiante no tenga resultados, el promedio es 0.
        }

        double sumaNotas = 0.0;
        for (Resultado resultado : resultados) {
            sumaNotas += resultado.getNota();
        }

        return sumaNotas / resultados.size();
    }

}