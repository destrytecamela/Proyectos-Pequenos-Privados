import java.util.Random;
import java.io.*;

public class Ejemplo1{
    public static void main(String[] args) throws IOException{
        InputStreamReader reader=new InputStreamReader(System.in); //se crea un objeto de la clase InputStreamReader para leer por teclado
        BufferedReader Input=new BufferedReader (reader); //se crea un objeto de la clase BufferedReader para leer por teclado de forma más eficiente
   
        //Definir un array
        int []v=new int[10];
        //mostrar un array
        for (int y =0; y < v.length;y++){
        System.out.print(v[y] + " ");
        }
        System.out.println(" ");
        //inicializar aleatorio
        Random rnd = new Random();
        for (int i=0;i<v.length;i++){ 
        v[i] = rnd.nextInt(10);
        }
        //Mostrar
        for (int x =0; x < v.length;x++){
        System.out.print(v[x] + " ");
        }
        System.out.println(" ");
        //contar pares
        int x = 0;
    for(int i = 0;i<v.length;i++){
    if(v[i]%2==0){
        x++;
    }
}
    System.out.println("existen "+x+" numeros pares");
        //sumar
        int j = 0;
    for(int k = 0;k<v.length;k++){
    j=j+v[k];
}
    System.out.println("la suma es: "+j);
    
        //buscar el mayor
        int may = 0;
        int rep= 0;
        for(int o = 0;o<v.length;o++){
            if(may<v[o]){
                may=v[o];
                rep=0;
            }
            if(may == v[o]){
                rep++;
            }
        }
        System.out.println("el mayor es: "+may+" se repite: "+rep+" veces");
        
        //leer posicion y valor y asignarolo
        System.out.print("Introduce la posición: "); //se muestra un mensaje para que el usuario sepa qué debe introducir
        String s=Input.readLine(); //se lee una línea de texto por teclado y se almacena en la variable s
        int pos=Integer.parseInt(s); //se convierte la cadena s a un número entero y se almacena en la variable pos
        System.out.print("Introduce el valor: "); //se muestra un mensaje para que el usuario sepa qué debe introducir
        s=Input.readLine(); //se lee una línea de texto por teclado y se almacena en la variable s
        int val=Integer.parseInt(s); //se convierte la cadena s a un número entero y se almacena en la variable val
        v[pos]=val; //se asigna el valor val a la posición pos del array    
    }

}