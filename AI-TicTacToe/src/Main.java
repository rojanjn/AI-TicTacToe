// Member A: [Jui Hsin Wong] ,[101559700]
// Member B: [Cheng Yeh Tsai] ,[101539796]
// Member C: [Renan Gutierrez] ,[101573073]
// Member D: [Rojan Jafarnezhad] ,[101561560]
// Member E: [Andrea Salswach Lopez] ,[101580260]

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