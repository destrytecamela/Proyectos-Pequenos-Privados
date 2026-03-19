import java.time.LocalDate;

/**
 * Write a description of class CuentaNomina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CuentaNomina extends Cuenta{
    private float salario;
    private float porcentaje;
    private int dia;
    
    //CD y CP
    public CuentaNomina(){
        super();
        salario=0.00F;
        porcentaje=0.01F;
        dia=1;
        
    }
    public CuentaNomina(long n, float s, TitularCuenta t,float s2,float p,int d){
        super(n, s, t);
        salario=s2;
        porcentaje=p;
        dia=d;
        
    }
    //getters y setters
    public float getSalario() {
        return salario;
    }
    public void setSalario(float salario) {
        this.salario = salario;
    }   
     public float getPorcentaje() {
        return porcentaje;
    }
    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }
     public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    
    //resto de metodos 
    //toString
    @Override
    public String toString() {
        return "CuentaNomina{" +
                "salario=" + salario +
                ", porcentaje=" + porcentaje +
                ", dia=" + dia +
                "} " + super.toString();
    }
    //equals solo numero de cuenta
     @Override
    public boolean equals(Object o){
       CuentaNomina aux=(CuentaNomina) o;
      if (this.numero==aux.getNumero()) return true;
      else return false;
    }
    public boolean incrementarSalario(LocalDate fecha){ //cada dia 23 se incrementa el salario por el porcentaje
        if(fecha.getDayOfMonth()==23){
            double incremento=salario*porcentaje;
            salario+=incremento;
            return true;
        }
        return false;
       
        
    }
    
}