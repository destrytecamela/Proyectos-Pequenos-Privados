/**
 * Clase abstracta que representa a cualquier persona del sistema de biblioteca.
 * Actúa como base para Lector, Bibliotecario e Investigador.
 */
public abstract class Persona {

    protected int id;
    protected String nombre;
    protected int edad;

    /** Constructor por defecto. */
    public Persona() {
        this.id     = 0;
        this.nombre = "";
        this.edad   = 0;
    }

    /**
     * Constructor parametrizado.
     * @param i Identificador único.
     * @param n Nombre de la persona.
     * @param e Edad de la persona.
     */
    public Persona(int i, String n, int e) {
        this.id     = i;
        this.nombre = n;
        this.edad   = e;
    }

    // Getters y setters
    public int getId()          { return id; }
    public String getNombre()   { return nombre; }
    public int getEdad()        { return edad; }
    public void setId(int i)            { this.id     = i; }
    public void setNombre(String n)     { this.nombre = n; }
    public void setEdad(int e)          { this.edad   = e; }

    /**
     * Indica si la persona está sancionada.
     * @return true si está sancionada.
     */
    public abstract boolean getSancionado();

    /**
     * Devuelve información básica de la persona.
     * @return Cadena con id, nombre y edad.
     */
    public String mostrarInformacion() {
        return "ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad;
    }

    @Override
    public String toString() {
        return "Persona{id=" + id + ", nombre=" + nombre + ", edad=" + edad + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona)) return false;
        Persona p = (Persona) o;
        return id == p.id;
    }
}