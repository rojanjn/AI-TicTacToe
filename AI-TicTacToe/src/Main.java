public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        System.out.println(menu());

        int gameMode = Game.selectGameMode();

        if (gameMode == 1) {
            game.setupPlayers(gameMode);
            game.humanPlayerMode();

        }else if (gameMode == 2) {
            game.setupPlayers(gameMode);
            game.aiMode();

        }else if (gameMode == 3) {
            System.exit(0);
        }
    }

    public static String menu() {

        return "\n---------TicTacToe--------------\n"
                + "Game mode\n\n"
                + "1. 2-Player Game\n"
                + "2. Play with AI\n"
                + "3. Exit\n"
                + "---------------------------------";
    }
}