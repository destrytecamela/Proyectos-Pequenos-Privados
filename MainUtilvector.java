public class MainUtilvector{
    public static void main(String[] args){
        Utilvector u1=new Utilvector();
        u1.fijarTamanio(5);
        u1.iniciaraleat();
        u1.mostrar();
       int x = u1.contarpares();
        System.out.println("existen "+x+" numeros pares");
        int j=u1.sumar();
        System.out.println("la suma es: "+j);
        u1.buscarMayor();
        
        System.out.println(" ");
         Utilvector u2=new Utilvector();
        u2.fijarTamanio(7);
         u2.iniciaraleat();
        u2.mostrar();
         x = u2.contarpares();
        System.out.println("existen "+x+" numeros pares");
        
        System.out.println(" ");
        
         Utilvector u3=new Utilvector();
        u3.fijarTamanio(3);
         u3.iniciaraleat();
        u3.mostrar();
        
         x = u3.contarpares();
        System.out.println("existen "+x+" numeros pares");
        
        System.out.println(" ");
    }
    
    
    
    
    
    
    
    
    
}