
/**
 * Clase main para las cuentas, aqui interactuamos con ellas creandolas y haciendo operaciones.
 * 
 * @author Carlos 
 * @version 1.0
 */
public class MainCuenta
{
    /**
     * @param args
     */
    public static void main(String[] args) {
        Cuenta c1= new CuentaNormal();
        Cuenta c2= new CuentaJoven();
        Cuenta c3= new CuentaAhorros();
        Cuenta c4= new CuentaMix();
        
        c1.ingresar(500);
        c2.ingresar(500);
        c3.ingresar(500);
        c4.ingresar(500);
        
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
        System.out.println(c4.toString());
        
        System.out.println(" ");
        
        c1.retirar(100);
        c2.retirar(100);
        c3.retirar(100);
        c4.retirar(100);
        
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
        System.out.println(c4.toString());
        System.out.println(" ");
        System.out.println("Vectores de cuentas");
        System.out.println(" ");
        
        //ahora con array
        Cuenta[]v=new Cuenta[10];
        v[0]=c1;
        v[1]=c2;
        v[2]=c3;
        v[3]=c4;
        
        //ingresar
        for(int i=0; i<v.length;i++){
            if(v[i]!=null){
                v[i].ingresar(500);
            }
        }
        //mostrar
        for(int i=0; i<v.length;i++){
            if(v[i]!=null){
                System.out.println(v[i].toString());
            }
        }
        //retirar
        for(int i=0; i<v.length;i++){
            if(v[i]!=null){
                v[i].retirar(100);
            }
        }
        //mostrar
        for(int i=0; i<v.length;i++){
            if(v[i]!=null){
                System.out.println(v[i].toString());
            }
        }
        System.out.println(" ");
        //media de saldo
        double media=0;
        int cont=0;
        for(int i=0; i<v.length;i++){
            if(v[i]!=null){
                media=media+v[i].getSaldo();
                cont++;
            }
        }
        System.out.println("La media de saldo es: "+media/cont);

        System.out.println(" ");
        //cuenta con mayor saldo
        int w=0;
        for(int i=0; i<v.length;i++){
            if(v[i]!=null){
                if(v[i].getSaldo()>v[w].getSaldo()){
                    w=i;
                }
            }
        }
        System.out.println("La cuenta con mayor saldo es: "+v[w].toString());

        System.out.println(" ");

        //inconveniende del polimorfismo y solucion
        int contj=0;
        for(int i=0; i<v.length;i++){
            if(v[i] instanceof CuentaJoven){
                contj++;
                //mostrar porcentaje --> upcasting
                CuentaJoven aux=(CuentaJoven) v[i];
                aux.getPorcentaje();
                 
                
            }
        }
        System.out.println("Número de cuentas jóvenes: " + contj);

        //inconveniente del polimorfismo y solucion getclass
        int contj2=0;
        for(int i=0; i<v.length;i++){
            if(v[i]!=null){
                if(v[i].getClass()==CuentaJoven.class){
                    contj2++;
                    //mostrar porcentaje --> upcasting
                    CuentaJoven aux=(CuentaJoven) v[i];
                    aux.getPorcentaje();
                }
            }
        }
        System.out.println("Número de cuentas jóvenes (con getClass): " + contj2);
    }
}
