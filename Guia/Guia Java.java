import java.io.*; //se importan las clases necesarias para leer por teclado y manejar excepciones
import java.util.Scanner; //se importa la clase Scanner para leer por teclado cuando se use esa opción
import java.util.Random; //se importa la clase Random para generar números aleatorios
import java.text.DecimalFormat; //se importa la clase DecimalFormat para formatear números decimales
import java.time.LocalDate; //se importa la clase LocalDate para manejar fechas
import java.time.format.DateTimeFormatter; //se importa la clase DateTimeFormatter para formatear fechas
public class Prueba{ //se declara la clase Prueba otros nombres pueden ser Main, Ejemplo, etc.

    public static void main (String[] args)  throws IOException    {    //se declara el método main que puede lanzar una excepción de tipo IOException al leer por teclado
       
       /*
       Para leer por teclado se puede usar dos opciones. 
            - Reader: Siempre se debe leer una cadena (String) y luego convertir a entero o al tipo que sea. 
            - Scanner: Con esta opción se lee directamente el tipo pero no siempre funciona en campusvirtual
       */
       
       
        //Leer mediante Reader
	    InputStreamReader reader=new InputStreamReader(System.in); //se crea un objeto de la clase InputStreamReader para leer por teclado
        BufferedReader Input=new BufferedReader (reader); //se crea un objeto de la clase BufferedReader para leer por teclado de forma más eficiente
        System.out.print("Introduzca la edad: "); //se muestra un mensaje para que el usuario sepa qué debe introducir
        String s=Input.readLine(); //se lee una línea de texto por teclado y se almacena en la variable s
        x=Integer.parseInt(s); //se convierte la cadena s a un número entero y se almacena en la variable x
        
        
         // Leer mediante Scanner
          Scanner in = new Scanner (System.in); //Otro mecanismo de lectura
          //Leer cadenas
          String s= int.nextLine(); //se lee una línea de texto por teclado y se almacena en la variable s
          System.out.println(s); //se muestra la cadena leída por teclado
          //Leer enteros
          x= in.nextInt(); //se lee un número entero por teclado y se almacena en la variable x
          System.out.println(x); //se muestra el número entero leído por teclado
        
        //Forzar a que el número tenga dos decimales
        float x = 0; //se declara la variable x como decimal (float)
        x=x - 273.15f; //cuando se opera con un número decimal se debe indicar que el número es decimal con la letra f (float) al final
        DecimalFormat df=new DecimalFormat("0.00"); //se crea un objeto de la clase DecimalFormat para formatear el número con dos decimales
        System.out.println("x en C: " + df.format(x)); //se muestra el número formateado con dos decimales

        //crear numero aleatorio
        Random rnd = new Random(); //se crea un objeto de la clase Random para generar números aleatorios
        int n = rnd.nextInt(10); //se genera un número aleatorio entre 0 y 9 (10 no incluido) y se almacena en la variable n
         int n = rnd.nextInt(100) + 1; //se genera un número aleatorio entre 1 y 100 (100 incluido) y se almacena en la variable n

         //crear un array
         int []v=new int[10]; //se declara un array de enteros llamado v con capacidad para 10 elementos
         //mostrar un array 
        for (int y =0; y < v.length;y++){ //se recorre el array desde la posición 0 hasta la posición v.length-1
        System.out.print(v[y] + " "); //se muestra el elemento del array en la posición y seguido de un espacio
        }
        //inicializar un array con números aleatorios
        Random rnd = new Random(); //se crea un objeto de la clase Random para generar números aleatorios
        for (int i=0;i<v.length;i++){ //se recorre el array desde la posición 0 hasta la posición v.length-1
        v[i] = rnd.nextInt(10); //se asigna a la posición i del array un número aleatorio entre 0 y 9 (10 no incluido)
        }
        //contar pares en un array
        int x = 0; //se declara la variable x para contar el número de pares
        for(int i = 0;i<v.length;i++){ //se recorre el array desde la posición 0 hasta la posición v.length-1
        if(v[i]%2==0){ //se verifica si el elemento en la posición i es par (si el resto de dividirlo entre 2 es 0)
        x++; //si es par, se incrementa el contador x en 1
            }
        }
        System.out.println("Número de pares: " + x); //se muestra el número de pares encontrados en el array

        //leer posicion y valor y asignarlo a un array
        System.out.print("Introduce la posición: "); //se muestra un mensaje para que el usuario sepa qué debe introducir
        String s=Input.readLine(); //se lee una línea de texto por teclado y se almacena en la variable s
        int pos=Integer.parseInt(s); //se convierte la cadena s a un número entero y se almacena en la variable pos
        System.out.print("Introduce el valor: "); //se muestra un mensaje para que el usuario sepa qué debe introducir
        s=Input.readLine(); //se lee una línea de texto por teclado y se almacena en la variable s
        int val=Integer.parseInt(s); //se convierte la cadena s a un número entero y se almacena en la variable val
        v[pos]=val; //se asigna el valor val a la posición pos del array    
        //crear una clase con atributos y métodos
        //los archivos Persona.java y PersonaMain.java son un ejemplo de esto, donde se define una clase Persona con atributos como nombre, apellidos, dni y edad, y métodos para obtener el nombre completo, verificar si la edad es par y calcular la letra del DNI. Luego, en el archivo PersonaMain.java se crea un objeto de la clase Persona, se le asignan valores a sus atributos mediante la lectura por teclado, y se llaman a los métodos para mostrar los resultados.
        
        //Crear un menú con opciones
            System.out.println("Menú de opciones:"); //se muestra un mensaje para que el usuario sepa qué opciones tiene    
        System.out.println("1. Opción 1"); //se muestra la opción 1
        System.out.println("2. Opción 2"); //se muestra la opción 2
        System.out.println("3. Opción 3"); //se muestra la opción 3
        System.out.print("Introduce una opción: "); //se muestra un mensaje para que el usuario sepa qué debe introducir
        String s=Input.readLine(); //se lee una línea de texto por teclado y se almacena en la variable s
        int opcion=Integer.parseInt(s); //se convierte la cadena s a un número entero y se almacena en la variable opcion
        switch(opcion){ //se evalúa la variable opcion para ejecutar el bloque de código correspondiente
            case 1: //si opcion es 1
                System.out.println("Has elegido la opción 1"); //se muestra un mensaje indicando que se ha elegido la opción 1
                break; //se sale del switch
            case 2: //si opcion es 2
                System.out.println("Has elegido la opción 2"); //se muestra un mensaje indicando que se ha elegido la opción 2
                break; //se sale del switch
            case 3: //si opcion es 3
                System.out.println("Has elegido la opción 3"); //se muestra un mensaje indicando que se ha elegido la opción 3
                break; //se sale del switch
            default: //si opcion no es ninguna de las anteriores
                System.out.println("Opción no válida"); //se muestra un mensaje indicando que la opción no es válida
        }
        
        //poner fecha actual
        LocalDate fechaActual = LocalDate.now(); //se obtiene la fecha actual y se almacena en la variable fechaActual
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //se crea un objeto de la clase DateTimeFormatter para formatear la fecha en el formato día/mes/año
        String fechaFormateada = fechaActual.format(formato); //se formatea la fecha actual utilizando el formato definido y se almacena en la variable fechaFormateada
        System.out.println("Fecha actual: " + fechaFormateada); //se muestra la fecha actual formateada

        //poner fecha introducida por teclado
        System.out.print("Introduce una fecha (dd/MM/yyyy): "); //se muestra un mensaje para que el usuario sepa qué debe introducir
        String s=Input.readLine(); //se lee una línea de texto por teclado y se almacena en la variable s
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //se crea    un objeto de la clase DateTimeFormatter para formatear la fecha en el formato día/mes/año
        LocalDate fechaIntroducida = LocalDate.parse(s, formato); //se convierte la cadena s a un objeto de tipo LocalDate utilizando el formato definido y se almacena en la variable fechaIntroducida
        System.out.println("Fecha introducida: " + fechaIntroducida.format(formato)); //se muestra la fecha introducida formateada
        
        //polimorfismo y herencia
        //los archivos Cuenta.java, CuentaJoven.java, CuentaAhorros.java y CuentaMix.java son un ejemplo de esto,
        //donde se define una clase abstracta Cuenta con atributos como numero, saldo, titular y movs, y métodos para ingresar, retirar y añadir movimientos. Luego, se definen tres clases que heredan de Cuenta: CuentaJoven, CuentaAhorros y CuentaMix, cada una con sus propios atributos y métodos que redefinen los métodos de la clase Cuenta para implementar comportamientos específicos. 
        // En el archivo Prueba.java se pueden crear objetos de cada tipo de cuenta y llamar a sus métodos para ver cómo funcionan.

        //array poliformico
        Cuenta[] cuentas = new Cuenta[3]; //se declara un array de tipo Cuenta con capacidad para 3 elementos
        cuentas[0] = new CuentaJoven(12345, 1000, new TitularCuenta("Juan", "Pérez", "12345678A", LocalDate.of(2005, 5, 15)), 0.05f); //se crea un objeto de tipo CuentaJoven y se asigna a la posición 0 del array
        cuentas[1] = new CuentaAhorros(54321, 2000, new TitularCuenta("María", "Gómez", "87654321B", LocalDate.of(1990, 10, 20)), 0.02f); //se crea un objeto de tipo CuentaAhorros y se asigna a la posición 1 del array
        cuentas[2] = new CuentaMix(67890, 1500, new TitularCuenta("Carlos", "López", "11223344C", LocalDate.of(1985, 3, 30)), 0.03f, 0.01f); //se crea un objeto de tipo CuentaMix y se asigna a la posición 2 del array
        for (int i = 0; i < cuentas.length; i++) { //se recorre el array de cuentas desde la posición 0 hasta la posición cuentas.length-1
            System.out.println(cuentas[i].toString()); //se muestra la información de cada cuenta utilizando el método toString
        }

        //inconveniente del polimorfismo
        //no se puede acceder directamente a los metodos especificos de cada clase hija
        //por ejemplo, si queremos acceder al porcentaje de incremento de una CuentaJoven, no podemos hacerlo directamente desde el array de cuentas porque el tipo del array es Cuenta, que no tiene ese método. 
        // Para solucionar esto, tendríamos que hacer un casting a CuentaJoven para poder acceder a ese método específico, lo cual puede ser peligroso si no se verifica previamente que el objeto realmente es una instancia de CuentaJoven.
        //Ejemplo:
        Cuenta cuenta = cuentas[0]; //se asigna la primera cuenta del array a una variable de tipo Cuenta
        if (cuenta instanceof CuentaJoven) { //se verifica si la cuenta es una instancia de CuentaJoven
            CuentaJoven cuentaJoven = (CuentaJoven) cuenta; //se hace un casting a CuentaJoven para poder acceder a sus métodos específicos
            System.out.println("Porcentaje de incremento al ingresar: " + cuentaJoven.getPorcentaje()); //se muestra el porcentaje de incremento al ingresar de la cuenta joven
        } else {
            System.out.println("La cuenta no es una CuentaJoven"); //si la cuenta no es una instancia de CuentaJoven, se muestra un mensaje indicando que no se puede acceder al método específico
        }
        //tambien se puede usar getClass() para verificar el tipo de la cuenta antes de hacer el casting, lo cual es más seguro:
        if (cuenta.getClass() == CuentaJoven.class) { //se verifica si la clase de la cuenta es exactamente CuentaJoven
            CuentaJoven cuentaJoven = (CuentaJoven) cuenta; //se hace un casting a CuentaJoven para poder acceder a sus métodos específicos
            System.out.println("Porcentaje de incremento al ingresar: " + cuentaJoven.getPorcentaje()); //se muestra el porcentaje de incremento al ingresar de la cuenta joven
        } else {
            System.out.println("La cuenta no es una CuentaJoven"); //si la cuenta no es una instancia de CuentaJoven, se muestra un mensaje indicando que no se puede acceder al método específico
        }
        //------------------------------------------------------------------------
        
        //1ºEjemplo
        int x=0;
         String s=Input.readLine();
        x=Integer.parseInt(s); //Convertir de cadena a int
        if(x<0){System.out.println("negativo");}
        if(x<=12){System.out.println("Niño");}
        if(x>12 && x<18){System.out.println("Adolescente");}
        */
        //------------------------------------------------------------------------
        
        //2ºEjemplo
        int x=0;
        int m=0;
        int y=0;
        int z=0;
        
        System.out.print("Introduce un entero: ");
         String s=Input.readLine();
        x=Integer.parseInt(s); //Convertir de cadena a int
        System.out.print("Introduce un entero: ");
         String h=Input.readLine();
        y=Integer.parseInt(h); //Convertir de cadena a int
        System.out.print("Introduce un entero: ");
         String i=Input.readLine();
        z=Integer.parseInt(i); //Convertir de cadena a int
        
        if(x>m){
            m=x;}
        if(y>m){
            m=y;}
        if(z>m){
            m=z;}

        System.out.print("El mayor es: " + m);
        
        //----------------------------------------------------------------------------------------------

        //Ejemplo 3 (Evaluable 1)
         InputStreamReader reader=new InputStreamReader(System.in);
        BufferedReader Input=new BufferedReader (reader);
        
        String nom=Input.readLine();
        String eda=Input.readLine();
        int edad=Integer.parseInt(eda);
        String num=Input.readLine();
        int numero=Integer.parseInt(num);
        String tem=Input.readLine();
        float temperatura=Float.parseFloat(tem);
        
        System.out.println("Hola, "+nom+"!");
        if(edad<0){System.out.println("edad negativa");}
        if(edad<18){System.out.println("Menor de edad");}
        else{System.out.println("Mayor de edad");}
        if(numero%2==0){System.out.println("Par");}
        else{System.out.println("Impar");}
        
        temperatura=temperatura - 273.15f; //aqui se convierte la temperatura de Kelvin a Celsius restando 273.15 al valor de temperatura, y se indica que el número es decimal con la letra f (float) al final para que la operación se realice correctamente
        DecimalFormat df=new DecimalFormat("0.00"); //se crea un objeto de la clase DecimalFormat para formatear el número con dos decimales
        System.out.println("Temperatura en C: " + df.format(temperatura)); //se muestra la temperatura formateada con dos decimales
        
        //----------------------------------------------------------------------------------------------

        //Ejemplo 4 (Evaluable 2)
         InputStreamReader reader=new InputStreamReader(System.in);
    BufferedReader Input=new BufferedReader (reader);
    int venta = 0;
    int Re = 0;
    int Bo = 0;
    int Du = 0;
    int ttv = 0;
   
    String x=Input.readLine();
    int decision = Integer.parseInt(x);
    while(decision==1 || decision== 2 || decision==3){
     if(decision==1){
         Re=Re+1;
         ttv=ttv+1;
         venta=venta+2;
     }  
     if(decision==2){
         Bo=Bo+1;
         ttv=ttv+1;
         venta=venta+5;
     }  
     if(decision==3){
         Du=Du+1;
         ttv=ttv+1;
         venta=venta+1;
     }  
       
       
    x=Input.readLine();
    decision = Integer.parseInt(x);
    }
    if(decision==-1){
        System.out.println("Total ventas: " + ttv);
        System.out.println("Refrescos: " + Re);
        System.out.println("Bocadillos: " + Bo);
        System.out.println("Dulces: " + Du);
        System.out.println("Ingresos: " + venta);
    }
    else{
        System.out.println("error");
        decision=-1;
    }

    //----------------------------------------------------------------------------------------------
    
    //Ejemplo 5 (Evaluable 3)
     InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader Input = new BufferedReader(reader);
        String s =Input.readLine();
        int n=Integer.parseInt(s);
        if(n<=0){System.out.println("error");}
        else{
            s=Input.readLine();
            int u=Integer.parseInt(s);
            if(u<0){System.out.println("error");}
            else{
                int max = 0;
                int min = 99999999;
                int suma = 0;
                int umbral=0;
                int media=0;
                for(int x =0 ; x<n;x++){
                    s=Input.readLine();
                    int p=Integer.parseInt(s);
                    if(p<0){System.out.println("error");return;}
                    
                    if(p>max){max=p;}
                    if(p<min){min=p;}
                    suma=suma+p; //suma de todas las potencias
                    if(p>u){umbral++;}
            
                }
                media=suma/n; //media
                System.out.println("Máxima: "+max);
                System.out.println("Mínima: "+min);
                System.out.println("Media: "+ media);
                System.out.println("Superan el umbral: " + umbral);
            }
        }
    //----------------------------------------------------------------------------------------------
    //Ejemplo 6 array
     InputStreamReader reader=new InputStreamReader(System.in);
        BufferedReader Input=new BufferedReader (reader);
        int []v=new int[10];
        Random rnd = new Random();
        for (int i=0;i<v.length;i++){ 
        v[i] = rnd.nextInt(10);
        }
        for (int x =0; x < v.length;x++){
        System.out.print(v[x] + " ");
        }
        System.out.println(" ");
        
        int x = 0;
        for(int i=0;i<v.length;i++){
            if(v[i]%2==0){
                x++;
            }
        }
        System.out.println("Existen "+x+" números pares");
        
    }
}