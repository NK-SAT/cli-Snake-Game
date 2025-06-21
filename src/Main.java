import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Snake> snakes = new ArrayList<>();
        int moves = 0;
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
            System.out.println("\nPress 1 if you want to add Fruit \nPress 2 to start the gamee...");
            int chosen = in.nextInt();
            switch (chosen){
                case 1:
                    System.out.println("Enter the Index to give fruitss...");
                    moves++;
                    int curri = in.nextInt();
                    int currj = in.nextInt();
                    if(curri>n-1 || curri <0 || currj>n-1 ||currj<0){
                        System.out.println("Its out of the game. Give a valid index, yaar!!");
                        break;
                    }
                    matrix[curri][currj]='F';
                    break;
                case 2:
                    enter = false;
                    break;
                default:
                    System.out.println("You have entered a invalid input enter a proper one.");
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
        System.out.println("Where you want to start with the snake???");
        int curri = in.nextInt();
        int currj = in.nextInt();
        matrix[curri][currj] = '*';
        boolean over = false;

    }
}