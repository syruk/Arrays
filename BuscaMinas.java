import java.util.*;

public class BuscaMinas {
    private static final int SIZE = 20;
    private static final int MINES = 6;
    private static final char MINE = '*';
    private static final char HIDDEN = '-';

    public static void main(String[] args) {
        char[] visibleBoard = createBoard();
        char[] hiddenBoard = createBoard();
        placeMines(hiddenBoard);
        fillHints(hiddenBoard);
        playGame(visibleBoard, hiddenBoard);
    }

    // Crea un tablero inicial lleno de casillas ocultas
    private static char[] createBoard() {
        char[] board = new char[SIZE];
        Arrays.fill(board, HIDDEN);
        return board;
    }

    // Ubica las minas aleatoriamente en el tablero
    private static void placeMines(char[] board) {
        Random random = new Random();
        int minesPlaced = 0;

        while (minesPlaced < MINES) {
            int index = random.nextInt(SIZE);
            if (board[index] != MINE) {
                board[index] = MINE;
                minesPlaced++;
            }
        }
    }

    // Rellena las casillas vacías con las pistas
    private static void fillHints(char[] board) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i] != MINE) {
                int count = countAdjacentMines(board, i);
                board[i] = (char) (count + '0'); // Convertir número a carácter
            }
        }
    }

    // Cuenta el número de minas adyacentes a una casilla
    private static int countAdjacentMines(char[] board, int index) {
        int count = 0;
        // Posiciones adyacentes: izquierda, derecha, arriba, abajo
        int[] directions = {-1, 1, -5, 5};

        for (int dir : directions) {
            int newIndex = index + dir;
            if (isValidPosition(index, newIndex) && board[newIndex] == MINE) {
                count++;
            }
        }
        return count;
    }

    // Verifica si una posición es válida en el tablero
    private static boolean isValidPosition(int currentIndex, int newIndex) {
        // Verificar si está dentro de los límites y si no se sale del tablero en una fila
        return newIndex >= 0 && newIndex < SIZE && !(currentIndex % 5 == 0 && newIndex % 5 == 4);
    }

    // Muestra el tablero visible al jugador
    private static void displayVisibleBoard(char[] board) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i] == HIDDEN) {
                System.out.print(HIDDEN + " ");
            } else {
                System.out.print(board[i] + " ");
            }
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
    }

    // Juego principal
    private static void playGame(char[] visibleBoard, char[] hiddenBoard) {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;

        while (!gameOver) {
            displayVisibleBoard(visibleBoard);
            System.out.println("Ingrese una posición (0-19):");
            int position = scanner.nextInt();

            if (hiddenBoard[position] == MINE) {
                System.out.println("¡Has perdido! Había una mina en esa posición.");
                gameOver = true;
            } else if (visibleBoard[position] != HIDDEN) {
                System.out.println("Ya has seleccionado esta posición. Elige otra.");
            } else {
                visibleBoard[position] = hiddenBoard[position];
                if (isGameWon(visibleBoard)) {
                    System.out.println("¡Felicidades! Has ganado.");
                    gameOver = true;
                }
            }
        }
        scanner.close();
    }

    // Verifica si todas las casillas sin minas han sido descubiertas
    private static boolean isGameWon(char[] board) {
        for (char cell : board) {
            if (cell == HIDDEN) {
                return false;
            }
        }
        return true;
    }
}
