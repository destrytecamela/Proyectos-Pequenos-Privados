public abstract class Persona{
    //Atributos
    protected int id;
    protected String nombre;
    protected int edad;
    
    //Constructor por defecto
    public Persona(){
        this.id = 0;
        this.nombre="";
        this.edad=0;
    }
    //Constructor parametrizado
    public Persona(int i,String n,int e){
        this.id=i;
        this.nombre=n;
        this.edad=e;
    }
    
    //Getters y Setters
    public void setId(int i){
        this.id=i;
    }
    public void setNombre(String n){
        this.nombre=n;
    }
    public void setEdad(int e){
        this.edad=e;
    }
    
    public int getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public int getEdad(){
        return edad;
    }
    //toString
    
    public String toString(){
        return "Persona{ "+"id: "+id+", nombre: "+nombre+", edad: "+edad+"}";
    }
    //equals
    
    
    //Metodos
    public abstract boolean getSancionado();
    public String mostrarInformacion(){
        return "ID: "+id+", Nombre: "+ ", Edad: "+edad;
    }
   
    
    
    
    
    
    
    
}