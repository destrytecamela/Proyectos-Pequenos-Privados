import java.time.LocalDate;
public class Prestamo{
    //atributos
    private LocalDate fechaPrestamo;
    private int duracionDias;
    private boolean devuelto;
    private Bibliotecario bibliotecario;
    
    //constructor por defecto
    public Prestamo(){
        this.fechaPrestamo=LocalDate.now();
        this.duracionDias=0;
        this.devuelto=false;
        this.bibliotecario=new Bibliotecario();
    }
    
    //constructor por parametros
    public Prestamo(LocalDate fechaPrestamo,int duracionDias,boolean devuelto, Bibliotecario b){
        this.fechaPrestamo=fechaPrestamo;
        this.duracionDias=duracionDias;
        this.devuelto=devuelto;
        this.bibliotecario=b;
    }
    
    //getters y setters
    public LocalDate getFechaPrestamo(){
        return fechaPrestamo;
    }
    public int getDuracionDias(){
        return duracionDias;
    }
    public boolean getDevuelto(){
        return devuelto;
    }
    public Bibliotecario getBibliotecario(){
        return bibliotecario;
    }
    
    public void setFechaPrestamo(LocalDate fechaPrestamo){
        this.fechaPrestamo=fechaPrestamo;
    }
    public void setDuracionDias(int duracionDias){
        this.duracionDias=duracionDias;
    }
    public void setDevuelto(boolean devuelto){
        this.devuelto=devuelto;
    }
    public void setBibliotecario(Bibliotecario b){
        this.bibliotecario=b;
    }
    //Metodos
    public boolean marcarDevuelto(){
        if(!devuelto){
            devuelto=true;
            return true;
        }
        return false;
    }
    public boolean asignarBibliotecario(Bibliotecario bibliotecario){
        if(this.bibliotecario==null||this.bibliotecario.getId()!=bibliotecario.getId()){
            this.bibliotecario = bibliotecario;
            return true;
        }
        return false;
    }
}