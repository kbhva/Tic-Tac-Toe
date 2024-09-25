import java.util.*;

class TictacToe{
    char[][] board;
    public TictacToe(){
         board = new char[3][3];
        initboard();
    }



    void initboard(){
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j < board[i].length;j++){
               board[i][j] = ' ' ;
            }
        }
    }



    void displayboard(){
        System.out.println("-------------");
        for(int i = 0; i < board.length;i++){
            System.out.print("|");
            for(int j = 0; j < board[i].length;j++){
                System.out.print(board[i][j]);
                System.out.print("  |");
            }
            System.out.println(" ");
            System.out.println("-------------");
        }

    }

    boolean isvalid(int row, int column){
        if( (row >= 0 && row <= 2) && (column >=0 && column <= 2) && (board[row][column] == ' ')){
            return true;
        }
        return false;
    }



    void placemark(int row , int column,char input){
        board [row][column] = input;
    }


    boolean winner(int row , int column){
        char player = board[row][column];
            if((board[0][column] == player) && (board[1][column] == player) && (board[2][column] == player)){
                return true;
            }
    
            if((board[row][0] == player) && (board[row][1] == player) && (board[row][2] == player)){
                return true;
            }
            if((board[0][0] == player) && (board[1][1] == player) &&( board[2][2] == player)){
                return true;
            }
            if((board[0][2] == player) && (board[1][1] == player) && (board[2][0] == player)){
                return true;
            }
        
            return false;
    }

}

class LaunchGame{
    public static void main(String[]args){
        TictacToe hey = new TictacToe();
        hey.displayboard();
        int moves = 0;
        Scanner sc = new Scanner(System.in);

        while(true){
            int row = sc.nextInt();
            int column = sc.nextInt();

            if(hey.isvalid(row,column)){
                if(moves % 2 == 0){
                    hey.placemark(row,column,'X');
                    moves++;
                }
                else{
                    hey.placemark(row,column,'O');
                    moves++;
                }
                hey.displayboard();

                if(hey.winner(row,column)){
                    if(moves % 2 == 0){
                        System.out.println("Player 2 has WON !!! Congratulations :)");
                        break;
                    }
                    else{
                        System.out.println("Player 1 has WON !!! Congratulations :)");
                        break;
                    }

                }
                
                if(moves == 9){
                    System.out.println("Alas! It's a draw !");
                    break;
                }


            }
            else{
                System.out.println("Invalid Input");
            }


            
       }

       sc.close();

    }
}