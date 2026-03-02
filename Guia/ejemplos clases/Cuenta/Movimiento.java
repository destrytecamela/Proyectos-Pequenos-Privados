package Cuenta;
import java.time.*;

/**
 * Clase movimiento que sirve para representar un movimiento bancario
 * 
 * @author Carlos Zambrano 
 * @version 1.0
 */

public class Movimiento {
    private float cantidad;
    private int tipos;
    private LocalDate fecha;
//CD/CP
public Movimiento () { 
        cantidad=0.0f;
        tipos=0;
        fecha= LocalDate.now();
    }
    
public Movimiento(float c,int t, LocalDate f){
    cantidad=c;
    tipos=t;
    fecha=f;
}

public Movimiento(float c, int t){
    cantidad=c;
    tipos=t;
    fecha= LocalDate.now();
}
  
//getters  
public float getCantidad(){
    return cantidad;
}

public int getTipos(){
    return tipos;
}

public LocalDate getFecha(){
    return fecha;
}

//Setters
public void setCantidad(float c){
    cantidad=c;
}
public void setTipos(int t){
    tipos=t;
}
public void setFecha(LocalDate f){
    fecha=f;
}
//toString
public String toString(){
    return "Movimiento: " + cantidad + " euros, tipo: " + tipos + ", fecha: " + fecha;
}

    
    
}