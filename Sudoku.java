import java.util.Scanner;

public class Sudoku {

    private static final int SIZE = 9;
    private static final int SUBGRIDSIZE = 3;
    private int[][] board;

    public Sudoku() {
        board = new int[SIZE][SIZE];
        // Initialize with a simple puzzle or add your own initialization here
        initializeBoard();
    }

    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            if (i % SUBGRIDSIZE == 0 && i != 0) {
                System.out.println("- - - - - - - - - - - - - - - - - - - -");
            }
            for (int j = 0; j < SIZE; j++) {
                if (j % SUBGRIDSIZE == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] == 0 ? ". " : board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isValid(int row, int col, int num) {
        for (int x = 0; x < SIZE; x++) {
            if (board[row][x] == num || board[x][col] == num) {
                return false;
            }
        }

        int startRow = row - row % SUBGRIDSIZE;
        int startCol = col - col % SUBGRIDSIZE;
        for (int i = 0; i < SUBGRIDSIZE; i++) {
            for (int j = 0; j < SUBGRIDSIZE; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solve() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= SIZE; num++) {
                        if (isValid(row, col, num)) {
                            board[row][col] = num;
                            if (solve()) {
                                return true;
                            }
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private void initializeBoard() {
        // Initialize with a simple Sudoku puzzle for demonstration
        // Replace with your own puzzle initialization if needed
        board[0][0] = 5; board[0][1] = 3; board[0][4] = 7;
        board[1][0] = 6; board[1][3] = 1; board[1][4] = 9; board[1][5] = 5;
        board[2][1] = 9; board[2][2] = 8; board[2][7] = 6;
        board[3][0] = 8; board[3][4] = 6; board[3][8] = 3;
        board[4][0] = 4; board[4][3] = 8; board[4][5] = 3; board[4][8] = 1;
        board[5][0] = 7; board[5][4] = 2; board[5][8] = 6;
        board[6][1] = 6; board[6][6] = 2; board[6][7] = 8;
        board[7][3] = 4; board[7][4] = 1; board[7][5] = 9; board[7][8] = 5;
        board[8][4] = 8; board[8][7] = 7; board[8][8] = 9;
    }

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            sudoku.printBoard();
            System.out.println("Enter row, column, and number (1-9) separated by spaces, or 'solve' to solve the puzzle:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("solve")) {
                if (sudoku.solve()) {
                    System.out.println("Sudoku solved!");
                } else {
                    System.out.println("No solution exists.");
                }
                continue;
            }

            String[] parts = input.split(" ");
            if (parts.length == 3) {
                try {
                    int row = Integer.parseInt(parts[0]) - 1;
                    int col = Integer.parseInt(parts[1]) - 1;
                    int num = Integer.parseInt(parts[2]);
                    if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && num >= 1 && num <= SIZE) {
                        if (sudoku.isValid(row, col, num)) {
                            sudoku.board[row][col] = num;
                        } else {
                            System.out.println("Invalid move.");
                        }
                    } else {
                        System.out.println("Invalid input.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input format.");
                }
            } else {
                System.out.println("Invalid input format.");
            }
        }
    }
}
