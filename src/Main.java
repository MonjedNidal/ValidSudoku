import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        char[][] board =
        {{'.','2','.','.','.','5','.','.','.'},
        {'.','.','.','.','.','4','.','.','.'},
        {'.','.','.','9','.','.','7','.','.'},
        {'.','.','8','.','.','.','.','.','.'},
        {'.','.','.','.','.','.','.','.','.'},
        {'.','.','.','.','7','4','3','.','9'},
        {'.','.','.','.','.','.','9','.','.'},
        {'.','7','.','.','6','.','.','.','5'},
        {'3','.','.','7','.','.','.','.','.'}};// this isn't valid sudoku because the number 4 in the second row appears another time in the same column.

        System.out.println(isValidSudoku(board));
    }
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {// loop over all rows
            for (int j = 0; j < 9; j++) {// loop over all columns
                if (board[i][j] != '.'){ // it's a number
                    for (int k = (j + 1 == board.length)? j : j+1; k < 9; k++) {// check the columns of the number if there is any duplicate return false
                        if (board[i][j]  == board[i][k] && k != j) {
                                return false;
                        }
                    }
                    for (int k = (i + 1 == board.length)? i : i+1; k < 9; k++) {// check the rows of the number if there is any duplicate return false
                        if (board[i][j]  == board[k][j] && k != i) {
                            return false;
                        }
                    }
                }
            }
        }return isValidSquares(board);
    }
    public static Boolean isValidSquares(char[][] board){
        for (int i = 0; i < 7; i+=3) {
            for (int j = 0; j < 7; j+=3) {
                Map<Character, Integer> map = new HashMap<>();

                for (int k = i; k < i+3; k++) {
                    for (int l = j; l < j+3; l++) {
                        if (board[k][l] != '.'){// check if the char is a number.
                            if (map.isEmpty()){
                                map.put(board[k][l], 1);
                            }else if (map.containsKey(board[k][l])){// here means if the same number saw another time in the same 3 x 3 square return false.
                                return false;
                            }else{
                                map.put(board[k][l], 1); // if the map isn't empty and the number isnt key put it on the map.
                            }
                        }
                    }
                }
            }
        }return true;
    }
}
