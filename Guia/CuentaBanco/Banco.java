import java.time.LocalDate;

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
    
    //funciones
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
    
    public boolean ingresar(long numeroCuenta, float cantidad){
        Cuenta c=buscarCuenta(numeroCuenta);
        if(c!=null){
            c.ingresar(cantidad);
            return true;
        }
        return false;
    }
    
    public boolean retirar(long numeroCuenta, float cantidad){
        Cuenta c=buscarCuenta(numeroCuenta);
        if(c!=null){
            c.retirar(cantidad);
            return true;
        }
        return false;
    }
    
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
    
     public int contarCuentasPorDni(int DNI){
        int x = 0;
        for(int i=0; i<cuentas.length;i++){
            if(cuentas[i]!=null){
                if(cuentas[i].getTitular().getDni()==DNI){
                    x++;
                }
            }
        } 
        return x;
    }
    
     public int contarSaldosNegativos(){
        int x = 0;
        for(int i=0; i<cuentas.length;i++){
            if(cuentas[i]!=null){
                if(cuentas[i].getSaldo()<0){
                    x++;
                }
            }
        } 
        return x;
    }
    
    public float saldoTotal(){
        float x = 0.0F;
        for(int i=0; i<cuentas.length;i++){
            if(cuentas[i]!=null){
                x=x+cuentas[i].getSaldo();
            }
        } 
        return x;
    }
    
    public int contarCuentaJoven(){
        int x =0;
        for (int i = 0; i<cuentas.length;i++){
            if(cuentas[i]!=null){
                 if(cuentas[i] instanceof CuentaJoven){
                    x++;
                }
            }
        }
        return x;
    }
    
    public void mostrarCuentaJoven(){
        int x = contarCuentaJoven();
        System.out.println("El número de cuentas jovenes es: " + x);
    }
    
    public Cuenta cuentaMayorSaldo(){
             Cuenta cMayor=null;
        for(int i=0; i<cuentas.length;i++){
            if(cuentas[i]!=null){
                if(cMayor==null || cuentas[i].getSaldo()>cMayor.getSaldo()){
                    cMayor=cuentas[i];
                }
            }
        } 
        return cMayor;
    }
    
    public boolean incrementarSalarios(LocalDate fecha){
        boolean hecho=false;
        for(int i=0; i<cuentas.length;i++){
            if(cuentas[i]!=null){
                if(cuentas[i] instanceof CuentaNomina){
                    CuentaNomina aux=(CuentaNomina) cuentas[i];
                    boolean hecho2=aux.incrementarSalario(fecha);
                    hecho=hecho || hecho2;
                }
            }
        } 
        return hecho;
    }
    
     public void listarCuentas(){
        for(int i=0; i<cuentas.length;i++){
            if(cuentas[i]!=null){
                System.out.println(cuentas[i].toString());
            }
        } 
    }
    
    public int contarMov1K(){
        int Mov = 0;
        for(int i=0; i<cuentas.length;i++){
            if(cuentas[i]!=null){
                for (int h=0; h<cuentas[i].getMovs().length;h++){
                    if(cuentas[i].getMovs()[h]!=null){
                        if(cuentas[i].getMovs()[h].getCantidad()>=1000){
                            Mov++;
                        }
                    }
                }
            }
        }
        return Mov;
    }
}
        