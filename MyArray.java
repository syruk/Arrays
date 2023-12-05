import java.util.Arrays;
import java.util.Scanner;
public class MyArray {

    public static class miPrimerArray {
        public static void arrayPrint(double[] array) {
            System.out.println(Arrays.toString(array));
        }

        public static double maxArrayElement(double[] array) {
            double biggerValue = array[0];
            for (double v : array)
                if (array[0] > biggerValue) {
                    biggerValue = v;
                }
            return biggerValue;
        }

        public static double minArrayElement(double[] array) {
            double smallerValue = array[0];
            for (double v : array)
                if (array[0] < smallerValue) {
                    smallerValue = v;
                }
            return smallerValue;
        }

        public static double averageElement(double[] array) {
            double total = 0;
            for (double v : array) {
                total += v;
            }
            return total/array.length;
        }

        public static boolean valueExistInArray(double[] array, double number) {
            boolean valueExist = false;
            for (double v : array) {
                if (v == number) {
                    valueExist = true;
                    break;
                }
            }
            return valueExist;
        }

        public static double[] addArray(double[] array, double[] array2) {
            double[] total = new double[array.length];
            for (int i = 0; i < array.length; i++) {
                total[i] = array[i] + array2[i];
            }
            return total;
        }

        public static double[] addArrays(double[] array, double[] array2) {
            int maxLength = Math.max(array.length, array2.length);
            double[] result = new double[maxLength];
            for (int i = 0; i < maxLength; i++) {
                double value1 = (i < array.length) ? array[i] : 0;
                double value2 = (i < array2.length) ? array2[i] : 0;
                result[i] = value1 + value2;
            }
            return result;
        }

        public static double[] subtractArray(double[] array, double[] array2){
            double[] total = new double[array.length];
            for (int i = 0; i < array.length; i++) {
                total[i] = array[i] - array2[i];
            }
            return total;
        }
        public static double[] subtractArrays(double[] array, double[] array2) {
            int maxLength = Math.max(array.length, array2.length);
            double[] result = new double[maxLength];
            for (int i = 0; i < maxLength; i++) {
                double value1 = (i < array.length) ? array[i] : 0;
                double value2 = (i < array2.length) ? array2[i] : 0;
                result[i] = value1 - value2;
            }
            return result;
        }

        public static double scaleProductArrays(double[] array, double[] array2){
            double total = 0;
            if (array.length == array2.length) {
                for (int i = 0; i < array.length; i++) {
                    total += array[i] * array2[i];
                }
            } else System.out.println("ERROR: Las longitudes de los Arrays deben ser iguales!");
            return total;
        }
        public static double[] invertArray(double[] array){
            double[] invertedArray = new double[array.length];
            int n = array.length -1;
            for (double v : array) {
            invertedArray[n] = v;
            n--;
            }
            return invertedArray;
        }

        public static void invertArrayProcedure(double[] array) {
            System.arraycopy(invertArray(array),0 , array, 0,array.length);
        }

        public static boolean isCapicua(double[] array) {
            if (array == null || array.length == 0) {
                return false;
            }
            int start = 0;
            int end = array.length - 1;
            while (start < end) {
                if (array[start] != array[end]) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }

        public static void menu() {
            System.out.println("Escribe el carácter para acceder al ejercicio:");
            System.out.println("a) Un procedimiento que imprime el Array seleccionado.\n" +
                    "b) Una funcion que devuelve el máximo del Array seleccionado.\n" +
                    "c) Una función que devuelve el mínimo del Array seleccionado.\n" +
                    "d) Una función que devuelve la media del Array seleccionado..\n" +
                    "e) Una función que dice si un elemento existe dentro del Array seleccionado o no.\n" + //
                    "f) Una función que suma los Arrays.\n" +
                    "g) Una función que resta los Arrays.\n" +
                    "h) Una función que haga el producto de escalar de los Arrays.\n" +
                    "i) Una función que invierte el orden del Array seleccionado.\n" +
                    "j) Un procedimiento que invierte el orden del Array seleccionado.\n" +
                    "k) Una función que nos indica si el Array seleccionado es capicúa o no.");
        }


    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la longitud del primer Array:");
        int arrayLength = scanner.nextInt();
        double[] array = new double[arrayLength];
        System.out.println("Introduce los elementos del array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        System.out.println("El primer Array es:");
        System.out.println(Arrays.toString(array));
        System.out.println("Introduce la longitud del segundo Array:");
        int arrayLength2 = scanner.nextInt();
        double[] array2 = new double[arrayLength2];
        System.out.println("Introduce los elementos del array:");
        for (int i = 0; i < array2.length; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            array2[i] = scanner.nextInt();
        }
        System.out.println("El segundo Array es:");
        System.out.println(Arrays.toString(array2));

        MyArray.miPrimerArray.menu();
        String option = scanner.next();
        int arrayChoice;
        switch (option) {
            case "a":
                System.out.println("Escoge que Array imprimir, 1 o 2:");
                arrayChoice = scanner.nextInt();
                if (arrayChoice == 1) {
                    miPrimerArray.arrayPrint(array);
                    } else if (arrayChoice == 2) {
                    miPrimerArray.arrayPrint(array2);
                } else System.out.println("ERROR: Escoge un Array válido (1 o 2)");
                break;
            case "b":
                System.out.println("Escoge que Array para saber su elemento máximo, 1 o 2:");
                arrayChoice = scanner.nextInt();
                if (arrayChoice == 1) {
                    System.out.println(miPrimerArray.maxArrayElement(array));
                } else if (arrayChoice == 2) {
                    System.out.println(miPrimerArray.maxArrayElement(array2));
                } else System.out.println("ERROR: Escoge un Array válido (1 o 2)");
                break;
            case "c":
                System.out.println("Escoge que Array para saber su elemento mínimo, 1 o 2:");
                arrayChoice = scanner.nextInt();
                if (arrayChoice == 1) {
                    System.out.println(miPrimerArray.minArrayElement(array));
                } else if (arrayChoice == 2) {
                    System.out.println(miPrimerArray.minArrayElement(array2));
                } else System.out.println("ERROR: Escoge un Array válido (1 o 2)");
                break;
            case "d":
                System.out.println("Escoge que Array para saber la media de sus elementos, 1 o 2:");
                arrayChoice = scanner.nextInt();
                if (arrayChoice == 1) {
                    System.out.println(miPrimerArray.averageElement(array));
                } else if (arrayChoice == 2) {
                    System.out.println(miPrimerArray.averageElement(array2));
                } else System.out.println("ERROR: Escoge un Array válido (1 o 2)");
                break;
            case "e":
                System.out.println("Escoge un Array para saber si un elemento existe en él o no, 1 o 2:");
                arrayChoice = scanner.nextInt();
                double number;
                if (arrayChoice == 1) {
                    System.out.println("Introduce el número que quieres buscar dentro del Array:");
                    number = scanner.nextDouble();
                    System.out.println(miPrimerArray.valueExistInArray(array,number));
                } else if (arrayChoice == 2) {
                    System.out.println("Introduce el número que quieres buscar dentro del Array:");
                    number = scanner.nextDouble();
                    System.out.println(miPrimerArray.valueExistInArray(array2,number));
                } else System.out.println("ERROR: Escoge un Array válido (1 o 2)");
                break;
            case "f":
                System.out.println("La suma de los elementos de los 2 Arrays introducidos es:");
                System.out.println(Arrays.toString(miPrimerArray.addArrays(array, array2)));
                break;
            case "g":
                System.out.println("La resta de los elementos de los 2 Arrays introducidos es:");
                System.out.println(Arrays.toString(miPrimerArray.subtractArrays(array, array2)));
                break;
            case "h":
                System.out.println("El producto escalar de los elementos de los 2 Arrays introducidos es:");
                System.out.println(miPrimerArray.scaleProductArrays(array, array2));
                break;
            case "i":
                System.out.println("Escoge que Array para usar una función que invierte el orden de sus elementos, 1 o 2:");
                arrayChoice = scanner.nextInt();
                if (arrayChoice == 1) {
                    System.out.println(Arrays.toString(miPrimerArray.invertArray(array)));
                } else if (arrayChoice == 2) {
                    System.out.println(Arrays.toString(miPrimerArray.invertArray(array2)));
                } else System.out.println("ERROR: Escoge un Array válido (1 o 2)");
                break;
            case "j":
                System.out.println("Escoge que Array para usar un procedimiento que invierte el orden de sus elementos, 1 o 2:");
                arrayChoice = scanner.nextInt();
                if (arrayChoice == 1) {
                    miPrimerArray.invertArrayProcedure(array);
                } else if (arrayChoice == 2) {
                    miPrimerArray.invertArrayProcedure(array2);
                } else System.out.println("ERROR: Escoge un Array válido (1 o 2)");
                break;
            case "k":
                System.out.println("Escoge de que Array quieres saber si es capicúa, 1 o 2:");
                arrayChoice = scanner.nextInt();
                if (arrayChoice == 1) {
                    System.out.println(miPrimerArray.isCapicua(array));
                } else if (arrayChoice == 2) {
                    System.out.println(miPrimerArray.isCapicua(array2));
                } else System.out.println("ERROR: Escoge un Array válido (1 o 2)");
                break;
            default:
                System.out.println("ERROR: Elige una opción válida.");
                break;
        }
    }
}