public class SudokuBoard {
    public int[][] board = new int[9][9];

    public boolean isValid(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num ||
                board[(row/3)*3 + i/3][(col/3)*3 + i%3] == num)
                return false;
        }
        return true;
    }
}
