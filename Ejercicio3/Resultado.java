/**
 * Esta clase es donde se crean los atributos de los resultados
 * 
 * @author: Dulce Ambrosio
 * @version: 05/09/2023
 */
public class Resultado {
    // Atributos
    private String materia;
    private double nota;

    // controlador
    public Resultado(String materia, double nota) {
        this.materia = materia;
        this.nota = nota;
    }

    // getters y setters
    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

}