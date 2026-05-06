import java.time.LocalDate;

/**
 * Representa a un lector registrado en la biblioteca.
 * Hereda de Persona y gestiona sus préstamos en un array fijo.
 */
public class Lector extends Persona {

    private LocalDate fechaAlta;
    private boolean penalizado;
    private Prestamo[] prestamo;

    /** Constructor por defecto. Array de 10 préstamos. */
    public Lector() {
        super();
        this.fechaAlta  = LocalDate.now();
        this.penalizado = false;
        this.prestamo   = new Prestamo[10];
    }

    /**
     * Constructor parametrizado sin tamaño de array (usa 10 por defecto).
     * @param id         Identificador único.
     * @param nombre     Nombre del lector.
     * @param edad       Edad del lector.
     * @param fechaAlta  Fecha de registro en la biblioteca.
     * @param penalizado true si está penalizado.
     */
    public Lector(int id, String nombre, int edad, LocalDate fechaAlta, boolean penalizado) {
        this(id, nombre, edad, fechaAlta, penalizado, 10);
    }

    /**
     * Constructor parametrizado completo.
     * @param id               Identificador único.
     * @param nombre           Nombre del lector.
     * @param edad             Edad del lector.
     * @param fechaAlta        Fecha de registro en la biblioteca.
     * @param penalizado       true si está penalizado.
     * @param tamanoPrestamos  Tamaño del array de préstamos.
     */
    public Lector(int id, String nombre, int edad, LocalDate fechaAlta,
                  boolean penalizado, int tamanoPrestamos) {
        super(id, nombre, edad);
        this.fechaAlta  = fechaAlta;
        this.penalizado = penalizado;
        this.prestamo   = new Prestamo[tamanoPrestamos];
    }

    // Getters y setters
    public LocalDate getFechaAlta()             { return fechaAlta; }
    public boolean getPenalizado()              { return penalizado; }
    public Prestamo getPrestamo(int x)          { return prestamo[x]; }
    public Prestamo[] getPrestamos()            { return prestamo; }
    public void setFechaAlta(LocalDate f)       { this.fechaAlta = f; }
    public void setPenalizado(boolean p)        { this.penalizado = p; }
    public void setPrestamo(Prestamo p, int i)  { this.prestamo[i] = p; }

    @Override
    public boolean getSancionado() { return penalizado; }

    /**
     * Devuelve información del lector.
     * @return Cadena con datos básicos más fecha de alta y estado de penalización.
     */
    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + ", Fecha de Alta: " + fechaAlta
               + ", Penalizado: " + penalizado;
    }

    /**
     * Añade un préstamo al primer hueco disponible del array.
     * @param prestamo Préstamo a añadir.
     * @return true si se añadió, false si el array está lleno.
     */
    public boolean anadirPrestamo(Prestamo prestamo) {
        for (int i = 0; i < this.prestamo.length; i++) {
            if (this.prestamo[i] == null) {
                this.prestamo[i] = prestamo;
                return true;
            }
        }
        return false;
    }

    /**
     * Cuenta los préstamos que ya han sido devueltos.
     * @return Número de préstamos devueltos.
     */
    public int contarPrestamosDevueltos() {
        int contador = 0;
        for (int i = 0; i < prestamo.length; i++) {
            if (prestamo[i] != null && prestamo[i].getDevuelto()) contador++;
        }
        return contador;
    }

    /**
     * Cuenta el total de préstamos registrados (devueltos o no).
     * @return Número de préstamos no nulos.
     */
    public int contarPrestamos() {
        int contador = 0;
        for (int i = 0; i < prestamo.length; i++) {
            if (prestamo[i] != null) contador++;
        }
        return contador;
    }

    /**
     * Indica si el lector tiene algún préstamo sin devolver.
     * @return true si hay al menos uno sin devolver.
     */
    public boolean prestamosSinDevolver() {
        for (int i = 0; i < prestamo.length; i++) {
            if (prestamo[i] != null && !prestamo[i].getDevuelto()) return true;
        }
        return false;
    }

    /**
     * Calcula la media de días de todos los préstamos del lector.
     * @return Media de días, o 0 si no hay préstamos.
     */
    public float mediaDiasPrestamo() {
        int totalDias = 0;
        int contador  = 0;
        int mediaDias = 0;
        for (int i = 0; i < prestamo.length; i++) {
            if (prestamo[i] != null) {
                totalDias += prestamo[i].getDuracionDias();
                contador++;
            }
        }
        if (contador > 0) mediaDias = totalDias / contador;
        return mediaDias;
    }

    @Override
    public String toString() {
        return "Lector{fechaAlta=" + fechaAlta + ", penalizado=" + penalizado
               + ", " + super.toString() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lector)) return false;
        return super.equals(o);
    }
}