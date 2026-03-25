// Member A: [Jui Hsin Wong] ,[101559700]
// Member B: [Cheng Yeh Tsai] ,[101539796]
// Member C: [] ,[1015]
// Member D: [] ,[1015]
// Member E: [] ,[1015]

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String menu = "\n---------TicTacToe--------------\n"
                + "Game mode\n\n"
                + "1. 2-Player Game\n"
                + "2. Play with AI\n"
                + "3. Exit\n"
                + "-----------------------------------\n"
                + "Enter your choice: ";

        boolean valid = false;

        while (!valid) {
            System.out.println(menu);
            int user_input = input.nextInt();
            input.nextLine();

            switch (user_input) {
                case 1:
                    humanPlayerMode();
                    continue;

                case 2:
                    aiMode();
                    continue;

                case 3:
                    valid = true;
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }



    public static void humanPlayerMode(){
        Scanner input = new Scanner(System.in);

        String playerBSymbol = "";
        String playerASymbol = "";

        boolean valid = false;

        clearScreen();

        System.out.println("\n---------2-Player Mode--------------");
        System.out.print("Player A, Please enter your name: ");
        String playerAName = input.nextLine();


        while(!valid){
            System.out.print(playerAName + ", Please enter your Symbol (X will go first): ");
            playerASymbol = input.nextLine();

            if (playerASymbol.equalsIgnoreCase("o")){
                playerASymbol = "o";
                playerBSymbol = "x";
                valid = true;

            }else if (playerASymbol.equalsIgnoreCase("x")){
                playerASymbol = "x";
                playerBSymbol = "o";
                valid = true;

            }else{
                System.out.println("Invalid choice. Try again.\n");
            }
        }

        System.out.print("Player B, Please enter your name: ");
        String playerBName = input.nextLine();

        System.out.println("\n" + playerAName + ": " +  playerASymbol + "\n" + playerBName + ": " + playerBSymbol + "\n");

        Board board = new Board();

        board.displayBoard();

    }



    public static void aiMode(){
        Scanner input = new Scanner(System.in);

        clearScreen();

        System.out.println("\n---------Play with AI---------------");
    }



    public static void clearScreen() {
        for (int i = 0; i < 15; i++) {
            System.out.println();
        }
    }
}