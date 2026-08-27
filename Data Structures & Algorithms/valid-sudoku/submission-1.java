class Solution {

    public boolean isSafe(char[][] board, int row, int col, int number) {

        // Column
        for (int i = 0; i < board.length; i++) {
            if (i != row && board[i][col] == (char)(number + '0')) {
                return false;
            }
        }

        // Row
        for (int j = 0; j < board.length; j++) {
            if (j != col && board[row][j] == (char)(number + '0')) {
                return false;
            }
        }

        // Grid
        int sr = 3 * (row / 3);
        int sc = 3 * (col / 3);

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {

                if ((i != row || j != col) &&
                    board[i][j] == (char)(number + '0')) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                if (board[row][col] != '.') {

                    int number = board[row][col] - '0';

                    if (!isSafe(board, row, col, number)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
