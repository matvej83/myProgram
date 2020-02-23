/***
 *This program is a part of home task.
 * Transpose matrix.
 */
public class MatrixTransposing {
    public static void main(String[] args) {
        //matrix transposing
        int Matrix[][] = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {9, 10, 11}
        };
        System.out.println("Matrix transposing" + System.lineSeparator() + "It's initial matrix:");
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {
                System.out.print(Matrix[i][j] + "\t");
            }
            System.out.println();
        }
        //Transposing the matrix
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = i + 1; j < Matrix[0].length; j++) {
                int temp = Matrix[i][j];
                Matrix[i][j] = Matrix[j][i];
                Matrix[j][i] = temp;
            }
        }
        System.out.println("It's transposed matrix:");
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {
                System.out.print(Matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
