import java.util.Arrays;
import java.util.Scanner;
public class RouterHotel {
    public static void main(String[] args) {
        int[] wifiCover = new int[20];
        Scanner scanner = new Scanner(System.in);
        System.out.println("SIMULACION DE COBERTURA WIFI DE UN HOTEL");
        System.out.println("Introduce el número de habitación (1-20):");
        int room = scanner.nextInt();
        if (room < 1 || room > 20) {
            System.out.println("ERROR: Número de habitación inválido. Debe estar entre 1 y 20.");
            return;
        }
        System.out.println("Introduce la potencia de la señal del router (1-6):");
        int wifiSignal = scanner.nextInt();
        if (wifiSignal < 1 || wifiSignal > 6) {
            System.out.println("ERROR: Potencia de transmisión inválida. Debe estar entre 1 y 6.");
            return;
        }
        int left = Math.max(1, room - wifiSignal);
        int right = Math.min(20, room + wifiSignal);

        for (int i = left; i <= right; i++) {
            int distance = Math.abs(room - i);
            wifiCover[i - 1] = wifiSignal - distance;
        }
        System.out.println("Señal de covertura del WiFi:");
        System.out.println(Arrays.toString(wifiCover));

    }
}
