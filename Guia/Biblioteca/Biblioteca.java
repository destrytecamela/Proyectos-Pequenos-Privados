// ==========================
// CLASE PRINCIPAL: BIBLIOTECA
// ==========================
import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Biblioteca {
    boolean cv = true
; // Variable de control para el menú. True cuando se suba VPL y false para pruebas locales
    private final Scanner sc = new Scanner(System.in);
    private Persona[] personas;
    //TODO 
    // agregar atributos necesarios para almacenar personas y constructores
public Biblioteca(){
    this.personas=new Persona[100];
}

public Biblioteca(int x){
    this.personas=new Persona[x];
}
    //TODO
    //Agrear métodos necesarios para gestionar la biblioteca (añadir persona, buscar por ID, contar personas, registrar préstamo, etc.)

    // =====================================================        
    // (1) AÑADIR PERSONA 
    // =====================================================
    public boolean anadirPersona() {
        boolean h = false;
        if (!cv) {
            System.out.println("1. Lector");
            System.out.println("2. Bibliotecario");
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
            //TODO
            if(!cv)System.out.print("Fecha de alta (YYYY-MM-DD): ");
            LocalDate fechaAlta=LocalDate.parse(leerLinea());
            boolean a=Boolean.parseBoolean(leerLinea());
            Lector lector = new Lector(id,nombre,edad,fechaAlta,a,10);
            for(int i=0;i<personas.length;i++){
                if(personas[i]==null){
                    personas[i]=lector;
                    h=true;
                    break;
                }
            }
        } else {
            //TODO
            if(!cv)System.out.print("Seccion: ");
            String seccion =leerLinea();
            
            Bibliotecario bibliotecario = new Bibliotecario(id,nombre,edad,seccion,false);
            for(int i=0;i<personas.length;i++){
                if(personas[i]==null){
                    personas[i]=bibliotecario;
                    h=true;
                    break;
                }
            }
        }
        if (h==true){
            System.out.println("Miembro añadido correctamente con id:"+id);
        }
        

        //TODO
        return h;
    }
    // =====================================================
    // (2) Buscar personas por id
    // =====================================================
        public Persona buscarPorId(int id){
            Persona h = null;
            for(int i =0; i< personas.length; i++){
                if(personas[i] != null && personas[i].getId() == id){
                    h=personas[i];
                }
            }
            return h;
        }
    
    // =====================================================
    // (3) Contar personas por edad
    // =====================================================
        public int contarPersonas(){
            int contador=0;
            for(int i = 0; i<personas.length;i++){
                if(personas[i] != null){
                    contador++;
                }
            }
            return contador;
        }
    // =====================================================
    // (4) Registrar préstamo
    // =====================================================
        public boolean registrarPrestamo(int idLector, Prestamo prestamo){
            for(int i= 0;i<personas.length;i++){
                if(personas[i] != null && personas[i] instanceof Lector && personas[i].getId() == idLector){
                    Lector lector = (Lector) personas[i];
                    return lector.anadirPrestamo(prestamo);
                }
            }
            return false;
        }
    // =====================================================
    // (5) Calcular promedio de edad
    // =====================================================
        public double calcularPromedioEdad(){
            int sumaedades= 0;
            int contador=0;
             for(int i= 0;i<personas.length;i++){
                if(personas[i] != null){
                    sumaedades = sumaedades+personas[i].getEdad();
                    contador++;
                }
            }
        return (double) sumaedades/contador;
        }
    // =====================================================
    // (6) Contar por edad
    // =====================================================
        public int contarPorEdad(int edad){
            int contador = 0;
            for(int i= 0;i<personas.length;i++){
                if(personas[i] != null && personas[i].getEdad() ==edad){
                    contador++;
                }
            }
            return contador;
        }
    // =====================================================
    // (7) Media duración de préstamos de un lector
    // =====================================================
        public int calcularMediaDuracion(int idLec){
            int media = 0;
            for(int i = 0;i<personas.length;i++){
                if(personas[i]!=null && personas[i] instanceof Lector && personas[i].getId()==idLec){
                 Lector lector=(Lector) personas[i];
                 int totalduracion=0;
                 int contador=0;
                 for(int j= 0; j<lector.getPrestamos().length;j++){
                     Prestamo prestamo = lector.getPrestamos()[j];
                     if(prestamo!=null&&prestamo.getDevuelto()){
                         totalduracion=totalduracion+prestamo.getDuracionDias();
                         contador++;
                        }  
                    }
                    if(contador==0){return -1;}
                    media=totalduracion/contador;
                }
            }
            if(media==0){
                media=-1;
            }
            return media;
        }
    // =====================================================
    // (8) Prestamos gestionados por un bibliotecario
    // =====================================================
        public int contarPrestamosGestionados(int idBibliotecario){
            int contador=0;
            for(int i= 0;i<personas.length;i++){
                if(personas[i] != null && personas[i] instanceof Lector){
                    Lector lector=(Lector) personas[i];
                    for (int j=0;j<lector.getPrestamos().length;j++){
                        Prestamo prestamo = lector.getPrestamos()[j];
                        if(prestamo != null && prestamo.getBibliotecario() != null && prestamo.getBibliotecario().getId()==idBibliotecario){
                            contador++;
                        }
                    }
                }
            }
            if(contador==0){
                contador=-1;
            }
            return contador;
        }
    // =====================================================
    // (9) Nombre del lector con mayor duración total de préstamos
    // =====================================================
        public String nombreMayorDuracion(){
            String nombreMayor ="";
            int mayorduracion =0;
            for(int i= 0;i<personas.length;i++){
                if(personas[i] != null && personas[i] instanceof Lector){
                    Lector lector=(Lector) personas[i];
                    int totalDuracion=0;
                    for (int j=0;j<lector.getPrestamos().length;j++){
                        Prestamo prestamo = lector.getPrestamos()[j];
                        if(prestamo != null){
                            totalDuracion=totalDuracion+prestamo.getDuracionDias();
                        }
                    }
                    if(totalDuracion>=mayorduracion){
                    mayorduracion=totalDuracion;
                    nombreMayor=lector.getNombre();
                }
            }
        }
        if (mayorduracion==0){nombreMayor="N/A";}
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

            String line = sc.nextLine().trim();
            while (line.isEmpty()){
                line=sc.nextLine().trim();
            }
            op = Integer.parseInt(line);
            

            switch (op) {
                case 1:
                    anadirPersona();
                    break;
                case 2:
                    if(!cv) System.out.print("ID a buscar: ");
                    int id = Integer.parseInt(sc.next());
                    Persona persona = buscarPorId(id);
                    if(persona != null){
                        System.out.println("Persona encontrada: "+persona.getNombre());
                    }
                    else{
                        System.out.println("Persona no encontrada.");
                    }
                    break;

                case 3:
                    System.out.println("Total personas: " + contarPersonas());
                    
                    break;

                case 4:
                    if (!cv){System.out.println("ID del lector: ");}
                    int idLector=Integer.parseInt(leerLinea());
                    Persona posiblelec = buscarPorId(idLector);
                    if(posiblelec==null || !(posiblelec instanceof Lector)){
                    System.out.println("Error: Lector no encontrado");
                    break;
                    }
                    if (!cv){System.out.println("Fecha de prestamo: ");}
                    LocalDate fechaPrestamo = LocalDate.parse(leerLinea());
                    if (!cv){System.out.println("Duracion en dias: ");}
                    int duracionDias = Integer.parseInt(leerLinea());
                    if (!cv){System.out.println("¿Devuelto?: true/false");}
                    boolean devuelto = Boolean.parseBoolean(leerLinea());
                    Prestamo prestamo;
                    
                    if (!cv){System.out.println("ID del Bibliotecario: ");}
                    int idBib=Integer.parseInt(leerLinea());
                    Persona posibleBib = buscarPorId(idBib);
                        
                    if(posibleBib==null || !(posibleBib instanceof Bibliotecario)){
                    System.out.println("Error.Bibliotecario no encontrado");
                    break;
                    }
                    
                    Bibliotecario Bib = (Bibliotecario) posibleBib;
                    prestamo = new Prestamo(fechaPrestamo,duracionDias,devuelto,Bib);
                    registrarPrestamo(idLector, prestamo);
                    System.out.println("Bibliotecario: "+Bib.getNombre()+" Días: "+duracionDias);
                    break;

                case 5:
                    System.out.println("Promedio edad: "+ String.format("%.2f",calcularPromedioEdad()));
                    break;
                    
                case 6:
                    if(!cv){System.out.println("Edad a contar: ");}
                    int edad=Integer.parseInt(leerLinea());
                    System.out.println("Total: "+contarPorEdad(edad));
                    break;

                case 7:
                    if(!cv){System.out.println("ID lector: ");}
                    int idlec=Integer.parseInt(leerLinea());
                    System.out.println("Media duración: "+calcularMediaDuracion(idlec));
                    break;

                case 8:
                    if(!cv){System.out.println("Bibliotecario: ");}
                    int idBib2=Integer.parseInt(leerLinea());
                    System.out.println("Prestamos gestionados: "+contarPrestamosGestionados(idBib2));
                    break;

                case 9:
                    System.out.println("Mayor duración: "+nombreMayorDuracion());
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
        private String leerLinea(){
        String linea =sc.nextLine().trim();
        while (linea.isEmpty()){
            linea=sc.nextLine().trim();
        }
        return linea;
    }
}