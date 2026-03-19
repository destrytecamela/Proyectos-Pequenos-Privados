package Biblioteca;

public abstract class Persona {
    // Atributos comunes a todas las personas
    protected int id;
    protected String nombre;
    protected int edad;
    // Constructor por defecto
    public Persona() {
        this.id = 0;
        this.nombre = "";
        this.edad = 0;
    }
    // Constructor con parámetros
    public Persona(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }
    // Getters y setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    //Metodos 
    public abstract boolean getSancionado();
    public String mostrarInformacion(){
        return "ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad;
    }

    //ToString
    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
    //equals solo de la id
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Persona persona = (Persona) obj;
        return id == persona.id;
    }

    //metodo mostrarinformacion con toString
    public String mostrarInformacionToString() {
        return toString();
    }
}
