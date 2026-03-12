
/**
 * Write a description of class Banco here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Banco
{
    private String nombre;
    private int maxCuentas;
    private Cuenta[] cuentas;
    //CD y CP
    public Banco(){
        nombre="";
        maxCuentas=10;
        cuentas=new Cuenta[maxCuentas];
    }
    public Banco(String n, int m){
        nombre=n;
        maxCuentas=m;
        cuentas=new Cuenta[maxCuentas];
    }
    //getters y setters
    public String getNombre() {
        return nombre;
    } 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }   
     public int getMaxCuentas() {
        return maxCuentas;
    }
    public void setMaxCuentas(int maxCuentas) {
        this.maxCuentas = maxCuentas;
    }   
     public Cuenta[] getCuentas() {
        return cuentas;
    }
    public void setCuentas(Cuenta[] cuentas) {
        this.cuentas = cuentas;
    }
    //funciones
    //anadir una cuenta al banco
    public boolean anadirCuenta(Cuenta c){
        for(int i=0; i<cuentas.length;i++){
            if(cuentas[i]==null){
                cuentas[i]=c;
                return true;
            }
        }
        return false;
    }
    public Cuenta buscarCuenta(long numeroCuenta){
        for(int i=0; i<cuentas.length;i++){
            if(cuentas[i]!=null){
                if(cuentas[i].getNumero()==numeroCuenta){
                    return cuentas[i];
                }
            }
        }
        return null;
    }

    //ingresar dinero a una cuenta
    public boolean ingresar(long numeroCuenta, float cantidad){
        Cuenta c=buscarCuenta(numeroCuenta);
        if(c!=null){
            c.ingresar(cantidad);
            return true;
        }
        return false;
    }
    //retirar dinero de una cuenta
    public boolean retirar(long numeroCuenta, float cantidad){
        Cuenta c=buscarCuenta(numeroCuenta);
        if(c!=null){
            c.retirar(cantidad);
            return true;
        }
        return false;
    }

    //transferir dinero de una cuenta a otra
    public boolean transferir(long numeroCuentaOrigen, long numeroCuentaDestino, float cantidad){
        Cuenta cOrigen=buscarCuenta(numeroCuentaOrigen);
        Cuenta cDestino=buscarCuenta(numeroCuentaDestino);
        if(cOrigen!=null && cDestino!=null){
            if(cOrigen.retirar(cantidad)){
                cDestino.ingresar(cantidad);
                return true;
            }
        }
        return false;
    }
}