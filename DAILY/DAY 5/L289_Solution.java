// LeetCode Problem 289. Game of Life

public class L289_Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        // Create a copy of the original board to avoid modifying it while checking neighbors
        int[][] copy = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(board[i], 0, copy[i], 0, cols);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbors = 0;
                for (int[] dir : directions) {
                    int newRow = i + dir[0];
                    int newCol = j + dir[1];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && copy[newRow][newCol] == 1) {
                        liveNeighbors++;
                    }
                }

                // Apply the rules of the game
                if (copy[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = 0; // Cell dies
                } else if (copy[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 1; // Cell becomes alive
                }
            }
        }
    }
    public static void main(String[] args) {
        L289_Solution solution = new L289_Solution();
        int[][] board = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };
        solution.gameOfLife(board);
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
