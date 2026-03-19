

public class Persona1 {
    // Tabla de letras para calcular la letra del DNI
    char[] TABLA_LETRAS_DNI = {
        'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 
        'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 
        'C', 'K', 'E'
    };
    
    // Atributos privados
    private String nombre;
    private String apellidos;
    private int dni;
    private int edad;
    
    // Constructor por defecto
    public Persona1() {
        this.nombre = "";
        this.apellidos = "";
        this.dni = 0;
        this.edad = 0;
    }
    
    // Constructor con parámetros
    public Persona1(String nombre, String apellidos, int dni, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.edad = edad;
    }
    
    // Getters
    public String getNombre() {
        return nombre;
    }
    
    public String getApellidos() {
        return apellidos;
    }
    
    public int getDni() {
        return dni;
    }
    
    public int getEdad() {
        return edad;
    }
    
    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public void setDni(int dni) {
        this.dni = dni;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    // Métodos adicionales
    public char calcularLetraDNI() {
        int indice = dni % 23;
        return TABLA_LETRAS_DNI[indice];
    }
    
    public boolean esEdadPar() {
        return edad % 2 == 0;
    }
    
    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }
}
