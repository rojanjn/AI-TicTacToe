# TicTacToe

A console-based Tic-Tac-Toe game written in Java as a **group project**. Supports both 2-player local matches and a single-player mode against an unbeatable AI powered by the Minimax algorithm.

---

## Features

- **2-Player Mode** – Two human players take turns on the same machine.
- **Play with AI** – Challenge a computer opponent driven by the Minimax algorithm. The AI always plays optimally and cannot be beaten.
- Input validation for names, symbols, and board coordinates.
- Automatic win and tie detection after every move.

---

## Project Structure

```
├── Main.java           # Entry point; displays menu and routes to game modes
├── Game.java           # Core game logic, player setup, and turn management
├── Board.java          # Board state, rendering, move validation, and win checking
├── Player.java         # Player model (name and symbol)
└── MinimaxAI.java      # Minimax algorithm for the AI opponent
```

---

## How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher

### Compile

```bash
javac Main.java Game.java Board.java Player.java MinimaxAI.java
```

### Run

```bash
java Main
```

---

## Gameplay

1. Launch the program and select a game mode:
   ```
   ---------TicTacToe--------------
   Game mode

   1. 2-Player Game
   2. Play with AI
   3. Exit
   ---------------------------------
   ```

2. Enter your name and choose a symbol (`X` or `O`). **X always goes first.**

3. On each turn, enter a row (1–3) and a column (1–3) to place your symbol.

4. The game ends when a player wins or all 9 squares are filled (tie).

### Board Layout

```
  |  |  
---------
  |  |  
---------
  |  |  
```

Rows and columns are numbered 1–3 from top-left to bottom-right.

---

## Win Conditions

A player wins by filling any of the following:
- Any **row**
- Any **column**
- Either **diagonal**

If all 9 squares are filled with no winner, the game ends in a **tie**.

---

## AI — Minimax Algorithm

The AI opponent uses the **Minimax algorithm**, a decision-tree search that evaluates every possible future board state to select the optimal move.

- A score of `+10` is assigned to any state where the AI wins.
- A score of `-10` is assigned to any state where the human wins.
- A score of `0` is assigned to a draw.

The AI maximizes its own score while assuming the human will always try to minimize it. This makes the AI **unbeatable** — the best outcome a human player can achieve is a draw.

---

## Class Overview

### `Board`
Manages the 3×3 character grid.
- `displayBoard()` – Prints the current board state to the console.
- `isValidMove(row, col)` – Checks if a cell is in bounds and unoccupied.
- `makeMove(row, col, symbol)` – Places a symbol on the board.
- `checkWinner()` – Returns `'X'`, `'O'`, or `' '` (no winner yet).
- `isBoardFull()` – Returns `true` when no empty cells remain.

### `Player`
Immutable model storing a player's name and symbol.

### `Game`
Orchestrates game flow: mode selection, player setup, turn loops, and screen clearing for both human and AI modes.

### `MinimaxAI`
Implements the Minimax algorithm.
- `getBestMove()` – Returns the optimal `[row, col]` for the AI's next move.
- `minimax(board, isMaximizing)` – Recursively scores all possible board states.

### `Main`
Entry point. Renders the menu and delegates to the selected game mode.
