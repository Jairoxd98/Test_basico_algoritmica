package org.example;

import java.util.Scanner;

public class CalculoSalario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese las horas trabajadas: ");
        int horasTrabajadas = scanner.nextInt();
        System.out.print("Ingrese la tarifa por hora: ");
        double tarifa = scanner.nextDouble();

        double sueldo;
        if (horasTrabajadas <= 40) {
            sueldo = horasTrabajadas * tarifa;
        } else {
            int horasExtras = horasTrabajadas - 40;
            sueldo = 40 * tarifa + horasExtras * (tarifa * 1.5);
        }

        System.out.println("El sueldo total es: " + sueldo);
    }
}

