import java.util.Random;
import java.util.Scanner;

public class AtrapaLaMosca {
    public static void main(String[] args) {
        int[] arrayFly = new int[15];
        Random rand = new Random();
        int flyPosition = rand.nextInt(15);
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido al juego Atrapa a la Mosca!");
        while (true) {
            System.out.print("Ingresa una posición (entre 1 y 15): ");
            int userPosition = scanner.nextInt();
            if (userPosition < 1 || userPosition > 15) {
                System.out.println("ERROR: ingresa una posición válida entre 1 y 15.");
                continue;
            }
            if (userPosition - 1 == flyPosition) {
                System.out.println("¡Has atrapado a la mosca!");
                break;
            } else if (Math.abs(userPosition - 1 - flyPosition) == 1) {
                flyPosition = rand.nextInt(15);
                System.out.println("Uff! casi... pero la mosca se ha asustado y ha cambiado de posición.");
            } else {
                System.out.println("No has atrapado a la mosca, sigue intentándolo.");
            }
        }
        scanner.close();
    }
}