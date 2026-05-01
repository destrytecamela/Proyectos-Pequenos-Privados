/**
 * Clase principal del sistema de biblioteca.
 * Punto de entrada de la aplicación.
 */
public class MainBiblioteca {
    /**
     * Método principal. Lanza el menú interactivo de la biblioteca.
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        new Biblioteca().menu();
    }
}