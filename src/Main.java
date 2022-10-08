import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        char[][] board =
        {{'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(board));
    }
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.'){ // it's a number
                        int l = (i + 1 == board.length)? i : i+1;
                        for (int k = (j + 1 == board.length)? j : j+1; k < 9; k++) {
                            if (board[i][j]  == board[i][k] && k != j) {
                                return false;
                            } else if (board[i][j] == board[l][j] && l != i+1) {
                                return false;
                            }
                                l = (l%8) + 1;
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
                        if (board[k][l] != '.'){
                            if (map.isEmpty()){
                                map.put(board[k][l], 1);
                            }else if (map.containsKey(board[k][l])){
                                return false;
                            }else{
                                map.put(board[k][l], 1);
                            }
                        }
                    }
                    System.out.println(map.keySet());
                }

            }
        }return true;
    }
}
