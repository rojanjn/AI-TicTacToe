/**
 * THis class implements the minmax algorithm for creating an unbeatable AI opponent
 * The algorithm recursively evaluates all possible game states to find the optimal move
 */

public class MinimaxAI {
  private Board board;
  private char aiSymbol;
  private char playerSymbol;

  /**
   * Constructors - Initialize the AI with board reference and player symbols
   * @param b - Reference to the game board
   * @param ai - Symbol used by the AI ('X' or 'O')
   * @param player - Symbol used by the human player
   */
  public MinimaxAI(Board b, char ai, char player) {
    board = b;
    aiSymbol = ai;
    playerSymbol = player;
  }

  /**
   * Find the best possible move using Minmax algorithms
   * 
   * Algorithm:
   * 1. Try every empty position on the board
   * 2. For each position, simulate placing AI symbol
   * 3. Recursively evaluate the resulting game state
   * 4. Undo the move (backtrack)
   * 5. Choose the move with the highest score
   * 
   * 
   * @return int array [row, column] representing the best move
   */
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
          // undo the move (backtracking)
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

  /**
   * Minimax recursive algorithm to evaluate board positions
   * 
   * Scoring:
   * +10 = AI wins (good for AI)
   * -10 = AI loses, Player wins (bad for AI)
   * 0 = Draw
   * 
   * @param b - current board state
   * @param isMaximizing - true if AI's turn (maximize score), false if player's turn (minimize score)
   * @return score of the current board position
   */
  private int minimax(char[][] b, boolean isMaximizing) {
    char winner = board.checkWinner();
    if (winner == aiSymbol)
      return 10; // AI wins - return positive score
    if (winner == playerSymbol)
      return -10; // Player wins - return negative score
    if (board.isBoardFull())
      return 0; // Draw - return neutral score

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
      // player's turn - trying to minimize score (assumes optimal play)

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
