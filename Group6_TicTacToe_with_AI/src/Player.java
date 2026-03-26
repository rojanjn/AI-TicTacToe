public class Player {
    private String playerName;
    private char playerSymbol;

    public Player(String playerName, char playerSymbol) {
        this.playerName = playerName;
        this.playerSymbol = playerSymbol;
    }

    public String getPlayerName() {return playerName;}
    public void setPlayerName(String playerName) {this.playerName = playerName;}

    public char getPlayerSymbol() {return playerSymbol;}
    public void setPlayerSymbol(char playerSymbol) {this.playerSymbol = playerSymbol;}

}
