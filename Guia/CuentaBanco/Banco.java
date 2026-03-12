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

    //transferir dinero de una cuenta a otra si no se puede ingresar o retirar no cambia nada
    public boolean transferir(long numeroCuentaOrigen, long numeroCuentaDestino, float cantidad){
        Cuenta cOrigen=buscarCuenta(numeroCuentaOrigen);
        Cuenta cDestino=buscarCuenta(numeroCuentaDestino);
        if(cOrigen!=null && cDestino!=null){
            if(cOrigen.getSaldo()>=cantidad){
                cOrigen.retirar(cantidad);
                cDestino.ingresar(cantidad);
                return true;
            }
        }
        return false;
    }
    //contar cuentas que posee un titular con un DNI dado
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

    //contar saldos negativos
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

    //saldo total de todas las cuentas
    public float saldoTotal(){
        float x = 0;
        for(int i=0; i<cuentas.length;i++){
            if(cuentas[i]!=null){
                x=x+cuentas[i].getSaldo();
            }
        } 
        return x;
    }

    //contar cuentas jovenes
    public int contarCuentasJovenes(){
        int x = 0;
        for(int i=0; i<cuentas.length;i++){
            if(cuentas[i]!=null){
                if(cuentas[i] instanceof CuentaJoven){
                    x++;
                }
            }
        } 
        return x;
    }

    //mostrar contador de cuentas jovenes
    public void mostrarContadorCuentasJovenes(){
        int x = contarCuentasJovenes();
        System.out.println("El número de cuentas jovenes es: " + x);
    }

    //cuenta mayor saldo
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
    //incrementar salarios(fecha) boolean
    public void incrementarSalarios(LocalDate fecha){
        for(int i=0; i<cuentas.length;i++){
            if(cuentas[i]!=null){
                if(cuentas[i] instanceof CuentaNomina){
                    CuentaNomina aux=(CuentaNomina) cuentas[i];
                    aux.incrementarSalario(fecha);
                }
            }
        } 
    }
//listar cuentas
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