import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal del sistema de gestión de la biblioteca.
 * Gestiona personas (lectores, bibliotecarios, investigadores),
 * libros y préstamos. Ofrece un menú interactivo y métodos
 * de lógica pura para su uso desde baterías de test jUnit.
 */
public class Biblioteca {

    boolean cv = false;
    private final Scanner sc = new Scanner(System.in);
    private Persona[] personas;
    private List<Libro> libros;
    private List<Prestamo> prestamos;

    /** Constructor por defecto. Capacidad de 100 personas. */
    public Biblioteca() {
        this.personas  = new Persona[100];
        this.libros    = new LinkedList<>();
        this.prestamos = new ArrayList<>();
    }

    /**
     * Constructor parametrizado.
     * @param x Tamaño del array de personas.
     */
    public Biblioteca(int x) {
        this.personas  = new Persona[x];
        this.libros    = new LinkedList<>();
        this.prestamos = new ArrayList<>();
    }

    // =====================================================
    // (1) AÑADIR PERSONA (menú)
    // =====================================================
    /**
     * Lee los datos por teclado y añade una persona al sistema.
     * Soporta Lector (1), Bibliotecario (2) e Investigador (3).
     * @return true si se añadió correctamente.
     */
    public boolean anadirPersona() {
        boolean h = false;
        if (!cv) {
            System.out.println("1. Lector");
            System.out.println("2. Bibliotecario");
            System.out.println("3. Investigador");
            System.out.print("Tipo: ");
        }
        int tipo = Integer.parseInt(leerLinea());

        if (!cv) System.out.print("ID: ");
        int id = Integer.parseInt(leerLinea());

        if (!cv) System.out.print("Nombre: ");
        String nombre = leerLinea();

        if (!cv) System.out.print("Edad: ");
        int edad = Integer.parseInt(leerLinea());

        if (tipo == 1) {
            if (!cv) System.out.print("Fecha de alta (YYYY-MM-DD): ");
            LocalDate fechaAlta = LocalDate.parse(leerLinea());
            boolean penalizado = Boolean.parseBoolean(leerLinea());
            Lector lector = new Lector(id, nombre, edad, fechaAlta, penalizado, 10);
            for (int i = 0; i < personas.length; i++) {
                if (personas[i] == null) {
                    personas[i] = lector;
                    h = true;
                    break;
                }
            }
        } else if (tipo == 2) {
            if (!cv) System.out.print("Seccion: ");
            String seccion = leerLinea();
            boolean esInvestigador = Boolean.parseBoolean(leerLinea());
            Bibliotecario bibliotecario = new Bibliotecario(id, nombre, edad, seccion, esInvestigador);
            for (int i = 0; i < personas.length; i++) {
                if (personas[i] == null) {
                    personas[i] = bibliotecario;
                    h = true;
                    break;
                }
            }
        } else if (tipo == 3) {
            if (!cv) System.out.print("Fecha de alta (YYYY-MM-DD): ");
            LocalDate fechaAlta = LocalDate.parse(leerLinea());
            boolean penalizado = Boolean.parseBoolean(leerLinea());
            if (!cv) System.out.print("Num préstamos máximos: ");
            int numPrestamos = Integer.parseInt(leerLinea());
            Investigador inv = new Investigador(id, nombre, edad, fechaAlta, penalizado, 10, numPrestamos);
            for (int i = 0; i < personas.length; i++) {
                if (personas[i] == null) {
                    personas[i] = inv;
                    h = true;
                    break;
                }
            }
        }

        if (h) {
            System.out.println("Miembro añadido correctamente con id:" + id);
        }
        return h;
    }

    // =====================================================
    // (1b) AÑADIR PERSONA POR ARGUMENTOS
    // =====================================================
    /**
     * Añade una persona ya construida al array de personas.
     * @param p Persona a añadir.
     * @return true si había hueco y se añadió, false si el array está lleno.
     */
    public boolean anadirPersonaArgumentos(Persona p) {
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null) {
                personas[i] = p;
                return true;
            }
        }
        return false;
    }

    // =====================================================
    // (2) BUSCAR PERSONA POR ID
    // =====================================================
    /**
     * Busca una persona por su identificador.
     * @param id Identificador a buscar.
     * @return La persona encontrada, o null si no existe.
     */
    public Persona buscarPorId(int id) {
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].getId() == id) {
                return personas[i];
            }
        }
        return null;
    }

    /** Alias de buscarPorId para la nueva interfaz jUnit. */
    public Persona buscarPersonaPorId(int id) {
        return buscarPorId(id);
    }

    // =====================================================
    // (3) CONTAR PERSONAS
    // =====================================================
    /**
     * Cuenta el total de personas registradas en el sistema.
     * @return Número de personas no nulas en el array.
     */
    public int contarPersonas() {
        int contador = 0;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null) contador++;
        }
        return contador;
    }

    // =====================================================
    // (4) REGISTRAR PRÉSTAMO (menú antiguo)
    // =====================================================
    /**
     * Registra un préstamo ya construido en el lector indicado.
     * @param idLector Identificador del lector.
     * @param prestamo Objeto Prestamo a registrar.
     * @return true si se añadió correctamente.
     */
    public boolean registrarPrestamo(int idLector, Prestamo prestamo) {
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i] instanceof Lector
                    && personas[i].getId() == idLector) {
                Lector lector = (Lector) personas[i];
                return lector.anadirPrestamo(prestamo);
            }
        }
        return false;
    }

    // =====================================================
    // (4b) REGISTRAR PRÉSTAMO POR ARGUMENTOS (nuevo)
    // =====================================================
    /**
     * Registra un préstamo buscando el libro por ISBN.
     * Si no hay stock, añade al lector a la cola de espera del libro.
     * Aplica las restricciones propias de los Investigadores.
     *
     * @param id    Identificador del nuevo préstamo.
     * @param isbn  ISBN del libro solicitado.
     * @param idP   Identificador del lector.
     * @param fecha Fecha del préstamo.
     * @param idBib Identificador del bibliotecario gestor.
     * @return true si el préstamo se registró (con stock), false en caso contrario.
     */
    public boolean registrarPrestamo(int id, String isbn, int idP,
                                     LocalDate fecha, int idBib) {
        Libro libro = buscarLibroPorIsbn(isbn);
        if (libro == null) return false;

        Persona posibleLector = buscarPorId(idP);
        if (posibleLector == null || !(posibleLector instanceof Lector)) return false;
        Lector lector = (Lector) posibleLector;

        Persona posibleBib = buscarPorId(idBib);
        if (posibleBib == null || !(posibleBib instanceof Bibliotecario)) return false;
        Bibliotecario bib = (Bibliotecario) posibleBib;

        // Restricciones para Investigador
        if (lector instanceof Investigador) {
            Investigador inv = (Investigador) lector;
            if (!bib.getEsInvestigador()) return false;
            if (inv.contarPrestamosSinDevolver() >= inv.getNumPrestamos()) return false;
        }

        if (libro.getStock() <= 0) {
            // Sin stock: añadir a cola de espera
            libro.anadirCola(lector);
            return false;
        }

        // Hay stock: crear y registrar el préstamo
        Prestamo prestamo = new Prestamo(id, fecha, libro.getDiasPrestamo(),
                                         false, bib, libro, lector);
        libro.setStock(libro.getStock() - 1);
        lector.anadirPrestamo(prestamo);
        prestamos.add(prestamo);
        return true;
    }

    // =====================================================
    // (5) CALCULAR PROMEDIO DE EDAD
    // =====================================================
    /**
     * Calcula el promedio de edad de todas las personas del sistema.
     * @return Promedio de edad como double.
     */
    public double calcularPromedioEdad() {
        int sumaEdades = 0;
        int contador   = 0;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null) {
                sumaEdades += personas[i].getEdad();
                contador++;
            }
        }
        return (double) sumaEdades / contador;
    }

    // =====================================================
    // (6) CONTAR POR EDAD
    // =====================================================
    /**
     * Cuenta cuántas personas tienen exactamente la edad indicada.
     * @param edad Edad a filtrar.
     * @return Número de personas con esa edad.
     */
    public int contarPorEdad(int edad) {
        int contador = 0;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].getEdad() == edad) {
                contador++;
            }
        }
        return contador;
    }

    // =====================================================
    // (7) MEDIA DURACIÓN DE PRÉSTAMOS DE UN LECTOR
    // =====================================================
    /**
     * Calcula la media de días de los préstamos devueltos de un lector.
     * @param idLec Identificador del lector.
     * @return Media de días, o -1 si no hay préstamos devueltos o no existe el lector.
     */
    public int calcularMediaDuracion(int idLec) {
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i] instanceof Lector
                    && personas[i].getId() == idLec) {
                Lector lector = (Lector) personas[i];
                int totalDuracion = 0;
                int contador      = 0;
                for (int j = 0; j < lector.getPrestamos().length; j++) {
                    Prestamo prestamo = lector.getPrestamos()[j];
                    if (prestamo != null && prestamo.getDevuelto()) {
                        totalDuracion += prestamo.getDuracionDias();
                        contador++;
                    }
                }
                if (contador == 0) return -1;
                return totalDuracion / contador;
            }
        }
        return -1;
    }

    // =====================================================
    // (8) PRÉSTAMOS GESTIONADOS POR UN BIBLIOTECARIO
    // =====================================================
    /**
     * Cuenta los préstamos gestionados por un bibliotecario concreto.
     * @param idBibliotecario Identificador del bibliotecario.
     * @return Número de préstamos gestionados, o -1 si ninguno.
     */
    public int contarPrestamosGestionados(int idBibliotecario) {
        int contador = 0;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i] instanceof Lector) {
                Lector lector = (Lector) personas[i];
                for (int j = 0; j < lector.getPrestamos().length; j++) {
                    Prestamo prestamo = lector.getPrestamos()[j];
                    if (prestamo != null && prestamo.getBibliotecario() != null
                            && prestamo.getBibliotecario().getId() == idBibliotecario) {
                        contador++;
                    }
                }
            }
        }
        if (contador == 0) contador = -1;
        return contador;
    }

    // =====================================================
    // (9) NOMBRE DEL LECTOR CON MAYOR DURACIÓN TOTAL
    // =====================================================
    /**
     * Devuelve el nombre del lector cuya suma total de días en préstamos es mayor.
     * En caso de empate, devuelve el último encontrado.
     * @return Nombre del lector, o "N/A" si no hay ninguno con préstamos.
     */
    public String nombreMayorDuracion() {
        String nombreMayor  = "";
        int mayorDuracion   = 0;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i] instanceof Lector) {
                Lector lector    = (Lector) personas[i];
                int totalDuracion = 0;
                for (int j = 0; j < lector.getPrestamos().length; j++) {
                    Prestamo prestamo = lector.getPrestamos()[j];
                    if (prestamo != null) {
                        totalDuracion += prestamo.getDuracionDias();
                    }
                }
                if (totalDuracion >= mayorDuracion) {
                    mayorDuracion = totalDuracion;
                    nombreMayor   = lector.getNombre();
                }
            }
        }
        if (mayorDuracion == 0) nombreMayor = "N/A";
        return nombreMayor;
    }

    // =====================================================
    // (10) AÑADIR LIBRO
    // =====================================================
    /**
     * Añade un nuevo libro al catálogo de la biblioteca.
     * @param tit   Título del libro.
     * @param autor Autor del libro.
     * @param isbn  ISBN identificador único.
     * @param stock Ejemplares disponibles.
     * @param diasP Días máximos de préstamo.
     * @return true si se añadió correctamente.
     */
    public boolean anadirLibro(String tit, String autor, String isbn,
                               int stock, int diasP) {
        Libro libro = new Libro(tit, autor, isbn, stock, diasP);
        return libros.add(libro);
    }

    // =====================================================
    // (11) ELIMINAR LIBRO
    // =====================================================
    /**
     * Elimina un libro del catálogo por ISBN. Vacía su cola de espera
     * y marca como devueltos todos sus préstamos pendientes.
     * @param isbn ISBN del libro a eliminar.
     * @return Número de préstamos marcados como devueltos, o -1 si el libro no existe.
     */
    public int eliminarLibro(String isbn) {
        Libro libro = buscarLibroPorIsbn(isbn);
        if (libro == null) return -1;

        // Vaciar cola de espera
        while (!libro.getCola().isEmpty()) {
            libro.sacarCola();
        }

        // Marcar como devueltos los préstamos no devueltos de este libro
        int marcados = 0;
        for (Prestamo p : prestamos) {
            if (p.getLibro() != null && p.getLibro().equals(libro) && !p.getDevuelto()) {
                p.setDevuelto(true);
                marcados++;
            }
        }

        libros.remove(libro);
        return marcados;
    }

    // =====================================================
    // (12) DEVOLVER PRÉSTAMO
    // =====================================================
    /**
     * Procesa la devolución de un préstamo. Penaliza al lector si se devuelve
     * tarde. Incrementa el stock del libro. Si hay lectores en cola de espera,
     * registra automáticamente un nuevo préstamo para el primero.
     * @param idPrestamo      Identificador del préstamo a devolver.
     * @param fechaDevolucion Fecha real de entrega.
     * @param idBib           Identificador del bibliotecario que gestiona la devolución.
     * @return true si se procesó correctamente, false si no se encontró el préstamo.
     */
    public boolean devolverPrestamo(int idPrestamo, LocalDate fechaDevolucion, int idBib) {
        Prestamo p = null;
        for (Prestamo pr : prestamos) {
            if (pr.getId() == idPrestamo) {
                p = pr;
                break;
            }
        }
        if (p == null) return false;

        // Comprobar retraso
        long diasRetraso = ChronoUnit.DAYS.between(p.getFecha(), fechaDevolucion);
        if (diasRetraso > p.getDuracionDias()) {
            Lector lector = p.getLector();
            if (lector != null) lector.setPenalizado(true);
        }

        p.setDevuelto(true);

        // Incrementar stock y registrar lector como lector del libro
        Libro libro = p.getLibro();
        if (libro != null) {
            libro.setStock(libro.getStock() + 1);
            if (p.getLector() != null) {
                libro.anadirLector(p.getLector());
            }

            // Si hay lectores en cola, hacer un nuevo préstamo automático
            if (!libro.getCola().isEmpty()) {
                Lector siguiente = libro.sacarCola();
                int nuevoPrestId = prestamos.size() + 1;
                registrarPrestamo(nuevoPrestId, libro.getIsbn(),
                                  siguiente.getId(), fechaDevolucion, idBib);
            }
        }

        return true;
    }

    // =====================================================
    // (13) DESSANCIONAR PERSONA
    // =====================================================
    /**
     * Quita la sanción a una persona identificada por su id.
     * @param id Identificador de la persona.
     * @return true si se encontró y dessancionó, false si no existe o no estaba sancionada.
     */
    public boolean desSancionarPersona(int id) {
        Persona p = buscarPorId(id);
        if (p == null) return false;
        if (p instanceof Lector) {
            Lector l = (Lector) p;
            if (!l.getPenalizado()) return false;
            l.setPenalizado(false);
            return true;
        }
        return false;
    }

    // =====================================================
    // (14) CONTAR PRÉSTAMOS POR FECHA Y BIBLIOTECARIO
    // =====================================================
    /**
     * Cuenta cuántos préstamos de una fecha concreta ha gestionado un bibliotecario.
     * @param fecha  Fecha de los préstamos a filtrar.
     * @param idBib  Identificador del bibliotecario.
     * @return Número de préstamos que coinciden con la fecha y el bibliotecario.
     */
    public int contarPrestamosDadaUnaFechaConBibliotecario(LocalDate fecha, int idBib) {
        int contador = 0;
        for (Prestamo p : prestamos) {
            if (p.getFecha() != null && p.getFecha().equals(fecha)
                    && p.getBibliotecario() != null
                    && p.getBibliotecario().getId() == idBib) {
                contador++;
            }
        }
        return contador;
    }

    // =====================================================
    // (15) CONTAR LECTORES PENALIZADOS DE LIBROS CON DURACIÓN MAYOR
    // =====================================================
    /**
     * Cuenta cuántos lectores penalizados han leído libros cuya duración
     * de préstamo es superior a la indicada.
     * @param duracion Duración mínima (exclusiva) en días.
     * @return Número de lectores penalizados en esos libros.
     */
    public int contarLibrosMayorDuracioDadaDeSusLectoresPenalizados(int duracion) {
        int contador = 0;
        for (Libro libro : libros) {
            if (libro.getDiasPrestamo() > duracion) {
                for (Lector lector : libro.getLectores()) {
                    if (lector.getPenalizado()) {
                        contador++;
                    }
                }
            }
        }
        return contador;
    }

    // =====================================================
    // (16) LIBRO CON MÁS COLA DE ESPERA
    // =====================================================
    /**
     * Devuelve el libro que tiene más lectores en su cola de espera.
     * @return El libro con mayor cola, o null si no hay libros.
     */
    public Libro libroConMasColaEspera() {
        Libro mayor = null;
        int maxCola = -1;
        for (Libro libro : libros) {
            if (libro.getCola().size() > maxCola) {
                maxCola = libro.getCola().size();
                mayor   = libro;
            }
        }
        return mayor;
    }

    // =====================================================
    // (17) LIBRO CON MÁS PRÉSTAMOS
    // =====================================================
    /**
     * Devuelve el libro que más préstamos ha tenido en total.
     * @return El libro con más préstamos registrados, o null si no hay libros.
     */
    public Libro libroConMasPrestamos() {
        Libro mayor     = null;
        int maxPrestamos = -1;
        for (Libro libro : libros) {
            int count = 0;
            for (Prestamo p : prestamos) {
                if (p.getLibro() != null && p.getLibro().equals(libro)) {
                    count++;
                }
            }
            if (count > maxPrestamos) {
                maxPrestamos = count;
                mayor        = libro;
            }
        }
        return mayor;
    }

    // =====================================================
    // (11) CONTAR TIPOS DE PERSONA
    // =====================================================
    /**
     * Imprime el número de bibliotecarios, lectores e investigadores registrados.
     */
    public void contarTipos() {
        int cBibliotecario = 0, cLector = 0, cInvestigador = 0;
        for (Persona p : personas) {
            if (p instanceof Investigador)       cInvestigador++;
            else if (p instanceof Lector)        cLector++;
            else if (p instanceof Bibliotecario) cBibliotecario++;
        }
        System.out.println("Bibliotecario: " + cBibliotecario +
                           ", Lector: " + cLector +
                           " e Investigador: " + cInvestigador);
    }

    // =====================================================
    // (12) INVESTIGADORES NO PENALIZADOS AL LÍMITE
    // =====================================================
    /**
     * Cuenta los investigadores que no están penalizados pero han alcanzado
     * el límite de préstamos sin devolver permitido.
     * @return Número de investigadores en esa situación.
     */
    public int contarInvestigadoresAlLimite() {
        int contador = 0;
        for (Persona p : personas) {
            if (p instanceof Investigador) {
                Investigador inv = (Investigador) p;
                if (!inv.getPenalizado()
                        && inv.contarPrestamosSinDevolver() == inv.getNumPrestamos()) {
                    contador++;
                }
            }
        }
        return contador;
    }

    // =====================================================
    // MÉTODO AUXILIAR: BUSCAR LIBRO POR ISBN
    // =====================================================
    /**
     * Busca un libro en el catálogo por su ISBN.
     * @param isbn ISBN a buscar.
     * @return El libro encontrado, o null si no existe.
     */
    private Libro buscarLibroPorIsbn(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    // =====================================================
    // MENÚ
    // =====================================================
    /** Muestra el menú interactivo y gestiona las opciones del usuario. */
    public void menu() {
        int op = 0;
        do {
            if (!cv) {
                System.out.println("\n===== BIBLIOTECA =====");
                System.out.println("1. Añadir persona");
                System.out.println("2. Buscar persona por ID");
                System.out.println("3. Contar personas");
                System.out.println("4. Registrar préstamo");
                System.out.println("5. Calcular promedio edad");
                System.out.println("6. Contar por edad");
                System.out.println("7. Media duración (lector)");
                System.out.println("8. Préstamos gestionados (bibliotecario)");
                System.out.println("9. Nombre mayor duración");
                System.out.println("10. Salir");
                System.out.println("11. Contar tipos de persona");
                System.out.println("12. Contar investigadores al límite");
                System.out.print("Opción: ");
            }

            String line = sc.nextLine().trim();
            while (line.isEmpty()) {
                line = sc.nextLine().trim();
            }
            op = Integer.parseInt(line);

            switch (op) {
                case 1:
                    anadirPersona();
                    break;
                case 2:
                    if (!cv) System.out.print("ID a buscar: ");
                    int id = Integer.parseInt(sc.next());
                    Persona persona = buscarPorId(id);
                    if (persona != null) {
                        System.out.println("Persona encontrada: " + persona.getNombre());
                    } else {
                        System.out.println("Persona no encontrada.");
                    }
                    break;
                case 3:
                    System.out.println("Total personas: " + contarPersonas());
                    break;
                case 4:
                    if (!cv) System.out.println("ID del lector: ");
                    int idLector = Integer.parseInt(leerLinea());
                    Persona posiblelec = buscarPorId(idLector);
                    if (posiblelec == null || !(posiblelec instanceof Lector)) {
                        System.out.println("Error: Lector no encontrado");
                        break;
                    }
                    if (!cv) System.out.println("Fecha de prestamo: ");
                    LocalDate fechaPrestamo = LocalDate.parse(leerLinea());
                    if (!cv) System.out.println("Duracion en dias: ");
                    int duracionDias = Integer.parseInt(leerLinea());
                    if (!cv) System.out.println("¿Devuelto?: true/false");
                    boolean devuelto = Boolean.parseBoolean(leerLinea());
                    if (!cv) System.out.println("ID del Bibliotecario: ");
                    int idBib = Integer.parseInt(leerLinea());
                    Persona posibleBib = buscarPorId(idBib);
                    if (posibleBib == null || !(posibleBib instanceof Bibliotecario)) {
                        System.out.println("Error.Bibliotecario no encontrado");
                        break;
                    }
                    Bibliotecario bib = (Bibliotecario) posibleBib;
                    Prestamo prestamo = new Prestamo(fechaPrestamo, duracionDias, devuelto, bib);
                    registrarPrestamo(idLector, prestamo);
                    System.out.println("Bibliotecario: " + bib.getNombre() + " Días: " + duracionDias);
                    break;
                case 5:
                    System.out.println("Promedio edad: " + String.format("%.2f", calcularPromedioEdad()));
                    break;
                case 6:
                    if (!cv) System.out.println("Edad a contar: ");
                    int edad = Integer.parseInt(leerLinea());
                    System.out.println("Total: " + contarPorEdad(edad));
                    break;
                case 7:
                    if (!cv) System.out.println("ID lector: ");
                    int idlec = Integer.parseInt(leerLinea());
                    System.out.println("Media duración: " + calcularMediaDuracion(idlec));
                    break;
                case 8:
                    if (!cv) System.out.println("Bibliotecario: ");
                    int idBib2 = Integer.parseInt(leerLinea());
                    System.out.println("Prestamos gestionados: " + contarPrestamosGestionados(idBib2));
                    break;
                case 9:
                    System.out.println("Mayor duración: " + nombreMayorDuracion());
                    break;
                case 10:
                    System.out.println("Saliendo...");
                    break;
                case 11:
                    contarTipos();
                    break;
                case 12:
                    System.out.println("Contar Modificacion: " + contarInvestigadoresAlLimite());
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (op != 10);
    }

    private String leerLinea() {
        String linea = sc.nextLine().trim();
        while (linea.isEmpty()) {
            linea = sc.nextLine().trim();
        }
        return linea;
    }
}