import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Elija su opcion");
        System.out.println(" 1. Llenar vector con pares \n 2. Llenar ArrayList \n 3. Crear Hipo");
        int opcion = leer.nextInt();
        while (opcion != 6) {

            switch (opcion) {
                case 1:
                    Operaciones.LlenarVector();
                    break;
                case 2:
                    Operaciones.LLenarArrayList();
                    break;
                case 3:
                    System.out.println(" q color ");
                    String color = leer.next();
                    System.out.println(" q tamaño ");
                    int tamaño = leer.nextInt();
                    Hipo hipo = new Hipo(color, tamaño);
                    try {
                        Operaciones.crearHipos(hipo);

                    } catch (Exception e) {
                        System.out.println("error");
                    }
                    break;
                case 4:
                    System.out.println(" q color ");
                    String colori = leer.next();
                    System.out.println(" q tamaño ");
                    int tamañi = leer.nextInt();
                    try {
                        Operaciones.actualizarHipo(colori, tamañi);
                    } catch (Exception e) {
                        System.out.println("error");
                    }
                    break;
                default:
                    break;
            }
            System.out.println("Elija su opcion");
            System.out.println(" 1. Llenar vector con pares \n 2. Llenar ArrayList \n 3. Crear Hipo");
            opcion = leer.nextInt();
        }

    }

}