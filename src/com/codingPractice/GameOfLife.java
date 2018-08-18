package com.codingPractice;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        if (board == null || (board.length == 0 && board[0].length == 0)) return;
        int n = board[0].length, m = board.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int l = lives(board, m, n, i, j);

                if (board[i][j] == 1 && (l < 2 || l > 3)) {
                    board[i][j] = 2;
                } else {
                    if (board[i][j] == 0 && l == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else {
                    if (board[i][j] == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }

    private int lives(int[][] board, int m, int n, int i, int j) {
        int l = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                if (board[x][y] == 1 || board[x][y] == 2) {
                    l++;
                }
            }
        }
        if (board[i][j] == 1 || board[i][j] == 2) l--;
        return l;
    }
}
