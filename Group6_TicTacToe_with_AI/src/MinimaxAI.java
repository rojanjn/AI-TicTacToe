public class MinimaxAI {
  private Board board;
  private char aiSymbol;
  private char playerSymbol;

  public MinimaxAI(Board b, char ai, char player) {
    board = b;
    aiSymbol = ai;
    playerSymbol = player;
  }

  public int[] getBestMove() {
    int bestScore = -1000, bestRow = -1, bestCol = -1;
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        if (board.board[r][c] == ' ') {
          board.board[r][c] = aiSymbol;
          int score = minimax(board.board, false);
          board.board[r][c] = ' ';
          if (score > bestScore) {
            bestScore = score;
            bestRow = r;
            bestCol = c;
          }
        }
      }
    }
    return new int[] { bestRow, bestCol };
  }

  // +10 ai wins, -10 player wins, 0 draw
  private int minimax(char[][] b, boolean isMaximizing) {
    char winner = board.checkWinner();
    if (winner == aiSymbol)
      return 10;
    if (winner == playerSymbol)
      return -10;
    if (board.isBoardFull())
      return 0;

    if (isMaximizing) {
      int best = -1000;
      for (int r = 0; r < 3; r++) {
        for (int c = 0; c < 3; c++) {
          if (b[r][c] == ' ') {
            b[r][c] = aiSymbol;
            int score = minimax(b, false);
            b[r][c] = ' '; // undo
            if (score > best)
              best = score;
          }
        }
      }
      return best;
    } else {
      int best = 1000;
      for (int r = 0; r < 3; r++) {
        for (int c = 0; c < 3; c++) {
          if (b[r][c] == ' ') {
            b[r][c] = playerSymbol;
            int score = minimax(b, true);
            b[r][c] = ' '; // undo
            if (score < best)
              best = score;
          }
        }
      }
      return best;
    }
  }
}
