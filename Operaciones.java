import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

class Operaciones {

    public static void LlenarVector() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el numero del vector: ");
        int n = leer.nextInt();
        int V[] = new int[n];
        int par = 2;
        for (int i = 0; i < n; i++) {

            V[i] = par;
            par = par + 2;
            System.out.println("Vector en la posicion " + i + ": " + V[i]);

        }

    }

    public static void LLenarArrayList() {
        ArrayList<Integer> Vector = new ArrayList<Integer>();
        Vector.add(1);
        Vector.add(1, 2);
        System.out.println(Vector.get(0));
        Vector.set(0, 10);
        System.out.println(Vector.get(0));

    }

    public static void crearHipos(Hipo hipo)
            throws IOException {
        FileWriter fw = new FileWriter("hipo.csv", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(hipo.toString());
        bw.newLine();
        bw.close();
    }

    public static List<Hipo> leerHipos()
            throws IOException {
        List<Hipo> lista = new ArrayList<>();
        Scanner sc = new Scanner(new File("hipo.csv"));

        while (sc.hasNextLine()) {
            String[] datos = sc.nextLine().split(",");
            lista.add(new Hipo(
                    datos[0],
                    Integer.parseInt(datos[1])));
        }
        sc.close();
        return lista;
    }

    public static void actualizarHipo(String color,
            int tamaño)
            throws IOException {

        List<Hipo> lista = leerHipos();
        BufferedWriter bw = new BufferedWriter(new FileWriter("hipo.csv"));

        for (Hipo u : lista) {
            if (u.getTamaño() == tamaño) {
                u.setColor(color);
            }
            bw.write(u.toString());
            bw.newLine();
        }
        bw.close();
    }

    public static void eliminarUsuario(int tamaño)
            throws IOException {

        List<Hipo> lista = leerHipos();
        BufferedWriter bw = new BufferedWriter(new FileWriter("hipo.csv"));

        for (Hipo u : lista) {
            if (u.getTamaño() != tamaño) {
                bw.write(u.toString());
                bw.newLine();
            }
        }
        bw.close();
    }

    public static List<Usuario> leerUsuarios()
            throws IOException {
        List<Usuario> lista = new ArrayList<>();
        Scanner sc = new Scanner(new File("usuarios.csv"));

        while (sc.hasNextLine()) {
            String[] datos = sc.nextLine().split(",");
            lista.add(new Usuario(
                    Integer.parseInt(datos[0]),
                    datos[1],
                    Integer.parseInt(datos[2]),
                    datos[3],
                    datos[4]));
        }
        sc.close();
        return lista;
    }

    Map<Integer, Usuario> idxId = new HashMap<>(); // primaria
    Map<String, List<Usuario>> idxCity = new HashMap<>(); // secundaria

    public void construirIndices() {
        idxId.clear();
        idxCity.clear();

        List<Usuario> data = leerUsuarios();

        for (Usuario u : data) {

            // Primario
            idxId.put(u.getId(), u);

            // Secundario no único (ciudad)
            String ciudadKey = u.getCity();
            if (!idxCity.containsKey(ciudadKey)) {
                idxCity.put(ciudadKey, new ArrayList<>());
            }

            idxCity.get(ciudadKey).add(u);
        }
    }

    public boolean crear(Usuario nuevo) throws IOException {

        if (idxId.containsKey(nuevo.getId())) {
            System.out.println(" ID ya existe.");
            return false;
        }

        try (FileWriter fw = new FileWriter("usuarios.csv", true);
        BufferedWriter bw = new BufferedWriter(fw);) {
            bw.write(nuevo.toString());
            bw.newLine();
        }


        return true;
    }

}