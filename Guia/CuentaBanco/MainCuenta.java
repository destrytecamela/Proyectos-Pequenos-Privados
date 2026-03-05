
/**
 * Clase main para las cuentas, aqui interactuamos con ellas creandolas y haciendo operaciones.
 * 
 * @author Carlos 
 * @version 1.0
 */
public class MainCuenta
{
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
        
        c1.retirar(100);
        c2.retirar(100);
        c3.retirar(100);
        c4.retirar(100);
        
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());
        System.out.println(c4.toString());
        
        
    }
}
