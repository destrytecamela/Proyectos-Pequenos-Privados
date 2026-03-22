public class Bibliotecario extends Persona {
    //Atributo
    private String seccion;
    // Constructor sin parámetros
    public Bibliotecario() {
        super();
        this.seccion = "";
    }
    // Constructor con parámetros
    public Bibliotecario(int id, String nombre, int edad, String seccion) {
        super(id, nombre, edad);
        this.seccion = seccion;
    }
    // Getters y setters
    public String getSeccion() {
        return seccion;
    }
    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
    //Metodos
    @Override
    public String toString() {
        return "Bibliotecario{" +
                "seccion='" + seccion + '\'' +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';

    }
    @Override
    public boolean getSancionado() {
        return false;
    }
}
