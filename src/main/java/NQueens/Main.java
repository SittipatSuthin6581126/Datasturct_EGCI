package NQueens;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;
        boolean keepPlaying = true;

        while (keepPlaying) {
            do {
                System.out.print("Enter number of queens (N must be at least 4): ");
                N = scanner.nextInt();

                if (N < 4) {
                    System.out.println("Invalid input. N must be at least 4. Please try again.");
                }
            } while (N < 4);

            NQueens nQueens = new NQueens(N);
            nQueens.displayBoard();

            System.out.print("Would you like to place the first queen? (Y/N): ");
            String choice = scanner.next().trim().toLowerCase();

            if (choice.equals("y")) {
                System.out.print("Enter the row (1 to " + N + "): ");
                int row = scanner.nextInt() - 1;
                System.out.print("Enter the column (1 to " + N + "): ");
                int col = scanner.nextInt() - 1;
                nQueens.placeFirstQueen(row, col);
            }

            // Solve the problem
            if (nQueens.solvenq(0)) {
                System.out.println("Solution found:");
                nQueens.displayBoard();
            } else {
                System.out.println("No solution exists with the given first queen placement.");
            }


            // Ask if the user wants to try again with a new board size or placement
            System.out.print("Would you like to try again with a new board or queen placement? (Y(yes)/N(no): ");
            String tryAgain = scanner.next().trim();

            if (!tryAgain.equalsIgnoreCase("y")) {
                keepPlaying = false;
            }
        }
        scanner.close();
    }
}
