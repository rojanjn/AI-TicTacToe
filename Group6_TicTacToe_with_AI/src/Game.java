// Member A: [Jui Hsin Wong] ,[101559700]
// Member B: [Cheng Yeh Tsai] ,[101539796]
// Member C: [Renan Gutierrez] ,[101573073]
// Member D: [Rojan Jafarnezhad] ,[101561560]
// Member E: [Andrea Salswach Lopez] ,[101580260]

import java.util.Scanner;

public class Game {
    Board board =  new Board();

    private static Scanner input = new Scanner(System.in);
    private Player playerA;
    private Player playerB;

    public static int selectGameMode() {
        while (true) {
            int user_input = 0;

            System.out.print("Select the game mode: ");

            // Check if the next input is a valid integer
            if (input.hasNextInt()) {
                user_input = input.nextInt();
            }

            if (user_input != 1 && user_input != 2 && user_input != 3) {
                System.out.println("Invalid choice. Try again.\n");
                input.nextLine();
            } else {
                return user_input;
            }
        }
    }



    public void setupPlayers(int gameMode){
        clearScreen();

        String playerAName;
        String playerBName;
        char playerASymbol = ' ';
        char playerBSymbol = ' ';

        boolean valid = false;

        if (gameMode == 1) {
            System.out.println("\n---------2-Player Mode--------------");
        } else {
            System.out.println("\n---------Play with AI---------------");
        }
        System.out.print("Player A, Please enter your name: ");
        playerAName = input.next();

        while (!valid) {
            System.out.print(playerAName + ", Please enter your Symbol (X will go first): ");
            playerASymbol = input.next().toUpperCase().charAt(0);

            if (playerASymbol == 'X') {
                playerBSymbol = 'O';
                valid = true;

            } else if (playerASymbol == 'O') {
                playerBSymbol = 'X';
                valid = true;

            } else {
                System.out.println("Invalid choice. Try again.\n");
                input.nextLine();
            }
        }

        if (gameMode == 1){
            System.out.print("Player B, Please enter your name: ");
            playerBName = input.next();
        }else{
            playerBName = "AI";
        }

        playerA = new Player(playerAName, playerASymbol);
        playerB = new Player(playerBName, playerBSymbol);
    }



    public void humanPlayerMode() {
        int round = 1;

        clearScreen();

        System.out.println("-------------Game Start-------------");
        System.out.println(playerA.getPlayerName() + ": " + playerA.getPlayerSymbol());
        System.out.println(playerB.getPlayerName() + ": " + playerB.getPlayerSymbol());

        board.displayBoard();

        while(true){
            Player currentPlayer = getCurrentPlayer(round);
            System.out.println("\n" + currentPlayer.getPlayerName() + " (" + currentPlayer.getPlayerSymbol() + "), What's your move?");

            int row = checkCoordinate("Enter row (1-3): ");
            int column = checkCoordinate("Enter column (1-3): ");

            if (!board.isValidMove(row-1, column-1)) {
                System.out.println("This location has been occupied. Try again.\n");
                continue;
            }

            board.makeMove(row-1, column-1, currentPlayer.getPlayerSymbol());
            board.displayBoard();
            round++;

            char result = board.checkWinner();
            if (result == 'X' || result == 'O') {
                System.out.println("\n-------------Game End-------------");
                System.out.println("The winner goes to " + currentPlayer.getPlayerName());
                break;

            }else if (result == ' ' && board.isBoardFull()) {
                System.out.println("\n-------------Game End-------------");
                System.out.println("This game is a tie");
                break;
            }
        }

    }



    public void aiMode() {
        int round = 1;

        clearScreen();

        System.out.println("\n---------Play with AI---------------");
        System.out.println(playerA.getPlayerName() + ": " + playerA.getPlayerSymbol());
        System.out.println(playerB.getPlayerName() + "  (AI): " + playerB.getPlayerSymbol());

        board.displayBoard();

        // MinMaxAI instance
        MinimaxAI ai = new MinimaxAI(board, playerB.getPlayerSymbol(), playerA.getPlayerSymbol());

        while (true) {
            Player currentPlayer = getCurrentPlayer(round);

            if (currentPlayer == playerA ) {
                // Human Player's turn
                System.out.println("\n" + currentPlayer.getPlayerName() + " (" + currentPlayer.getPlayerSymbol() + "), What's your move?");
                
                int row = checkCoordinate("Enter row (1-3): ");
                int column = checkCoordinate("Enter column (1-3): ");
                
                if (!board.isValidMove(row-1, column-1)) {
                    System.out.println("This location has been occupied. Try again.\n");
                    continue;
                }    
                
                board.makeMove(row-1, column-1, currentPlayer.getPlayerSymbol());

            } else {
                // AI's turn
                System.out.println("\n" + currentPlayer.getPlayerName() + " is thinking...");

                int[] bestMove = ai.getBestMove();
                int row = bestMove[0];
                int column = bestMove[1];

                board.makeMove(row, column, currentPlayer.getPlayerSymbol());
                System.out.println(currentPlayer.getPlayerName() + " chose row " + (row+1) + ", column " + (column+1));
            }

            board.displayBoard();
            round++;

            char result = board.checkWinner();
            if (result == 'X' || result == 'O') {
                System.out.println("\n-------------Game End-------------");
                System.out.println("The winner goes to " + currentPlayer.getPlayerName());

                break;

            } else if (result == ' ' && board.isBoardFull()) {
                System.out.println("\n-------------Game End-------------");
                System.out.println("This game is a tie");
                break;
            }
        }
    }



    public static void clearScreen() {
        for (int i = 0; i < 15; i++) {
            System.out.println();
        }
    }

    private Player getCurrentPlayer(int round) {
        boolean playerAGoesFirst = playerA.getPlayerSymbol() == 'X';
        if (round % 2 == 1) {
            return playerAGoesFirst ? playerA : playerB;
        } else {
            return playerAGoesFirst ? playerB : playerA;
        }
    }

    private int checkCoordinate(String output) {
        while(true) {
            int coordinate;

            System.out.println(output);
            if (input.hasNextInt()) {
                coordinate = input.nextInt();

                if (coordinate >= 1 && coordinate <= 3) {
                    return coordinate;
                }
            }else{
                input.next();
            }

            System.out.println("Invalid input. Try again.\n");
        }

    }
}
