package Guia;

import java.util.Scanner;

public class PersonaMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Pedir datos por teclado
        System.out.println("Introduce nombre:");
        String nombre = scanner.nextLine();
        
        System.out.println("Introduce apellidos:");
        String apellidos = scanner.nextLine();
        
        System.out.println("Introduce dni (sin letra):");
        int dni = scanner.nextInt();
        
        System.out.println("Introduce edad:");
        int edad = scanner.nextInt();
        
        // Crear objeto Persona
        Persona persona = new Persona(nombre, apellidos, dni, edad);
        
        // Imprimir resultado
        System.out.println("Nombre completo: " + persona.getNombreCompleto());
        System.out.println("Edad par: " + persona.esEdadPar());
        System.out.println("Letra DNI: " + persona.calcularLetraDNI());
        
        scanner.close();
    }
}
