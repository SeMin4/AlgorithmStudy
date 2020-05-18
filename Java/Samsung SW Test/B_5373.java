
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Cube{
    char[][] up = new char[3][3];
    char[][] down = new char[3][3];
    char[][] front = new char[3][3];
    char[][] back = new char[3][3];
    char[][] left = new char[3][3];
    char[][] right = new char[3][3];
    public Cube(){
        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 3; ++j){
                up[i][j] = 'w';
                down[i][j] = 'y';
                front[i][j] = 'r';
                back[i][j] = 'o';
                left[i][j] = 'g';
                right[i][j] = 'b';
            }
        }
    }
    public void upRotate(char dir){
        if(dir == '+'){//시계방향
            clockWise(up);
            char[] tmp;
            tmp = left[0];
            left[0] = front[0];
            front[0] = right[0];
            right[0] = back[0];
            back[0] = tmp;
        }else{//반시계방향
            counterClockWise(up);
            char[] tmp;
            tmp = left[0];
            left[0] = back[0];
            back[0] = right[0];
            right[0] = front[0];
            front[0] = tmp;
        }
    }
    public void downRotate(char dir){
        if(dir == '+'){//시계방향
            clockWise(down);
            char[] tmp;
            tmp = left[2];
            left[2] = back[2];
            back[2] = right[2];
            right[2] = front[2];
            front[2] = tmp;

        }else{//반시계방향
            counterClockWise(down);
            char[] tmp;
            tmp = left[2];
            left[2] = front[2];
            front[2] = right[2];
            right[2] = back[2];
            back[2] = tmp;
        }
    }
    public void leftRotate(char dir){
        if(dir == '+'){//시계방향
            clockWise(left);
            char tmp0, tmp1, tmp2;
            tmp0 = up[0][0];
            tmp1 = up[1][0];
            tmp2 = up[2][0];
            up[0][0] = back[2][2];
            up[1][0] = back[1][2];
            up[2][0] = back[0][2];
            back[0][2] = down[0][2];
            back[1][2] = down[1][2];
            back[2][2] = down[2][2];
            down[0][2] = front[2][0];
            down[1][2] = front[1][0];
            down[2][2] = front[0][0];
            front[0][0] = tmp0;
            front[1][0] = tmp1;
            front[2][0] = tmp2;
        }else{//반시계방향
            counterClockWise(left);
            char tmp0, tmp1, tmp2;
            tmp0 = up[0][0];
            tmp1 = up[1][0];
            tmp2 = up[2][0];
            up[0][0] = front[0][0];
            up[1][0] = front[1][0];
            up[2][0] = front[2][0];
            front[0][0] = down[2][2];
            front[1][0] = down[1][2];
            front[2][0] = down[0][2];
            down[0][2] = back[0][2];
            down[1][2] = back[1][2];
            down[2][2] = back[2][2];
            back[0][2] = tmp2;
            back[1][2] = tmp1;
            back[2][2] = tmp0;
        }
    }
    public void rightRotate(char dir){
        if(dir == '+'){//시계방향
            clockWise(right);
            char tmp0, tmp1, tmp2;
            tmp0 = up[0][2];
            tmp1 = up[1][2];
            tmp2 = up[2][2];
            up[0][2] = front[0][2];
            up[1][2] = front[1][2];
            up[2][2] = front[2][2];
            front[0][2] = down[2][0];
            front[1][2] = down[1][0];
            front[2][2] = down[0][0];
            down[0][0] = back[0][0];
            down[1][0] = back[1][0];
            down[2][0] = back[2][0];
            back[0][0] = tmp2;
            back[1][0] = tmp1;
            back[2][0] = tmp0;
        }else{//반시계방향
            counterClockWise(right);
            char tmp0, tmp1, tmp2;
            tmp0 = up[0][2];
            tmp1 = up[1][2];
            tmp2 = up[2][2];
            up[0][2] = back[2][0];
            up[1][2] = back[1][0];
            up[2][2] = back[0][0];
            back[0][0] = down[0][0];
            back[1][0] = down[1][0];
            back[2][0] = down[2][0];
            down[0][0] = front[2][2];
            down[1][0] = front[1][2];
            down[2][0] = front[0][2];
            front[0][2] = tmp0;
            front[1][2] = tmp1;
            front[2][2] = tmp2;
        }
    }
    public void frontRotate(char dir){
        if(dir == '+'){//시계방향
            clockWise(front);
            char tmp0, tmp1, tmp2;
            tmp0 = up[2][0];
            tmp1 = up[2][1];
            tmp2 = up[2][2];
            up[2][0] = left[2][2];
            up[2][1] = left[1][2];
            up[2][2] = left[0][2];
            left[0][2] = down[2][2];
            left[1][2] = down[2][1];
            left[2][2] = down[2][0];
            down[2][0] = right[0][0];
            down[2][1] = right[1][0];
            down[2][2] = right[2][0];
            right[0][0] = tmp0;
            right[1][0] = tmp1;
            right[2][0] = tmp2;

        }else{//반시계방향
            counterClockWise(front);
            char tmp0, tmp1, tmp2;
            tmp0 = up[2][0];
            tmp1 = up[2][1];
            tmp2 = up[2][2];
            up[2][0] = right[0][0];
            up[2][1] = right[1][0];
            up[2][2] = right[2][0];
            right[0][0] = down[2][0];
            right[1][0] = down[2][1];
            right[2][0] = down[2][2];
            down[2][0] = left[2][2];
            down[2][1] = left[1][2];
            down[2][2] = left[0][2];
            left[0][2] = tmp2;
            left[1][2] = tmp1;
            left[2][2] = tmp0;
        }
    }
    public void backRotate(char dir){
        if(dir == '+'){//시계방향
            clockWise(back);
            char tmp0, tmp1, tmp2;
            tmp0 = up[0][0];
            tmp1 = up[0][1];
            tmp2 = up[0][2];
            up[0][0] = right[0][2];
            up[0][1] = right[1][2];
            up[0][2] = right[2][2];
            right[0][2] = down[0][0];
            right[1][2] = down[0][1];
            right[2][2] = down[0][2];
            down[0][0] = left[2][0];
            down[0][1] = left[1][0];
            down[0][2] = left[0][0];
            left[0][0] = tmp2;
            left[1][0] = tmp1;
            left[2][0] = tmp0;
        }else{//반시계방향
            counterClockWise(back);
            char tmp0, tmp1, tmp2;
            tmp0 = up[0][0];
            tmp1 = up[0][1];
            tmp2 = up[0][2];
            up[0][0] = left[2][0];
            up[0][1] = left[1][0];
            up[0][2] = left[0][0];
            left[0][0] = down[0][2];
            left[1][0] = down[0][1];
            left[2][0] = down[0][0];
            down[0][0] = right[0][2];
            down[0][1] = right[1][2];
            down[0][2] = right[2][2];
            right[0][2] = tmp0;
            right[1][2] = tmp1;
            right[2][2] = tmp2;
        }
    }
    public void clockWise(char[][] arr){
        char[][] new_arr = new char[3][3];
        for(int i = 0; i < 3; ++i){
            for(int j = 0, col = 2; j < 3 && col >= 0; ++j, --col){
                new_arr[i][j] = arr[col][i];
            }
        }
        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 3; ++j){
                arr[i][j] = new_arr[i][j];
            }
        }
    }
    public void counterClockWise(char[][] arr){
        char[][] new_arr = new char[3][3];
        for(int i = 0, start = 2; i < 3 && start >= 0; ++i, --start){
            for(int j = 0; j < 3; ++j){
                new_arr[i][j] = arr[j][start];
            }
        }
        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 3; ++j){
                arr[i][j] = new_arr[i][j];
            }
        }
    }
}
public class B_5373 {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        char[][][] result = new char[testCase][3][3];
        for(int test = 0; test < testCase; ++test){
            int rotateCnt = Integer.parseInt(br.readLine());
            String[] command = br.readLine().split(" ");
            Cube cube = new Cube();
            for(int i = 0; i < command.length; ++i){
                char face = command[i].charAt(0);
                switch (face){
                    case 'U':
                        if(command[i].charAt(1) == '+'){
                            cube.upRotate('+');
                        }else{
                            cube.upRotate('-');
                        }
                        break;
                    case 'D':
                        if(command[i].charAt(1) == '+'){
                            cube.downRotate('+');
                        }else{
                            cube.downRotate('-');
                        }
                        break;
                    case 'F':
                        if(command[i].charAt(1) == '+'){
                            cube.frontRotate('+');
                        }else{
                            cube.frontRotate('-');
                        }
                        break;
                    case 'B':
                        if(command[i].charAt(1) == '+'){
                            cube.backRotate('+');
                        }else{
                            cube.backRotate('-');
                        }
                        break;
                    case 'L':
                        if(command[i].charAt(1) == '+'){
                            cube.leftRotate('+');
                        }else{
                            cube.leftRotate('-');
                        }
                        break;
                    case 'R':
                        if(command[i].charAt(1) == '+'){
                            cube.rightRotate('+');
                        }else{
                            cube.rightRotate('-');
                        }
                        break;
                }
            }
            for(int j = 0; j < 3; ++j){
                for(int k = 0; k < 3; ++k){
                    result[test][j][k] = cube.up[j][k];
                }
            }
        }
        for(int i = 0; i < testCase; ++i){
            for(int j = 0; j < 3; ++j){
                for(int k = 0; k < 3; ++k){
                    System.out.print(result[i][j][k]);
                }
                System.out.println();
            }
        }

    }
}
