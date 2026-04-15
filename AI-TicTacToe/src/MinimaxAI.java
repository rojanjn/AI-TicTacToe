public class MinimaxAI {
  private Board board;
  private char aiSymbol;
  private char playerSymbol;

  // initialize board and symbols for AI and human player
  public MinimaxAI(Board b, char ai, char player) {
    board = b;
    aiSymbol = ai;
    playerSymbol = player;
  }

  // find the best move for the AI
  public int[] getBestMove() {
    int bestScore = -1000, bestRow = -1, bestCol = -1;

    // try all possible moves
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        // check if position is empty
        if (board.board[r][c] == ' ') {
          // make the move
          board.board[r][c] = aiSymbol;
          // evaluate this move using minimax (human plays next, so false)
          int score = minimax(board.board, false);
          // undo the move
          board.board[r][c] = ' ';

          // update best move if the score is higher
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

  // Minimax algorithm
  private int minimax(char[][] b, boolean isMaximizing) {
    char winner = board.checkWinner();
    if (winner == aiSymbol)
      return 10; // AI wins
    if (winner == playerSymbol)
      return -10; // Player wins
    if (board.isBoardFull())
      return 0; // Draw

    if (isMaximizing) {
      // AI's turn - trying to maximize score
      int best = -1000;
      for (int r = 0; r < 3; r++) {
        for (int c = 0; c < 3; c++) {
          if (b[r][c] == ' ') {
            b[r][c] = aiSymbol; // make move
            int score = minimax(b, false);  // Recurse
            b[r][c] = ' ';  // undo move
            if (score > best)
              best = score; // keep highest score
          }
        }
      }
      return best;

    } else {
      // player's turn - trying to minimize score

      int best = 1000;
      for (int r = 0; r < 3; r++) {
        for (int c = 0; c < 3; c++) {
          if (b[r][c] == ' ') {
            b[r][c] = playerSymbol; // make move
            int score = minimax(b, true); // recurse
            b[r][c] = ' ';  // undo move
            if (score < best)
              best = score; // keep lowest score
          }
        }
      }
      return best;
    }
  }
}
