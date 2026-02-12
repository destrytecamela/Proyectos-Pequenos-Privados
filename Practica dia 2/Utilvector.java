import java.util.Random;
import java.io.*;

public class Utilvector{
    //atributo
    private int []v;
    //metodos - procedimientos - vectores
    public void fijarTamanio(int tam){
        //instanciacion
        v=new int[tam];
    }
    public void iniciaraleat(){
         Random rnd = new Random();
        for (int i=0;i<v.length;i++){ 
        v[i] = rnd.nextInt(10);
        }
    }
    public void mostrar(){
        for (int x =0; x < v.length;x++){
        System.out.print(v[x] + " ");
        }
        System.out.println(" ");
    }
    public int contarpares(){
          int x = 0;
    for(int i = 0;i<v.length;i++){
    if(v[i]%2==0){
        x++;
    }
}
    //System.out.println("existen "+x+" numeros pares");
        return x;
    }
    public int sumar(){
          int j = 0;
    for(int k = 0;k<v.length;k++){
    j=j+v[k];
}
    //System.out.println("la suma es: "+j);
        return j;
    }
    public void buscarMayor(){
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
    }
}
