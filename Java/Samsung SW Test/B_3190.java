import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
class Snake{
    int row;
    int col;
    int dir;
}
public class B_3190 {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int boardSize = Integer.parseInt(br.readLine());
        int[][] board = new int[boardSize][boardSize];
        for(int i = 0; i < board.length; ++i){
            for (int j = 0; j < board[i].length; ++j){
                board[i][j] = 0;
            }
        }
        int appleCnt = Integer.parseInt(br.readLine());
        for(int i = 0; i < appleCnt; ++i){
            String[] str = br.readLine().split(" ");
            int appleRow = Integer.parseInt(str[0]);
            int appleCol = Integer.parseInt(str[1]);
            board[appleRow - 1][appleCol - 1] = 1;
        }
        int rotateCnt = Integer.parseInt(br.readLine());
        HashMap<Integer, Character> rotateMap = new HashMap<Integer, Character>();
        for(int i = 0; i < rotateCnt; ++i){
            String[] str = br.readLine().split(" ");
            int sec = Integer.parseInt(str[0]);
            char direction = str[1].charAt(0);
            rotateMap.put(sec, direction);
        }


        Snake snake = new Snake();
        snake.row = 0;
        snake.col = 0;
        snake.dir = 0;//0 오른쪽 1 아래쪽 2 왼쪽 3 위쪽
        ArrayList<Integer> snakeQueueRow = new ArrayList<>();
        ArrayList<Integer> snakeQueueCol = new ArrayList<>();

        snakeQueueRow.add(0);
        snakeQueueCol.add(0);// 초기 위치
        int sec = 0;
        while(true){

            nextRowCol(snake);
            if((snake.row < 0) || (snake.row >= boardSize) || (snake.col < 0) || (snake.col >= boardSize)){//벽에 부딪히는 경우
                break;
            }
            boolean flag = true;


            for(int i = 0; i < snakeQueueRow.size(); ++i){
                if(snakeQueueRow.get(i) == snake.row){
                    if(snakeQueueCol.get(i) == snake.col){
                        flag = false;
                        break;
                    }
                }
            }
            if(!flag){
                break;
            }
            if(board[snake.row][snake.col] == 1){
                snakeQueueRow.add(snake.row);
                snakeQueueCol.add(snake.col);
                board[snake.row][snake.col] = 0;
            }
            else{
                snakeQueueRow.add(snake.row);
                snakeQueueCol.add(snake.col);
                snakeQueueRow.remove(0);
                snakeQueueCol.remove(0);
            }
            sec += 1;
            if(rotateMap.get(sec) != null){
                changeDir(snake, rotateMap.get(sec));
            }
        }
        System.out.println(sec + 1);
    }

    public static void nextRowCol(Snake snake){
        switch (snake.dir){
            case 0:
                snake.col += 1;
                break;
            case 1:
                snake.row += 1;
                break;
            case 2:
                snake.col -= 1;
                break;
            case 3:
                snake.row -= 1;
                break;
        }
    }
    public static void changeDir(Snake snake, Character signal){
        switch (signal){
            case 'D':
                snake.dir = (snake.dir + 1) % 4;
                break;
            case 'L':
                if(snake.dir == 0){
                    snake.dir = 3;
                }
                else{
                    snake.dir -= 1;
                }
                break;
        }
    }
}
