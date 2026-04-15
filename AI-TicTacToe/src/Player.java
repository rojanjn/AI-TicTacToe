public class Player {
    private final String playerName;
    private final char playerSymbol;

    public Player(String playerName, char playerSymbol) {
        this.playerName = playerName;
        this.playerSymbol = playerSymbol;
    }

    public String getPlayerName() {return playerName;}

    public char getPlayerSymbol() {return playerSymbol;}

}
