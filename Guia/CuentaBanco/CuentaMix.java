
/**
 * Write a description of class CuentaMix here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CuentaMix extends Cuenta {
    //atributos propios
    private float porcentajeing;
    private float porcentajeret;
    // Constructor
    public CuentaMix(){
        super();
        porcentajeing=0.01F;
        porcentajeret=0.01F;
    }
    /**
     * Constructor Parametrizado.
     * @param numero Numero de cuenta
     * @param saldo Saldo inicial
     * @param titular Persona titular de la cuenta
     * @param pi Porcentaje de incremento al ingresar
     * @param pr Porcentaje de incremento al retirar
     */
    public CuentaMix(long numero, float saldo, TitularCuenta titular,float pi,float pr) {
        super(numero, saldo, titular);
        porcentajeing=pi;
        porcentajeret=pr;
    }
    //getters y setters
    public float getPorcentajeIngreso (){
        return porcentajeing;
    }
    public float getPorcentajeRetiro(){
        return porcentajeret;
    }
    
    public void setPorcentajeIngreso(float pi){
        porcentajeing=pi;
    }
    public void setPorcentajeRetiro(float pr){
        porcentajeret=pr;
    }
    
    //redefinir metodos
    @Override
    /**
     * Metodo encargado de añadir un saldo p a la cuenta. En este caso se incrementa en el porcentaje indicado
     * @param p Cantidad a ingresar
     * @return True si es correcto y falso en caso contrario
     */
    public boolean ingresar(float p){
        float cantidad = p+p*porcentajeing;
        return super.ingresar(cantidad);
    }
    @Override
    /**
     * Metodo encargado de retirar un saldo p a la cuenta. En este caso se incrementa en el porcentaje indicado
     * @param p Cantidad a retirar
     * @return True si es correcto y falso en caso contrario
     */
    public boolean retirar(float p){
        float cantidad = p+p*porcentajeret;
        return super.retirar(cantidad);
        
    }
     
    @Override
    public String toString(){
        return "CuentaMix[numero=" + numero + ", saldo=" + saldo + ", titular=" + titular.getNombre() + ", porcentaje de ingreso=" + porcentajeing + 
        ", porcentaje de reiro " + porcentajeret + "]";  
    }
    
 
}