import java.util.Random;
import java.io.*;

public class Ejemplo1{
    public static void main(String[] args) throws IOException{
   
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
        InputStreamReader reader=new InputStreamReader(System.in); 
        BufferedReader Input=new BufferedReader (reader); 
        
        
        //ver si el vector esta ordenado
    
    
    
    
    }

}