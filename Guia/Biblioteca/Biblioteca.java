import java.time.LocalDate;
import java.util.Scanner;

public class Biblioteca {
    boolean cv = false;
    private final Scanner sc = new Scanner(System.in);
    private Persona[] personas;

    public Biblioteca() {
        this.personas = new Persona[100];
    }

    public Biblioteca(int tamano) {
        this.personas = new Persona[tamano];
    }

    // =====================================================
    // (1) AÑADIR PERSONA
    // =====================================================
    public boolean anadirPersona() {
        if (!cv) {
            System.out.println("1. Lector");
            System.out.println("2. Bibliotecario");
            System.out.println("3. Investigador");
            System.out.print("Tipo: ");
        }
        int tipo = Integer.parseInt(sc.nextLine());

        if (!cv) System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());

        if (!cv) System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        if (!cv) System.out.print("Edad: ");
        int edad = Integer.parseInt(sc.nextLine());

        Persona nueva = null;

        if (tipo == 1) {
            if (!cv) System.out.print("Fecha de alta (YYYY-MM-DD): ");
            LocalDate fechaAlta = LocalDate.parse(sc.nextLine());
            nueva = new Lector(id, nombre, edad, fechaAlta, false, 10);

        } else if (tipo == 2) {
        if (!cv) System.out.print("Sección: ");
        String seccion = sc.nextLine();
        if (!cv) System.out.print("¿Es investigador? (true/false): ");
        boolean esInv = Boolean.parseBoolean(sc.nextLine());
        nueva = new Bibliotecario(id, nombre, edad, seccion, esInv);

        } else if (tipo == 3) {
            if (!cv) System.out.print("Fecha de alta (YYYY-MM-DD): ");
            LocalDate fechaAlta = LocalDate.parse(sc.nextLine());
            if (!cv) System.out.print("Número máximo de préstamos simultáneos: ");
            int numPrestamos = Integer.parseInt(sc.nextLine());
            nueva = new Investigador(id, nombre, edad, fechaAlta, false, numPrestamos, numPrestamos);
        }

        if (nueva != null) {
            for (int i = 0; i < personas.length; i++) {
                if (personas[i] == null) {
                    personas[i] = nueva;
                    return true;
                }
            }
        }
        return false;
    }

    // =====================================================
    // (2) BUSCAR PERSONA POR ID
    // =====================================================
    public Persona buscarPorId(int id) {
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].getId() == id) {
                return personas[i];
            }
        }
        return null;
    }

    // =====================================================
    // (3) CONTAR PERSONAS
    // =====================================================
    public int contarPersonas() {
        int contador = 0;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null) {
                contador++;
            }
        }
        return contador;
    }

    // =====================================================
    // (4) REGISTRAR PRÉSTAMO
    // =====================================================
    public boolean registrarPrestamo(int idLector, Prestamo prestamo) {
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i] instanceof Lector && personas[i].getId() == idLector) {
                Lector lector = (Lector) personas[i];
                return lector.anadirPrestamo(prestamo);
            }
        }
        System.out.println("Lector no encontrado.");
        return false;
    }

    // =====================================================
    // (5) CALCULAR PROMEDIO DE EDAD
    // =====================================================
    public double calcularPromedioDeEdad() {
        int sumaEdades = 0;
        int contador = 0;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null) {
                sumaEdades += personas[i].getEdad();
                contador++;
            }
        }
        return contador > 0 ? (double) sumaEdades / contador : 0;
    }

    // =====================================================
    // (6) CONTAR POR EDAD
    // =====================================================
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
    public double calcularMediaDuracion(int idLector) {
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i] instanceof Lector && personas[i].getId() == idLector) {
                Lector lector = (Lector) personas[i];
                int totalDuracion = 0;
                int contador = 0;
                for (int j = 0; j < lector.getPrestamos().length; j++) {
                    Prestamo prestamo = lector.getPrestamos()[j];
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
    // (8) PRÉSTAMOS GESTIONADOS POR UN BIBLIOTECARIO
    // =====================================================
    public int contarPrestamosGestionados(int idBibliotecario) {
        int contador = 0;
        for (Persona persona : personas) {
            if (persona != null && persona instanceof Lector) {
                Lector lector = (Lector) persona;
                for (int j = 0; j < lector.getPrestamos().length; j++) {
                    Prestamo prestamo = lector.getPrestamos()[j];
                    if (prestamo != null && prestamo.getBibliotecario() != null
                            && prestamo.getBibliotecario().getId() == idBibliotecario) {
                        contador++;
                    }
                }
            }
        }
        return contador;
    }

    // =====================================================
    // (9) NOMBRE DEL LECTOR CON MAYOR DURACIÓN TOTAL
    // =====================================================
    public String nombreMayorDuracion() {
        String nombreMayor = "";
        int mayorDuracion = 0;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i] instanceof Lector) {
                Lector lector = (Lector) personas[i];
                int totalDuracion = 0;
                for (int j = 0; j < lector.getPrestamos().length; j++) {
                    Prestamo prestamo = lector.getPrestamos()[j];
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
    // (11) CONTAR TIPOS DE PERSONA
    // =====================================================
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
    public int contarInvestigadoresAlLimite() {
        int contador = 0;
        for (Persona p : personas) {
            if (p instanceof Investigador) {
                Investigador inv = (Investigador) p;
                if (!inv.getPenalizado() &&
                        inv.contarPrestamosSinDevolver() == inv.getNumPrestamos()) {
                    contador++;
                }
            }
        }
        return contador;
    }

    // =====================================================
    // MENÚ
    // =====================================================
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

            String line = sc.nextLine();
            op = Integer.parseInt(line);
            while (op < 1 || op > 12) {
                if (!cv) System.out.print("Opción no válida. Intente de nuevo: ");
                line = sc.nextLine();
                op = Integer.parseInt(line);
            }

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
                    System.out.println("Total de personas: " + contarPersonas());
                    break;

                case 4:
                    if (!cv) System.out.print("ID del lector: ");
                    int idLector = Integer.parseInt(sc.nextLine());

                    Persona posibleLector = buscarPorId(idLector);
                    if (posibleLector == null || !(posibleLector instanceof Lector)) {
                        System.out.println("Lector no encontrado.");
                        break;
                    }

                    if (!cv) System.out.print("Fecha de préstamo (YYYY-MM-DD): ");
                    LocalDate fechaPrestamo = LocalDate.parse(sc.nextLine());
                    if (!cv) System.out.print("Duración en días: ");
                    int duracionDias = Integer.parseInt(sc.nextLine());

                    Prestamo prestamo;

                    if (posibleLector instanceof Investigador) {
                        if (!cv) System.out.print("ID del bibliotecario: ");
                        int idBib = Integer.parseInt(sc.nextLine());
                        Persona posibleBib = buscarPorId(idBib);

                        if (posibleBib == null || !(posibleBib instanceof Bibliotecario)) {
                            System.out.println("Bibliotecario no encontrado.");
                            break;
                        }
                        Bibliotecario bib = (Bibliotecario) posibleBib;
                        prestamo = new Prestamo(fechaPrestamo, duracionDias, false, bib);
                    } else {
                        prestamo = new Prestamo(fechaPrestamo, duracionDias, false, null);
                    }

                    boolean registrado = registrarPrestamo(idLector, prestamo);
                    if (registrado) {
                        System.out.println("Préstamo registrado con éxito.");
                    } else {
                        System.out.println("No se pudo registrar el préstamo.");
                    }
                    break;

                case 5:
                    System.out.println("Promedio de edad: " + calcularPromedioDeEdad());
                    break;

                case 6:
                    if (!cv) System.out.print("Edad a contar: ");
                    int edadContar = Integer.parseInt(sc.nextLine());
                    System.out.println("Total de personas con " + edadContar + " años: " + contarPorEdad(edadContar));
                    break;

                case 7:
                    if (!cv) System.out.print("ID del lector: ");
                    int idLectorDuracion = Integer.parseInt(sc.nextLine());
                    System.out.println("Media de duración de préstamos para el lector con ID "
                            + idLectorDuracion + ": " + calcularMediaDuracion(idLectorDuracion) + " días");
                    break;

                case 8:
                    if (!cv) System.out.print("ID del bibliotecario: ");
                    int idBibliotecario = Integer.parseInt(sc.nextLine());
                    System.out.println("Total de préstamos gestionados por el bibliotecario con ID "
                            + idBibliotecario + ": " + contarPrestamosGestionados(idBibliotecario));
                    break;

                case 9:
                    System.out.println("Nombre del lector con mayor duración total de préstamos: "
                            + nombreMayorDuracion());
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
}