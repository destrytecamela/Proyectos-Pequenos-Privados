import java.time.LocalDate;

public class Investigador extends Lector {

    private int numPrestamos;

    public Investigador() {
        super();
        this.numPrestamos = 0;
    }

    public Investigador(int id, String nombre, int edad, LocalDate fechaAlta,
                        boolean penalizado, int tamanoPrestamos, int numPrestamos) {
        super(id, nombre, edad, fechaAlta, penalizado, tamanoPrestamos);
        this.numPrestamos = numPrestamos;
    }

    public int getNumPrestamos() { return numPrestamos; }
    public void setNumPrestamos(int numPrestamos) { this.numPrestamos = numPrestamos; }

    /** Préstamos activos (no devueltos) */
    public int contarPrestamosSinDevolver() {
        return contarPrestamos() - contarPrestamosDevueltos();
    }

    @Override
    public boolean anadirPrestamo(Prestamo prestamo) {
    if (prestamo.getBibliotecario() == null || !prestamo.getBibliotecario().getEsInvestigador()) {
        System.out.println("Error. Bibliotecario no investigador.");
        return false;
    }
    if (contarPrestamosSinDevolver() >= numPrestamos) {
        System.out.println("Error. El lector no tiene libros disponibles.");
        return false;
    }
    return super.anadirPrestamo(prestamo);
}

    @Override
    public String toString() {
        return "Investigador{numPrestamos=" + numPrestamos + "} " + super.toString();
    }
}
