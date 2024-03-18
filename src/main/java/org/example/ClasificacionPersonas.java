package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Persona {
    String sexo;
    int edad;

    public Persona(String sexo, int edad) {
        this.sexo = sexo;
        this.edad = edad;
    }
}

public class ClasificacionPersonas {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();

        String directorioActual = System.getProperty("user.dir");
        String rutaRelativa = "src/main/java/org/example/datos_personas.txt";
        String rutaArchivo = directorioActual + File.separator + rutaRelativa;

        try {
            File archivoPersonas = new File(rutaArchivo);
            Scanner scanner = new Scanner(archivoPersonas);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(",");
                String sexo = partes[0];
                int edad = Integer.parseInt(partes[1]);
                personas.add(new Persona(sexo, edad));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no fue encontrado.");
            e.printStackTrace();
        }

        int mayoresDeEdad = 0, menoresDeEdad = 0, hombresMayores = 0, mujeresMenores = 0, totalMujeres = 0;

        for (Persona persona : personas) {
            if (persona.edad >= 18) {
                mayoresDeEdad++;
                if ("masculino".equals(persona.sexo)) {
                    hombresMayores++;
                }
            } else {
                menoresDeEdad++;
                if ("femenino".equals(persona.sexo)) {
                    mujeresMenores++;
                }
            }
            if ("femenino".equals(persona.sexo)) {
                totalMujeres++;
            }
        }

        double porcentajeMayoresDeEdad = mayoresDeEdad * 100.0 / personas.size();
        double porcentajeMujeres = totalMujeres * 100.0 / personas.size();

        System.out.println("Total de personas procesadas: " + personas.size());
        System.out.println("Cantidad de personas mayores de edad: " + mayoresDeEdad);
        System.out.println("Cantidad de personas menores de edad: " + menoresDeEdad);
        System.out.println("Cantidad de personas masculinas mayores de edad: " + hombresMayores);
        System.out.println("Cantidad de personas femeninas menores de edad: " + mujeresMenores);
        System.out.printf("Porcentaje de personas mayores de edad respecto al total: %.2f%%\n", porcentajeMayoresDeEdad);
        System.out.printf("Porcentaje de mujeres respecto al total de personas: %.2f%%\n", porcentajeMujeres);
    }
}
