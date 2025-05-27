public class SudokuSolver {
    public static boolean solve(SudokuBoard sb) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (sb.board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (sb.isValid(row, col, num)) {
                            sb.board[row][col] = num;
                            if (solve(sb)) return true;
                            sb.board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
