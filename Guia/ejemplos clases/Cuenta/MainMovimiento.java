package Cuenta;
/**
 * Write a description of class MainMovimiento here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.time.LocalDate;

public class MainMovimiento
{
   public static void main(String[] args) {
       // 1) Crear movimientos con la fecha de hoy (se asigna en el constructor)
       Movimiento m1 = new Movimiento(150.00f, 0); // 0 = ingreso
       Movimiento m2 = new Movimiento(40.00f , 1); // 1 = retirada
       System.out.println("Movimientos creados por defecto (fecha hoy):");
       System.out.println(" - " + m1); //Llama al método toString
       System.out.println(" - " + m2);
       // 2) Crear un movimiento y ajustar la fecha manualmente
       Movimiento m3 = new Movimiento(300.00f,0);
       m3.setFecha(LocalDate.of(2025, 12, 31)); // ejemplo de fecha específica
       System.out.println("\nMovimiento con fecha ajustada manualmente:");
       System.out.println(" - " + m3);
       // 3) Guardar varios movimientos en un array y listarlos
       Movimiento[] historico = new Movimiento[5];
       historico[0] = m1;
       historico[1] = m2;
       historico[2] = m3;
       historico[3] = new Movimiento(20.00f ,1 );
       historico[4] = new Movimiento(10.00f , 0);
       System.out.println("\nListado de histórico de movimientos:");
       for(Movimiento m : historico) {
           System.out.println(m.toString());
       }
       // 4) Cálculo simple: total ingresado y total retirado
       double totalIngresos = 0.0;
       double totalRetiros = 0.0;
       for(int i = 0; i < historico.length; i++) {
           Movimiento m = historico[i];
           if (m.getTipos() == 0) totalIngresos += m.getCantidad();
           else totalRetiros += m.getCantidad();
       }
       System.out.println("\nResumen:");
       System.out.println(" - Total ingresado: " + totalIngresos);
       System.out.println(" - Total retirado : " + totalRetiros);
   }
}