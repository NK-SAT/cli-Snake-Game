import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Let's Begin the Game... so Enter the size of the matrix");
        int n = in.nextInt();
        char[][] matrix = new char[n][n];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = '-';
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        boolean enter = true;
        while(enter){

        }

        boolean over = false;
        int moves = 0;

    }
}