import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Snake> snakeBody = new LinkedList<>();

        System.out.println("Enter matrix size:");
        int n = in.nextInt();
        int count = 0;
        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], '-');
        }

        boolean enter = true;
        while (enter) {
            System.out.println("\n1: Add Fruit\n2: Start Game");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter fruit position (i j):");
                    int fi = in.nextInt(), fj = in.nextInt();
                    if (fi < 0 || fj < 0 || fi >= n || fj >= n) {
                        System.out.println("Invalid index");
                    } else {
                        matrix[fi][fj] = 'F';
                        count++;
                    }
                    break;
                case 2:
                    enter = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }

            printMatrix(matrix);
        }

        System.out.println("Enter Snake start position (i j):");
        int si = in.nextInt(), sj = in.nextInt();
        matrix[si][sj] = '*';
        snakeBody.add(new Snake(si, sj));
        printMatrix(matrix);
        boolean gameOver = false;
        while (!gameOver) {
            System.out.println("\nMove: U / D / L / R");
            char dir = in.next().toUpperCase().charAt(0);

            int ni = si, nj = sj;
            switch (dir) {
                case 'U': ni--; break;
                case 'D': ni++; break;
                case 'L': nj--; break;
                case 'R': nj++; break;
                default:
                    System.out.println("Invalid direction"); continue;
            }

            if (ni < 0 || nj < 0 || ni >= n || nj >= n || matrix[ni][nj] == '*') {
                System.out.println("Game Over!");
                break;
            }

            if (matrix[ni][nj] == 'F') {
                count--;
                snakeBody.add(new Snake(ni, nj));
            } else {
                Snake tail = snakeBody.poll();
                matrix[tail.getIndexi()][tail.getIndexj()] = '-';
                snakeBody.add(new Snake(ni, nj));
            }

            matrix[ni][nj] = '*';
            si = ni;
            sj = nj;

            printMatrix(matrix);
            if(count == 0){
                System.out.println("You won the Game!!!");
                gameOver = true;
            }
        }
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char cell : row) System.out.print(cell + " ");
            System.out.println();
        }
    }
}