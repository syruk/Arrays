import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BuscarPareja {

    public static void main(String[] args) {
        String[] animals = {"león", "mandril", "suricata", "facóquero", "jirafa", "elefante", "rinoceronte", "cebra", "hipopótamo", "tigre"};
        String[] couples = new String[20];
        boolean[] visibles = new boolean[20];

        List<String> animalsList = new ArrayList<>(Arrays.asList(animals));
        Collections.shuffle(animalsList);
        for (int i = 0; i < 10; i++) {
            couples[i] = animalsList.get(i);
            couples[i + 10] = animalsList.get(i);
        }
        Collections.shuffle(Arrays.asList(couples));

        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido al juego de buscar parejas!");

        while (!allVisibles(visibles)) {
            showBoard(visibles, couples);

            System.out.print("Ingrese la primera posición (0-19): ");
            int posicion1 = scanner.nextInt();
            System.out.print("Ingrese la segunda posición (0-19): ");
            int posicion2 = scanner.nextInt();

            if (posicion1 < 0 || posicion1 >= 20 || posicion2 < 0 || posicion2 >= 20 || posicion2==posicion1) {
                System.out.println("Posiciones inválidas. No pueden ser la misma y deben estar entre 0 y 19.");
                continue;
            }

            if (visibles[posicion1] || visibles[posicion2]) {
                System.out.println("Una o ambas posiciones ya han sido seleccionadas. Elija nuevamente.");
                continue;
            }

            visibles[posicion1] = true;
            visibles[posicion2] = true;

            if (couples[posicion1].equals(couples[posicion2])) {
                System.out.println("¡Encontraste una pareja!");
            } else {
                System.out.println("Las posiciones seleccionadas no coinciden. ¡Inténtalo de nuevo!");
                visibles[posicion1] = false;
                visibles[posicion2] = false;
                cleanScreen();
            }
        }

        System.out.println("¡Felicidades! Has encontrado todas las parejas.");
    }
    private static boolean allVisibles(boolean[] visibles) {
        for (boolean visible : visibles) {
            if (!visible) {
                return false;
            }
        }
        return true;
    }
    private static void showBoard(boolean[] visibles, String[] parejas) {
        System.out.println("\nParejas encontradas:");
        for (int i = 0; i < visibles.length; i++) {
            if (visibles[i]) {
                System.out.print(parejas[i] + " ");
            } else {
                System.out.print("X ");
            }
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
    private static void cleanScreen() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }
}