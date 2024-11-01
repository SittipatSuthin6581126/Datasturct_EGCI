package NQueens;

public class NQueens {
    private int N;
    private int[][] board;
    private int manualRow = -1;
    private int manualCol = -1;

    public NQueens(int N) {
        this.N = N;
        board = new int[N][N]; // N x N board
    }

    // Display current state
    public void displayBoard() {
        System.out.println("\n      Columns ->");

        // Print column headers
        System.out.print("         ");
        for (int j = 1; j <= N; j++) {
            System.out.printf(" %2d ", j); // Column numbers with fixed width
        }
        System.out.println();

        System.out.print("        ");
        for (int j = 1; j <= N; j++) {
            System.out.print("════");
        }
        System.out.println();



        // Print each row with row number and row border
        for (int i = 0; i < N; i++) {
            System.out.printf("Row %2d ║", (i + 1)); // Row label
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    System.out.print(" ♛  "); // Queen symbol
                } else {
                    System.out.print(" ·  "); // Dot for empty space
                }
            }
            System.out.println("║"); // End of row border
        }

        // Print bottom border
        System.out.print("        ");
        for (int j = 1; j <= N; j++) {
            System.out.print("════");
        }
        System.out.println();

    }

    // Function to place the first queen on the board
    public void placeFirstQueen(int row, int col) {
        board[row][col] = 1;
        manualRow = row;
        manualCol = col;
    }

    // Remove a queen from location
    public void removeQueen(int row, int col) {
        board[row][col] = 0;
    }


    public boolean isSafe(int row, int col) {
        for (int i = 0; i < N; i++) {
            if (board[row][i] == 1 || board[i][col] == 1) {
                return false;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((i + j == row + col || i - j == row - col) && board[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    // Solve the N-Queens problem, skip column of the manually placed queen
    public boolean solvenq(int col) {
        if (col >= N) {
            return true;
        }

        // Skip the manually placed queen's column
        if (col == manualCol) {
            return solvenq(col + 1);
        }

        // Try placing a queen in each row of the current column
        for (int i = 0; i < N; i++) {
            if (isSafe(i, col)) {
                board[i][col] = 1;

                if (solvenq(col + 1)) {
                    return true;
                }

                // Backtrack if placing queen here doesn't lead to a solution
                board[i][col] = 0;
            }
        }

        return false;
    }
}
