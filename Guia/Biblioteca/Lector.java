import java.time.LocalDate;
public class Lector extends Persona {
    //Atributo
    private LocalDate fechaAlta;
    private boolean penalizado;
    private Prestamo[] prestamo;
    //Constructor por defecto
    public Lector() {
        super();
        this.fechaAlta = LocalDate.now();
        this.penalizado = false;
        this.prestamo = new Prestamo[10]; // Suponiendo un tamaño máximo de 10 préstamos
    }
    //Constructor con parámetros
    public Lector(int id, String nombre, int edad, LocalDate fechaAlta, boolean penalizado, int tamanoPrestamo) {
        super(id, nombre, edad);
        this.fechaAlta = fechaAlta;
        this.penalizado = penalizado;
        this.prestamo = new Prestamo[tamanoPrestamo];
    }
    //Getters y setters
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public boolean getPenalizado() {
        return penalizado;
    }

    public void setPenalizado(boolean penalizado) {
        this.penalizado = penalizado;
    }
    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    public Prestamo getPrestamo() {
        return prestamo[0]; // Retorna el primer préstamo para simplificar
    }
    public void setPrestamo(Prestamo prestamo, int i) {
        this.prestamo[i] = prestamo;
    }
    //Metodos
    @Override
    public String toString() {
        return "Lector{" +
                "fechaAlta=" + fechaAlta +
                ", penalizado=" + penalizado +
                "} " + super.toString();
    }
    @Override
    public boolean getSancionado() {
        return penalizado;
    }

    public String mostrarInformacion() {
        return super.mostrarInformacion() + ", Fecha de Alta: " + fechaAlta + ", Penalizado: " + penalizado;
    }


    //metodos prestamos
    public boolean anadirPrestamo(Prestamo prestamo) {
        if (penalizado) {
            System.out.println("No se puede realizar el préstamo. El lector está penalizado.");
            return false;
        }
            for (int i = 0; i < this.prestamo.length; i++) {
                if (this.prestamo[i] == null) {
                    this.prestamo[i] = prestamo;
                    break;
                }
            }
        System.out.println("Préstamo añadido correctamente.");
        return true;
    }

    public int contarPrestamosDevueltos() {
        int contador = 0;
        for (int i = 0; i < prestamo.length; i++) {
            if (prestamo[i] != null && prestamo[i].getDevuelto()) {
                contador++;
            }
        }
        return contador;
    }

    public int contarPrestamos() {
        int contador = 0;
        for (int i = 0; i < prestamo.length; i++) {
            if (prestamo[i] != null) {
                contador++;
            }
        }
        return contador;
    }

    public boolean prestamosSinDevolver() {
        for (int i = 0; i < prestamo.length; i++) {
            if (prestamo[i] != null && !prestamo[i].getDevuelto()) {
                return true;
            }
        }
        return false;
    }

    public float mediaDiasPrestamo() {
        int totalDias = 0;
        int contador = 0;
        int mediaDias = 0;
        for (int i = 0; i < prestamo.length; i++) {
            if (prestamo[i] != null) {
                totalDias += prestamo[i].getDuracionDias();
                contador++;
            }
        }
        if (contador > 0) {
            mediaDias = totalDias / contador;
        }
        return mediaDias;
    }

    public Prestamo[] getPrestamos() {
        return prestamo;
    }
}
