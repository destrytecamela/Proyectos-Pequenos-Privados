import java.time.LocalDate;

/**
 * Representa a un investigador, tipo especial de lector con un límite
 * de préstamos simultáneos sin devolver. Solo puede ser atendido por
 * bibliotecarios de la sección "Investigador".
 */
public class Investigador extends Lector {

    private int numPrestamos;

    /** Constructor por defecto. */
    public Investigador() {
        super();
        this.numPrestamos = 0;
    }

    /**
     * Constructor parametrizado sin tamaño de array (usa 10 por defecto).
     * @param id           Identificador único.
     * @param nombre       Nombre del investigador.
     * @param edad         Edad.
     * @param fechaAlta    Fecha de registro.
     * @param penalizado   true si está penalizado.
     * @param numPrestamos Límite máximo de préstamos sin devolver permitidos.
     */
    public Investigador(int id, String nombre, int edad, LocalDate fechaAlta,
                        boolean penalizado, int numPrestamos) {
        this(id, nombre, edad, fechaAlta, penalizado, 10, numPrestamos);
    }

    /**
     * Constructor parametrizado completo.
     * @param id              Identificador único.
     * @param nombre          Nombre del investigador.
     * @param edad            Edad.
     * @param fechaAlta       Fecha de registro.
     * @param penalizado      true si está penalizado.
     * @param tamanoPrestamos Tamaño del array de préstamos.
     * @param numPrestamos    Límite máximo de préstamos sin devolver permitidos.
     */
    public Investigador(int id, String nombre, int edad, LocalDate fechaAlta,
                        boolean penalizado, int tamanoPrestamos, int numPrestamos) {
        super(id, nombre, edad, fechaAlta, penalizado, tamanoPrestamos);
        this.numPrestamos = numPrestamos;
    }

    // Getters y setters
    public int getNumPrestamos()                 { return numPrestamos; }
    public void setNumPrestamos(int numPrestamos) { this.numPrestamos = numPrestamos; }

    /**
     * Calcula cuántos préstamos tiene el investigador sin devolver.
     * @return Número de préstamos activos (no devueltos).
     */
    public int contarPrestamosSinDevolver() {
        return contarPrestamos() - contarPrestamosDevueltos();
    }

    /**
     * Añade un préstamo al investigador aplicando sus restricciones:
     * el bibliotecario debe pertenecer a la sección "Investigador"
     * y el investigador no debe haber alcanzado su límite de préstamos activos.
     * @param prestamo Préstamo a añadir.
     * @return true si se añadió correctamente, false si no cumple las restricciones.
     */
    @Override
    public boolean anadirPrestamo(Prestamo prestamo) {
        if (prestamo.getBibliotecario() == null
                || !prestamo.getBibliotecario().getSeccion().equals("Investigador")) {
            return false;
        }
        if (contarPrestamosSinDevolver() >= numPrestamos) {
            return false;
        }
        return super.anadirPrestamo(prestamo);
    }

    @Override
    public String toString() {
        return "Investigador{numPrestamos=" + numPrestamos + ", " + super.toString() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Investigador)) return false;
        return super.equals(o);
    }
}