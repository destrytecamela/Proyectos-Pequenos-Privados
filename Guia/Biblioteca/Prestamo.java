import java.time.LocalDate;

/**
 * Representa un préstamo realizado en la biblioteca.
 * Almacena la fecha, duración, estado de devolución,
 * el bibliotecario gestor, el libro prestado y el lector que lo recibe.
 */
public class Prestamo {

    private int id;
    private LocalDate fechaPrestamo;
    private int duracionDias;
    private boolean devuelto;
    private Bibliotecario bibliotecario;
    private Libro libro;
    private Lector lector;

    /** Constructor por defecto. */
    public Prestamo() {
        this.id            = 0;
        this.fechaPrestamo = LocalDate.now();
        this.duracionDias  = 0;
        this.devuelto      = false;
        this.bibliotecario = new Bibliotecario();
        this.libro         = null;
        this.lector        = null;
    }

    /**
     * Constructor parametrizado.
     * @param id           Identificador del préstamo.
     * @param fechaPrestamo Fecha en que se realiza el préstamo.
     * @param duracionDias  Días máximos permitidos.
     * @param devuelto      Si ya ha sido devuelto.
     * @param b             Bibliotecario que gestiona el préstamo.
     * @param libro         Libro prestado.
     * @param lector        Lector que recibe el préstamo.
     */
    public Prestamo(int id, LocalDate fechaPrestamo, int duracionDias,
                    boolean devuelto, Bibliotecario b, Libro libro, Lector lector) {
        this.id            = id;
        this.fechaPrestamo = fechaPrestamo;
        this.duracionDias  = duracionDias;
        this.devuelto      = devuelto;
        this.bibliotecario = b;
        this.libro         = libro;
        this.lector        = lector;
    }

    // Constructor de compatibilidad con el menú antiguo
    public Prestamo(LocalDate fechaPrestamo, int duracionDias,
                    boolean devuelto, Bibliotecario b) {
        this.id            = 0;
        this.fechaPrestamo = fechaPrestamo;
        this.duracionDias  = duracionDias;
        this.devuelto      = devuelto;
        this.bibliotecario = b;
        this.libro         = null;
        this.lector        = null;
    }

    // Getters y setters
    public int getId()                      { return id; }
    public LocalDate getFechaPrestamo()     { return fechaPrestamo; }
    /** Alias de getFechaPrestamo() usado internamente en devolverPrestamo. */
    public LocalDate getFecha()             { return fechaPrestamo; }
    public int getDuracionDias()            { return duracionDias; }
    public boolean getDevuelto()            { return devuelto; }
    public Bibliotecario getBibliotecario() { return bibliotecario; }
    public Libro getLibro()                 { return libro; }
    public Lector getLector()               { return lector; }

    public void setId(int id)                               { this.id = id; }
    public void setFechaPrestamo(LocalDate fechaPrestamo)   { this.fechaPrestamo = fechaPrestamo; }
    public void setDuracionDias(int duracionDias)           { this.duracionDias = duracionDias; }
    public void setDevuelto(boolean devuelto)               { this.devuelto = devuelto; }
    public void setBibliotecario(Bibliotecario b)           { this.bibliotecario = b; }
    public void setLibro(Libro libro)                       { this.libro = libro; }
    public void setLector(Lector lector)                    { this.lector = lector; }

    /**
     * Marca el préstamo como devuelto si aún no lo estaba.
     * @return true si se marcó correctamente, false si ya estaba devuelto.
     */
    public boolean marcarDevuelto() {
        if (!devuelto) {
            devuelto = true;
            return true;
        }
        return false;
    }

    /**
     * Asigna un bibliotecario al préstamo si es distinto al actual.
     * @param bibliotecario Nuevo bibliotecario a asignar.
     * @return true si se asignó, false si ya era el mismo.
     */
    public boolean asignarBibliotecario(Bibliotecario bibliotecario) {
        if (this.bibliotecario == null || this.bibliotecario.getId() != bibliotecario.getId()) {
            this.bibliotecario = bibliotecario;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Prestamo{id=" + id + ", fecha=" + fechaPrestamo +
               ", duracion=" + duracionDias + ", devuelto=" + devuelto + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prestamo)) return false;
        Prestamo p = (Prestamo) o;
        return id == p.id;
    }
}