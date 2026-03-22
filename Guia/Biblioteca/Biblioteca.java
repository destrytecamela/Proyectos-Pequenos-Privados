// ==========================
// CLASE PRINCIPAL: BIBLIOTECA
// ==========================

import java.time.LocalDate;
import java.util.Scanner;

public class Biblioteca {
    boolean cv = false; // Variable de control para el menú. True cuando se suba VPL y false para pruebas locales
    private final Scanner sc = new Scanner(System.in);
    private Persona[] personas;

    //TODO 
    // agregar atributos necesarios para almacenar personas y constructores
    public Biblioteca() {
        this.personas = new Persona[100]; // Suponiendo un tamaño máximo de 100 personas
    }

    public Biblioteca(int tamano) {
        this.personas = new Persona[tamano];
    }

    //TODO
    //Agrear métodos necesarios para gestionar la biblioteca (añadir persona, buscar por ID, contar personas, registrar préstamo, etc.)
    // =====================================================        
    // (1) AÑADIR PERSONA 
    // =====================================================
    public boolean anadirPersona() {
        if (!cv) {
            System.out.println("1. Lector");
            System.out.println("2. Bibliotecario");
            System.out.print("Tipo: ");
        }
        int tipo = Integer.parseInt(sc.nextLine());

        if (!cv) System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());

        if (!cv) System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        if (!cv) System.out.print("Edad: ");
        int edad = Integer.parseInt(sc.nextLine());

        if (tipo == 1) {
            if (!cv) System.out.print("Fecha de alta (YYYY-MM-DD): ");
            LocalDate fechaAlta = LocalDate.parse(sc.nextLine());

            Lector lector = new Lector(id, nombre, edad, fechaAlta, false, 10);
            for (int i = 0; i < personas.length; i++) {
                if (personas[i] == null) {
                    personas[i] = lector;
                    return true;
                }
            }
        } else {
            if (!cv) System.out.print("Sección: ");
            String seccion = sc.nextLine();

            Bibliotecario bibliotecario = new Bibliotecario(id, nombre, edad, seccion);
            for (int i = 0; i < personas.length; i++) {
                if (personas[i] == null) {
                    personas[i] = bibliotecario;
                    return true;
                }
            }
        }
        return true;
    }
    // =====================================================
    // (2) buscar persona por ID
    // =====================================================
    public Persona buscarPorId(int id) {
        for (Persona persona : personas) {
            if (persona != null && persona.getId() == id) {
                return persona;
            }
        }
        return null; // Retorna null si no se encuentra la persona
    }
    // =====================================================
    // (3) Contar personas (lectores, bibliotecarios, total)
    // =====================================================
    public int contarPersonas() {
        int contador = 0;
        for (Persona persona : personas) {
            if (persona != null) {
                contador++;
            }
        }
        return contador;
    }
    // =====================================================
    // (4) Registrar préstamo
    // =====================================================
        public boolean registrarPrestamo(int idLector, Prestamo prestamo) {
            for (Persona persona : personas) {
                if (persona != null && persona instanceof Lector && persona.getId() == idLector) {
                    Lector lector = (Lector) persona;
                    return lector.anadirPrestamo(prestamo);
                }
            }
            System.out.println("Lector no encontrado.");
            return false;
        }
    // =====================================================
    // (5) Calcular promedio de edad
    // =====================================================
        public double calcularPromedioDeEdad() {
            int sumaEdades = 0;
            int contador = 0;

            for (Persona persona : personas) {
                if (persona != null) {
                    sumaEdades += persona.getEdad();
                    contador++;
                }
            }
            return contador > 0 ? (double) sumaEdades / contador : 0;
        }
    // =====================================================
    // (6) Contar por edad
    // =====================================================
        public int contarPorEdad(int edad) {
            int contador = 0;
            for (Persona persona : personas) {
                if (persona != null && persona.getEdad() == edad) {
                    contador++;
                }
            }
            return contador;
        }
    // =====================================================
    // (7) Media duración de préstamos de un lector
    // =====================================================
        public double calcularMediaDuracion(int idLector) {
            for (Persona persona : personas) {
                if (persona != null && persona instanceof Lector && persona.getId() == idLector) {
                    Lector lector = (Lector) persona;
                    int totalDuracion = 0;
                    int contador = 0;

                    for (Prestamo prestamo : lector.getPrestamos()) {
                        if (prestamo != null) {
                            totalDuracion += prestamo.getDuracionDias();
                            contador++;
                        }
                    }
                    return contador > 0 ? (double) totalDuracion / contador : 0;
                }
            }
            System.out.println("Lector no encontrado.");
            return 0;
        }
    // =====================================================
    // (8) Prestamos gestionados por un bibliotecario
    // =====================================================
    public int contarPrestamosGestionados(int idBibliotecario) {
        int contador = 0;
        for (Persona persona : personas) {
            if (persona != null && persona instanceof Lector) {
                Lector lector = (Lector) persona;
                for (Prestamo prestamo : lector.getPrestamos()) {
                    if (prestamo != null && prestamo.getBibliotecario() != null && prestamo.getBibliotecario().getId() == idBibliotecario) {
                        contador++;
                    }
                }
            }
        }
        return contador;
    }
    // =====================================================
    // (9) Nombre del lector con mayor duración total de préstamos
    // =====================================================
    public String nombreMayorDuracion() {
        String nombreMayor = "";
        int mayorDuracion = 0;

        for (Persona persona : personas) {
            if (persona != null && persona instanceof Lector) {
                Lector lector = (Lector) persona;
                int totalDuracion = 0;

                for (Prestamo prestamo : lector.getPrestamos()) {
                    if (prestamo != null) {
                        totalDuracion += prestamo.getDuracionDias();
                    }
                }
                if (totalDuracion > mayorDuracion) {
                    mayorDuracion = totalDuracion;
                    nombreMayor = lector.getNombre();
                }
            }
        }
        return nombreMayor;
    }

    // =====================================================
    // MENÚtrue => sin salida para modo VPL
    // =====================================================
    public void menu() {
        int op=0;
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
                System.out.print("Opción: ");
            }

            String line = sc.nextLine();
            op = Integer.parseInt(line);

            switch (op) {
                case 1:
                    anadirPersona();
                    break;
                case 2:
                    if (!cv) System.out.print("ID a buscar: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Persona persona = buscarPorId(id);
                    if (persona != null) {
                        System.out.println("Persona encontrada: " + persona);
                    } else {
                        System.out.println("Persona no encontrada.");
                    }
                    break;

                case 3:
                    int totalPersonas = contarPersonas();
                    System.out.println("Total de personas: " + totalPersonas);
                    break;

                case 4:
                        if (!cv) System.out.print("ID del lector: ");
                        int idLector = Integer.parseInt(sc.nextLine());
                        System.out.print("Fecha de préstamo (YYYY-MM-DD): ");
                        LocalDate fechaPrestamo = LocalDate.parse(sc.nextLine());
                        System.out.print("Duración en días: ");
                        int duracionDias = Integer.parseInt(sc.nextLine());
                        Prestamo prestamo = new Prestamo(fechaPrestamo, duracionDias, false, null);
                        boolean registrado = registrarPrestamo(idLector, prestamo);
                        if (registrado) {
                            System.out.println("Préstamo registrado con éxito.");
                        } else {
                            System.out.println("No se pudo registrar el préstamo.");
                        }

                    break;

                case 5:
                    double promedioEdad = calcularPromedioDeEdad();
                    System.out.println("Promedio de edad: " + promedioEdad);

                    break;

                case 6:
                    if (!cv) System.out.print("Edad a contar: ");
                    int edadContar = Integer.parseInt(sc.nextLine());
                    int totaldePersonas = contarPorEdad(edadContar);
                    System.out.println("Total de personas con " + edadContar + " años: " + totaldePersonas);

                    break;

                case 7:
                    if (!cv) System.out.print("ID del lector: ");
                    int idLectorDuracion = Integer.parseInt(sc.nextLine()); 
                    double mediaDuracion = calcularMediaDuracion(idLectorDuracion);
                    System.out.println("Media de duración de préstamos para el lector con ID " + idLectorDuracion + ": " + mediaDuracion + " días");
                    break;

                case 8:
                    if (!cv) System.out.print("ID del bibliotecario: ");
                    int idBibliotecario = Integer.parseInt(sc.nextLine());
                    int totalPrestamos = contarPrestamosGestionados(idBibliotecario);
                    System.out.println("Total de préstamos gestionados por el bibliotecario con ID " + idBibliotecario + ": " + totalPrestamos);

                    break;

                case 9:
                    String nombreMayor = nombreMayorDuracion();
                    System.out.println("Nombre del lector con mayor duración total de préstamos: " + nombreMayor);
                    break;

                case 10:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (op != 10);
    }
}


