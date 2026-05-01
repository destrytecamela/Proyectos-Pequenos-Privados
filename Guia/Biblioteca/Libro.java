import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Representa un libro disponible en la biblioteca.
 * Almacena información bibliográfica, stock disponible,
 * la lista de lectores que ya lo han leído y la cola de espera.
 */
public class Libro {

    private String titulo;
    private String autor;
    private String isbn;
    private int stock;
    private int diasPrestamo;
    private List<Lector> lectores;
    private Queue<Lector> cola;

    /** Constructor por defecto. Inicializa listas vacías. */
    public Libro() {
        this.titulo      = "";
        this.autor       = "";
        this.isbn        = "";
        this.stock       = 0;
        this.diasPrestamo = 0;
        this.lectores    = new ArrayList<>();
        this.cola        = new LinkedList<>();
    }

    /**
     * Constructor parametrizado.
     * @param titulo      Título del libro.
     * @param autor       Autor del libro.
     * @param isbn        ISBN identificador.
     * @param stock       Ejemplares disponibles.
     * @param diasPrestamo Días máximos de préstamo.
     */
    public Libro(String titulo, String autor, String isbn, int stock, int diasPrestamo) {
        this.titulo       = titulo;
        this.autor        = autor;
        this.isbn         = isbn;
        this.stock        = stock;
        this.diasPrestamo = diasPrestamo;
        this.lectores     = new ArrayList<>();
        this.cola         = new LinkedList<>();
    }

    // Getters y setters
    public String getTitulo(){ 
        return titulo; 
    }
    public String getAutor(){ 
        return autor; 
    }
    public String getIsbn(){ 
        return isbn; 
    }
    public int getStock(){ 
        return stock; 
    }
    public int getDiasPrestamo(){ 
        return diasPrestamo; 
    }
    public List<Lector> getLectores(){ 
        return lectores; 
    }
    public Queue<Lector> getCola(){ 
        return cola; 
    }

    public void setTitulo(String titulo){ 
        this.titulo = titulo; 
    }
    public void setAutor(String autor){ 
        this.autor = autor; 
    }
    public void setIsbn(String isbn){ 
        this.isbn = isbn; 
    }
    public void setStock(int stock){ 
        this.stock = stock; 
    }
    public void setDiasPrestamo(int diasPrestamo){ 
        this.diasPrestamo = diasPrestamo; 
    }

    /**
     * Añade un lector a la lista de lectores que ya devolvieron el libro.
     * @param lector Lector que ha devuelto el libro.
     */
    public void anadirLector(Lector lector) {
        lectores.add(lector);
    }

    /**
     * Añade un lector a la cola de espera del libro.
     * @param lector Lector en espera.
     */
    public void anadirCola(Lector lector) {
        cola.offer(lector);
    }

    /**
     * Extrae y devuelve el primer lector de la cola de espera.
     * @return El primer lector en espera, o null si la cola está vacía.
     */
    public Lector sacarCola() {
        return cola.poll();
    }

    @Override
    public String toString() {
        return "Libro{titulo=" + titulo + ", autor=" + autor +
               ", isbn=" + isbn + ", stock=" + stock +
               ", diasPrestamo=" + diasPrestamo + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Libro)) return false;
        Libro libro = (Libro) o;
        return isbn.equals(libro.isbn);
    }
}
