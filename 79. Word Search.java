class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0)return false;
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j ++) {
                if(backtrack(board, word, 0, i, j))return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int index, int i, int j) {
        if(word.length() == index)return true;
        if(i < 0 || i >= board.length)return false;
        if(j < 0 || j >= board[0].length)return false;
        if(board[i][j] != word.charAt(index))return false;

        board[i][j] = '*';
        boolean result = backtrack(board, word, index + 1, i + 1, j) ||
                         backtrack(board, word, index + 1, i - 1, j) ||
                         backtrack(board, word, index + 1, i, j + 1) ||
                         backtrack(board, word, index + 1, i, j - 1);
        board[i][j] = word.charAt(index);
        return result;
    }
}
