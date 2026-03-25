public class Board {

    public char[][] board;

    public Board() {
        board = new char[3][3];
        
        int i = 0;
        int j = 0;

        for(i=0;i<board.length;i++){
            for(j=0;j<board[i].length;j++){
                board[i][j]=' ';
            }
        }
    }

    public void displayBoard(){
        int i = 0;
        int j = 0;
        for(i=0; i< board.length;i++){

            for(j=0; j< board[i].length;j++){
                System.out.print(board[i][j]);
                if (j < (board[i].length-1)){
                    System.out.print(" |");
                }
            }
            System.out.println();
            if(i<(board.length-1)){
                System.out.println("---------");
            }
        }
    }

// Return 'X','O' or ' '(Tie)
    public  char checkWinner(){
        for (int i = 0; i < board.length; i++){
            if(board[i][0] == board[i][1]
            && board[i][1] == board[i][2]
            && board[i][0] != ' '){
                return board[i][0];
            }
        }
        for (int j = 0; j < board.length; j++){
            if(board[0][j] == board[1][j]
            && board[1][j] == board[2][j]
            && board[0][j] != ' '){
                return board[0][j];
            }
        }
        if(board[0][0] == board[1][1]
        && board[1][1] == board[2][2]
        && board[0][0] != ' ' 
        && board[1][1] != ' ' 
        && board[2][2] != ' ' 
        ){
            return board[1][1];
        }
        if(board[0][2] == board[1][1]
        && board[1][1] == board[2][0]
        && board[0][2] != ' ' 
        && board[1][1] != ' ' 
        && board[2][0] != ' ' 
        ){
            return board[1][1];
        }
        return ' ';

    }
    // Return true = the board is full
    public  boolean isBoardFull(){
        for(int i=0; i<board.length;i++){
            for(int j=0; j<board[i].length;j++){
                if (board[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }

// Return true == move correctly
    public  boolean isValidMove(int row, int column){
        if (row >= 0 && row < board.length && column >= 0 && column < board[0].length){
            if(board[row][column] != ' '){
            return false;
        }
            return true;
        }else
            return false;
    }

}
