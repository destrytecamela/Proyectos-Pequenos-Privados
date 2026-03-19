/**
 * Write a description of class CuentaJoven here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CuentaJoven extends Cuenta {
    //atributos especiales
    private float porcentaje;
    // Constructor
    /**
     * Constructor por defecto,Inicializa todos los atributos
     */
    public CuentaJoven(){
        super();
        porcentaje=0.01F;
    }
    /**
     * Constructor Parametrizado.
     * @param numero Numero de cuenta
     * @param saldo Saldo inicial
     * @param titular Persona titular de la cuenta
     * @param p Porcentaje de increment al ingresar
     */
    public CuentaJoven(long numero, float saldo, TitularCuenta titular, float p) {
        super(numero, saldo, titular);
        porcentaje=p;
    }
    //getters y setters
    public float getPorcentaje(){
        return porcentaje;
    }
    
    public void setPorcentaje(float p){
        porcentaje=p;
    }
    
    //redefinir metodos de cuenta
    @Override
    /**
     * Metodo encargado de añadir un saldo p a la cuenta. En este caso se incrementa en el porcentaje indicado
     * @param p Cantidad a ingresar
     * @return True si es correcto y falso en caso contrario
     */
    
    public boolean ingresar(float p){
        float cantidad = p+p*porcentaje;
        return super.ingresar(cantidad);
        
    }
    
    @Override
    /**
     * Metodo encargado de mostrar la informacion de la cuenta joven, incluyendo el porcentaje de incremento
     */
    public String toString(){
        return "CuentaJoven[numero=" + numero + ", saldo=" + saldo + ", titular=" + titular.getNombre() + ", porcentaje=" + porcentaje + "]";  
    }
    
    }
    