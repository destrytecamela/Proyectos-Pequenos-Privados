package ejemplos.clases.Cuenta;
import Cuenta.Cuenta;

public class MainCuenta {
    //main
    public static void main(String[] args) {
        // Crear una cuenta con un titular
        Persona titular = new Persona("Carlos", 12345678, 19);
        Cuenta cuenta = new Cuenta(1001, 0.0, titular);
        System.out.println("Cuenta creada: " + cuenta);
        
        // Realizar algunos movimientos
        cuenta.ingresar(500.00f);
        cuenta.retirar(200.00f);
        cuenta.retirar(400.00f); // Intento de retirar más de lo disponible
        
        System.out.println(cuenta.toString());
    }
}
