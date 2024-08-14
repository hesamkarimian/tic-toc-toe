import javax.sound.midi.Soundbank;
import java.util.Arrays;

/**
 * @author hesam.karimian
 * @created 23/05/2024
 */
public class Main2 {

    public static void main(String[] args) {
        char[][] matrix = {
                {'o', 'x', 'o'},
                {'x', 'o', 'o'},
                {'o', 'x', 'x'}};

//        char[][] matrix = {
//                {'o', 'x', 'o', 'o', 'x', 'o', 'x', 'o', 'x', 'o'},
//                {'x', 'o', 'x', 'x', 'o', 'o', 'o', 'x', 'o', 'x'},
//                {'o', 'x', 'x', 'o', 'o', 'x', 'x', 'o', 'o', 'x'},
//                {'x', 'o', 'x', 'x', 'o', 'x', 'o', 'o', 'x', 'o'},
//                {'o', 'x', 'o', 'o', 'x', 'o', 'o', 'x', 'x', 'x'},
//                {'x', 'x', 'o', 'x', 'o', 'x', 'x', 'o', 'x', 'o'},
//                {'o', 'x', 'x', 'o', 'o', 'x', 'o', 'x', 'o', 'x'},
//                {'x', 'o', 'o', 'x', 'o', 'o', 'o', 'x', 'o', 'o'},
//                {'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}, // Row with all 'x'
//                {'o', 'o', 'x', 'o', 'x', 'o', 'x', 'o', 'x', 'o'}
//        };

        Main.printMatrix(matrix, matrix.length);
        System.out.println(determineWinner(matrix, matrix.length));
    }

    public static char determineWinner(char[][] matrix, int n) {

        for (int i = 0; i < n; i++) {
            if (isAllSame(getRow(matrix, i))) {
             return matrix[i][0];
            }
            if (isAllSame(getColumn(matrix, i))) {
                return matrix[0][i];
            }
        }
        if (isAllSame(getDiagonal(matrix))) {
            return matrix[0][0];
        }

        if (isAllSame(getAntiDiagonal(matrix))) {
            return matrix[0][matrix.length-1];
        }

        return 'd';
    }

    public static boolean isAllSame(String line) {
        return !line.contains("x") || !line.contains("o");
    }

    public static String getRow(char[][] matrix, int row) {
        return String.valueOf(matrix[row]);
    }

    public static String getColumn(char[][] matrix, int column) {
        StringBuilder columnString = new StringBuilder();
        for (char[] chars : matrix) {
            columnString.append(chars[column]);
        }
        return columnString.toString();
    }

    public static String getDiagonal(char[][] matrix) {
        StringBuilder columnString = new StringBuilder();
        for ( int i=0; i<matrix.length; i++) {
            columnString.append(matrix[i][i]);
        }
        return columnString.toString();
    }

    public static String getAntiDiagonal(char[][] matrix) {
        StringBuilder columnString = new StringBuilder();
        int n = matrix.length;
        for ( int i=0; i<n; i++) {
            columnString.append(matrix[i][n-1-i]);
        }
        return columnString.toString();
    }

}
