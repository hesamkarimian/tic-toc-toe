import javax.sound.midi.Soundbank;
import java.util.Arrays;

/**
 * @author hesam.karimian
 * @created 23/05/2024
 */
public class Main {
    public static void main(String[] args) {

        char[][] matrix = {
                {'x', 'o', 'x'},
                {'x', 'o', 'o'},
                {'o', 'x', 'x'}};
        printMatrix(matrix, matrix.length);
        System.out.println("The game result is:" + determineWinner(matrix, 3));
    }

    public static void printMatrix(char[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static char determineWinner(char[][] matrix, int n) {
        char winner = matrix[0][0];
        boolean isWin = false;

        char diagonalWinner = matrix[0][0];
        boolean isDiagonalWin = true;

        char reverseDiagonalWinner = matrix[0][n - 1];
        boolean isReverseDiagonalWin = true;

        for (int i = 0; i < n; i++) {
            winner = matrix[i][0];
            isWin = true;
            int j = 0;
            for (; j < n; j++) {

                if (isDiagonalWin && i == j && matrix[i][j] != diagonalWinner) {
                    isDiagonalWin = false;
                }
                if (isReverseDiagonalWin && i + j == n - 1 && matrix[i][j] != reverseDiagonalWinner) {
                    isReverseDiagonalWin = false;
                }
                if (matrix[i][j] != winner) {
                    isWin = false;
                    break;
                }
            }
            if (j == 3 && isWin) {
                break;
            }
        }

        if (isWin) {
            return winner;
        }
        if (isDiagonalWin) {
            System.out.println("it is a diagonal win:");
            return diagonalWinner;
        }
        if (isReverseDiagonalWin) {
            System.out.println("it is a reverse diagonal win:");
            return reverseDiagonalWinner;
        }
        
        for (int j = 0; j < n; j++) {
            winner = matrix[0][j];
            isWin = true;
            int i = 0;
            for (; i < n; i++) {
                if (matrix[i][j] != winner) {
                    isWin = false;
                    break;
                }
            }
            if (isWin && i == 3) {
                break;
            }
        }

        if (isWin) {
            return winner;
        }
        return 'D';
    }
}