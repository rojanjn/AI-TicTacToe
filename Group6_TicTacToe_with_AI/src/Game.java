import java.util.Scanner;

public class Game {
    Board board =  new Board();

    private static Scanner input = new Scanner(System.in);
    private Player playerA;
    private Player playerB;

    public static String menu() {

        return "\n---------TicTacToe--------------\n"
                + "Game mode\n\n"
                + "1. 2-Player Game\n"
                + "2. Play with AI\n"
                + "3. Exit\n"
                + "-----------------------------------";
    }



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

        String playerAName = "";
        String playerBName = "";
        char playerASymbol = ' ';
        char playerBSymbol = ' ';

        boolean valid = false;

        System.out.println("\n---------2-Player Mode--------------");

        System.out.print("Player A, Please enter your name: ");
        playerAName = input.next();

        while (!valid) {
            System.out.print(playerAName + ", Please enter your Symbol (X will go first): ");
            playerASymbol = input.next().toUpperCase().charAt(0);;

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
        String firstPlayer;
        String secondPlayer;
        char firstSymbol;
        char secondSymbol;

        int row = 1;
        int column = 1;
        int round = 1;

        String playerAName = playerA.getPlayerName();
        String playerBName = playerB.getPlayerName();
        char playerASymbol = playerA.getPlayerSymbol();
        char playerBSymbol = playerB.getPlayerSymbol();

        clearScreen();

        System.out.println("-------------Game Start-------------");
        System.out.println(playerAName + ": " + playerASymbol + "\n" + playerBName + ": " + playerBSymbol);

        if  (playerASymbol == 'X') {
            firstPlayer = playerAName;
            secondPlayer = playerBName;
            firstSymbol = playerASymbol;
            secondSymbol = playerBSymbol;

        }else{
            firstPlayer = playerBName;
            secondPlayer = playerAName;
            firstSymbol = playerBSymbol;
            secondSymbol = playerASymbol;
        }

        board.displayBoard();


        while(!board.isBoardFull()){
            char symbol;

            if(round % 2 == 1){
                System.out.println("\n" + firstPlayer + " (" + firstSymbol + ") , What's your move?");
                symbol = firstSymbol;
            }else{
                System.out.println("\n" + secondPlayer + " (" + secondSymbol + ") , What's your move?");
                symbol = secondSymbol;
            }

            while(true) {
                System.out.print("Enter row (1-3): ");
                if (input.hasNextInt()) {
                    row = input.nextInt();

                    if (row >= 1 && row <= 3) break;
                }else{
                    input.next();
                }

                System.out.println("Invalid input. Try again.\n");
            }

            while(true) {
                System.out.print("Enter column (1-3): ");
                if (input.hasNextInt()) {
                    column = input.nextInt();

                    if (column >= 1 && column <= 3) break;
                }else{
                    input.next();
                }
                System.out.println("Invalid input. Try again.\n");
            }

            if (!board.isValidMove(row-1, column-1)) {
                System.out.println("This location has been occupied. Try again.\n");
                continue;
            }

            board.makeMove(row-1, column-1, symbol);
            board.displayBoard();
            round++;
            char result = board.checkWinner();
            if (result == 'X') {
                System.out.println("\n-------------Game End-------------");
                System.out.println("The winner goes to " + firstPlayer);

                break;

            }else if (result == 'O') {
                System.out.println("\n-------------Game End-------------");
                System.out.println("The winner goes to " + secondPlayer);
                break;

            }else if (result == ' ' && board.isBoardFull()) {
                System.out.println("\n-------------Game End-------------");
                System.out.println("This game is tie");
            }
        }

    }



    public void aiMode() {
        clearScreen();

        System.out.println("\n---------Play with AI---------------");
    }



    public static void clearScreen() {
        for (int i = 0; i < 15; i++) {
            System.out.println();
        }
    }

}
