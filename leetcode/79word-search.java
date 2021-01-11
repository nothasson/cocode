class Solution {
    public boolean exist(char[][] board, String word) {
        int startx = 0, starty = 0;
        boolean res = false;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (board[i][j] == word.charAt(0)) {
                    startx = i;
                    starty = j;
                    boolean[][] isVisited = new boolean[board.length][board[0].length];
                    res = backtracking(board, word, 0, startx, starty);
                    if (res) return true;
                }
        return false;

    }

    private boolean backtracking(char[][] board, String word, int index, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length
                || word.charAt(index) != board[x][y])
            return false;
        if (index == word.length() - 1) return true;
        char temp = board[x][y];
        board[x][y] = '.';
        boolean res = backtracking(board, word, index + 1, x + 1, y)
                || backtracking(board, word, index + 1, x - 1, y)
                || backtracking(board, word, index + 1, x, y + 1)
                || backtracking(board, word, index + 1, x, y - 1);
        board[x][y] = temp;
        return res;

    }
}