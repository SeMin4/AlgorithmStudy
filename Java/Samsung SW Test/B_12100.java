
import java.util.Scanner;

public class B_12100{
    static int maxValue = 0;
    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        int board_size = scanner.nextInt();
        int[][] board = new int[board_size][board_size];
        for(int i = 0; i < board_size; ++i){
            for(int j = 0; j < board_size; ++j){
                board[i][j] = scanner.nextInt();
            }
        }

        maximumValue(board, board_size, 0,0);
        System.out.println(maxValue);
    }

    public static void maximumValue(int[][] board, int board_size, int depth, int dir){
        if(depth >= 5){
            for(int i = 0; i < board_size; ++i){
                for(int j = 0; j < board_size; ++j){
                    if(maxValue < board[i][j]){
                        maxValue = board[i][j];
                    }
                }
            }
            return;
        }
        else{
            while (dir < 4){
                int [][] moveBoard = moveDir(board, dir, board_size);
                maximumValue(moveBoard, board_size, depth + 1, 0);
                dir += 1;

            }
        }
    }

    public static int[][] moveDir(int[][] board, int dir, int size){
        int[][] newBoard = new int[size][size];
        for(int i = 0; i < newBoard.length; ++i){
            for(int j = 0; j < newBoard.length; ++j){
                newBoard[i][j]= board[i][j];
            }
        }
        compressBoard(newBoard, dir);
        switch (dir){
            case 0: {
                for(int i = 1; i < newBoard.length; ++i){
                    for(int j = 0; j < newBoard.length; ++j){
                        if(newBoard[i][j] == newBoard[i - 1][j]){
                            newBoard[i - 1][j] *= 2;
                            newBoard[i][j] = 0;
                        }
                    }
                }
                compressBoard(newBoard, dir);
                break;
            }
            case 1:{
                for(int i = newBoard.length - 2; i >= 0; --i){
                    for(int j = 0; j < newBoard.length; ++j){
                        if(newBoard[i][j] == newBoard[i + 1][j]){
                            newBoard[i + 1][j] *= 2;
                            newBoard[i][j] = 0;
                        }
                    }
                }
                compressBoard(newBoard, dir);
                break;
            }

            case 2:{
                for(int i = 1; i < newBoard.length; ++i){
                    for(int j = 0; j < newBoard.length; ++j){
                        if(newBoard[j][i] == newBoard[j][i - 1]){
                            newBoard[j][i - 1] *= 2;
                            newBoard[j][i] = 0;
                        }
                    }
                }
                compressBoard(newBoard, dir);
                break;
            }
            case 3:{
                for(int i = newBoard.length - 2; i >= 0; --i){
                    for(int j = 0; j < newBoard.length; ++j){
                        if(newBoard[j][i] == newBoard[j][i + 1]){
                            newBoard[j][i + 1] *= 2;
                            newBoard[j][i] = 0;
                        }
                    }
                }
                compressBoard(newBoard, dir);
                break;

            }
            default:
                break;
        }


        return newBoard;
    }
    public static void compressBoard(int[][] board, int dir){
        switch (dir){
            case 0:
                for(int i = 0; i < board.length; ++i){
                    for(int j = 0; j < board.length; ++j){
                        if(board[i][j] == 0){
                            for(int k = i; k < board.length; ++k){
                                if(board[k][j] != 0){
                                    board[i][j] = board[k][j];
                                    board[k][j] = 0;
                                    break;
                                }
                            }
                        }
                    }
                }
                break;
            case 1:
                for(int i = board.length - 1; i >= 0; --i){
                    for(int j = 0; j < board.length; ++j){
                        if(board[i][j] == 0){
                            for(int k = i; k >=0; --k){
                                if(board[k][j] != 0){
                                    board[i][j] = board[k][j];
                                    board[k][j] = 0;
                                    break;
                                }
                            }
                        }
                    }
                }
                break;
            case 2:
                for(int i = 0; i < board.length; ++i){
                    for(int j = 0; j < board.length; ++j){
                        if(board[j][i] == 0){
                            for(int k = i; k < board.length; ++k){
                                if(board[j][k] != 0){
                                    board[j][i] = board[j][k];
                                    board[j][k] = 0;
                                    break;
                                }
                            }
                        }
                    }
                }
                break;
            case 3:
                for(int i = board.length - 1; i >= 0; --i){
                    for(int j = 0; j < board.length; ++j){
                        if(board[j][i] == 0){
                            for(int k = i; k >= 0; --k){
                                if(board[j][k] != 0){
                                    board[j][i] = board[j][k];
                                    board[j][k] = 0;
                                    break;
                                }
                            }
                        }
                    }
                }
                break;

        }
    }
}
