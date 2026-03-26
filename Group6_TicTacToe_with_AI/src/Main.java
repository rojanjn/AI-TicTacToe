// Member A: [Jui Hsin Wong] ,[101559700]
// Member B: [Cheng Yeh Tsai] ,[101539796]
// Member C: [] ,[1015]
// Member D: [] ,[1015]
// Member E: [] ,[1015]

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Game game = new Game();

        System.out.println(Game.menu());
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
}