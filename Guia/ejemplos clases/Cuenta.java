public class Cuenta {
private long numero;
private double saldo;
private Persona titular;  //Composicion unaria
private Movimiento[] movs;//composicion n-aria

//Constructores
public Cuenta() {
    numero = 0;
    saldo = 0.0;
    titular = new Persona();
    movs = new Movimiento[100]; //Ejemplo de array para almacenar movimientos
}

public Cuenta(long n, double s, Persona t) {
    numero = n;
    saldo = s;
    titular = t;
    movs = new Movimiento[100]; //Ejemplo de array para almacenar movimientos
}

//Getters
public long getNumero() {
    return numero;
}
public double getSaldo() {
    return saldo;
}
public Persona getTitular() {
    return titular;
}
public Movimiento[] getMovs() {
    return movs;
}
//Setters
public void setNumero(long n) {
    numero = n;
}
public void setSaldo(double s) {
    saldo = s;
}
public void setTitular(Persona t) {
    titular = t;
}
public void setMovs(Movimiento[] m) {
    movs = m;
}
//toString
public String toString() {
    return "Cuenta{numero=" + numero + ", saldo=" + saldo + ", titular=" + titular + "}";
} 















}
