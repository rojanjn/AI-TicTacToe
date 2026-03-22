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
                    System.out.print(" |")
                }
            }
            System.out.println();
            if(i<(board.length-1)){
                System.out.print("---------")
            }
        }
    }
}
