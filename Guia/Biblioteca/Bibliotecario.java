public class Bibliotecario extends Persona{
    //Atributos
    private String seccion;
    private boolean esInvestigador;
    
    //CD
    public Bibliotecario (){
        super();
        this.seccion="";
        this.esInvestigador=false;
    }
    public Bibliotecario(int i, String n , int e, String s,boolean a){
        super(i,n,e);
        this.seccion=s;
        this.esInvestigador=a;
    }
    
    //Getter
    public String getSeccion(){
        return seccion;
    }
    public boolean getEsInvestigador(){
        return esInvestigador;
    }
    //Setter
    public void setSeccion(String s){
        this.seccion = s;
    }
    public void setEsInvestigador(boolean a){
        this.esInvestigador=a;
    }
    
    //Metodo
    @Override
    public String toString(){
        return "Bibliotecario{"+"Seccion: "+seccion+"Investigador: "+esInvestigador+", id: "+id+", nombre: "+nombre+", edad: "+edad+"}";
    }
    @Override
    public boolean getSancionado(){
        return false;
    }
}