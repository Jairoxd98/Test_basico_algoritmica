package org.example;
import java.util.Scanner;
public class NumerosParImpar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número: ");
        int numero = scanner.nextInt();

        if (numero % 2 == 0) {
            System.out.println("El número " + numero + " es par.");
            for (int i = numero; i >= 0; i -= 2) {
                System.out.println(i);
            }
        } else {
            System.out.println("El número " + numero + " es impar.");
            for (int i = numero; i >= 1; i -= 2) {
                System.out.println(i);
            }
        }
    }
}
