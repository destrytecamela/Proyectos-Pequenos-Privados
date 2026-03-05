

public abstract class Cuenta {
protected  long numero;
protected  double saldo;
protected TitularCuenta titular;  //Composicion unaria
protected Movimiento[] movs;//composicion n-aria

//Constructores
public Cuenta() {
    numero = 0;
    saldo = 0.0;
    titular = new TitularCuenta();
    movs = new Movimiento[100]; //Ejemplo de array para almacenar movimientos
}

public Cuenta(long n, double s, TitularCuenta t) {
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
public TitularCuenta getTitular() {
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
public void setTitular(TitularCuenta t) {
    titular = t;
}
public void setMovs(Movimiento[] m) {
    movs = m;
}
//toString
@Override
public String toString() {
    return "Cuenta[numero=" + numero + ", saldo=" + saldo + ", titular=" + titular.getNombre() + "]";
} 
//Métodos adicionales
public boolean anadirMovimiento(Movimiento m){
    for (int i = 0; i < movs.length; i++) {
        if (movs[i] == null) { // Encuentra la primera posición vacía
            movs[i] = m; 
            return true;
        }
    }
    return false;
}

public boolean ingresar(float cantidad){
    if(cantidad <0){ return false;}
    else{
    Movimiento m=new Movimiento(cantidad,0);
    boolean anadido=anadirMovimiento(m);
    if(anadido){
    saldo= saldo +  cantidad;
    return true;
    }
    else{return false;}
    }
}

public boolean retirar(float cantidad){
    if(cantidad <0 || cantidad > saldo){ return false;}
    else{
    Movimiento m=new Movimiento(cantidad,1);
    boolean retirado=anadirMovimiento(m);
    if(retirado){
    saldo= saldo -  cantidad;
    return true;
    }
    else{return false;}
    }

}
}
