
/**
 * 
 * 
 * @author Carlos
 * @version 1.0
 */
public class CuentaAhorros extends Cuenta {
    //atributos especiales
    private float porcentaje;
    // Constructor
    /**
     * Constructor por defecto,Inicializa todos los atributos
     */
    public CuentaAhorros(){
        super();
        porcentaje=0.01F;
    }
    /**
     * Constructor Parametrizado.
     * @param numero Numero de cuenta
     * @param saldo Saldo inicial
     * @param titular Persona titular de la cuenta
     * @param p Porcentaje de incremento al retirar
     */
    public CuentaAhorros(long numero, double saldo, TitularCuenta titular, float p) {
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
    
    //redefinir metodos de cuent
    @Override
    /**
     * Metodo encargado de retirar un saldo p a la cuenta. En este caso se incrementa en el porcentaje indicado
     * @param p Cantidad a retirar
     * @return True si es correcto y falso en caso contrario
     */
    
    public boolean retirar(float p){
        float cantidad = p+p*porcentaje;
        return super.retirar(cantidad);
        
    }
    
    @Override
    public String toString(){
        return "CuentaAhorros[numero=" + numero + ", saldo=" + saldo + ", titular=" + titular.getNombre() + ", porcentaje=" + porcentaje + "]";  
    }
    
  
}