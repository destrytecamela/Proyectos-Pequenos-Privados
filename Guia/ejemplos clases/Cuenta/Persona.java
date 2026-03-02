/**
 * Representa una persona con nombre, DNI y edad.Esta clase proporciona constructores para inicializar los datos básicos,
 * así como métodos de acceso (getters/setters) y utilidades comunes como
 * El DNI se almacena como entero. 
 * @author EDI
 * @version 1.0
 */
public class Persona {

    // Atributos
    /** Nombre de la persona.*/
    private String nombre;

    /** Documento Nacional de Identidad (DNI) sin letra. Puede ser -1 si no está inicializado. */
    private int dni;

    /** Edad de la persona en años. No negativa. */
    private int edad;

    /**
     * Crea una persona con valores por defecto.
     */
    public Persona() { // CD
        nombre = "";
        dni = -1;
        edad = 0;
    }

    /**
     * Crea una persona con nombre y DNI. La edad se inicializa a 0.
     *
     * @param s nombre de la persona; 
     * @param d DNI sin letra (solo números)
     */
    public Persona(String s, int d) {
        nombre = s;
        dni = d;
        edad = 0;
    }

    /**
     * Crea una persona con nombre, DNI y edad.
     *
     * @param s nombre de la persona
     * @param d DNI sin letra (solo números)
     * @param e edad en años (no negativa)
     */
    public Persona(String s, int d, int e) {
        nombre = s;
        dni = d;
        edad = e;
    }

    // Getters

    /**
     * Devuelve el nombre de la persona.
     *
     * @return nombre actual
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el DNI de la persona.
     *
     * @return DNI actual
     */
    public int getDni() {
        return dni;
    }

    /**
     * Devuelve la edad de la persona.
     *
     * @return edad actual en años
     */
    public int getEdad() {
        return edad;
    }

    // Setters

    /**
     * Establece el nombre de la persona.
     *
     * @param s nuevo nombre; 
     */
    public void setNombre(String s) {
        nombre = s;
    }

    /**
     * Establece el DNI de la persona.
     *
     * @param d nuevo DNI sin letra (solo números)
     */
    public void setDni(int d) {
        dni = d;
    }

    /**
     * Establece la edad de la persona.
     *
     * @param e nueva edad en años (no negativa)
     */
    public void setEdad(int e) {
        edad = e;
    }

    /**
     * Devuelve una representación textual de la persona con sus campos principales.
     *
     * @return cadena con el formato Persona[nombre:..., dni:..., edad:...]
     */
    @Override
    public String toString() {
        return "Persona[nombre:" + nombre + " dni:" + dni + " edad:" + edad + "]";
    }

    /**
     * Compara esta persona con otro objeto.Dos personas se consideran iguales si tienen el mismo nombre y el mismo DNI.
     * @param o el objeto a comparar
     * @return true si son iguales y false en caso contario
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Mismo objeto
        if (o == null || getClass() != o.getClass()) return false; // No es una Persona
        Persona persona = (Persona) o; // Cast seguro
        return dni == persona.dni && nombre.equals(persona.nombre); // Comparar por nombre y DNI
    }

    /**
     * Devuelve el código hash de la persona basado en nombre y DNI.
     * @return código hash consistente con equals()
     */
    @Override
    public int hashCode() {
        return java.util.Objects.hash(nombre, dni);
    }

    public boolean esEdadPar() {
        return edad % 2 == 0;
    }   


}