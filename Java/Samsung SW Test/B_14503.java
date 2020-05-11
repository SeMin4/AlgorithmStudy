import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Robot{
    int r;
    int c;
    int dir;
    int dirCnt;
    int nextR;
    int nextC;

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getDir() {//0:north 1:East 2:South 3:West
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public int getDirCnt() {
        return dirCnt;
    }

    public void setDirCnt(int dirCnt) {
        this.dirCnt = dirCnt;
    }

    public void setNextDir(){
        if(this.dir == 0){
            setDir(3);
        }
        else{
            setDir(this.dir - 1);
        }
    }

    public void setNextR() {

        switch (getDir()){
            case 0:
                this.nextR = getR();
                if(getDirCnt() == 4){
                    setR(getR() + 1);
                }
                break;
            case 1:
                this.nextR = getR() - 1;
                break;
            case 2:
                this.nextR = getR();
                if(getDirCnt() == 4){
                    setR(getR() - 1);
                }
                break;
            case 3:
                this.nextR = getR() + 1;
                break;
        }
    }
    public int getNextR() {
        return nextR;
    }

    public void setNextC() {
        switch (getDir()){
            case 0:
                this.nextC = getC() - 1;
                break;
            case 1:
                this.nextC = getC();
                if(getDirCnt() == 4){
                    setC(getC() - 1);
                }
                break;
            case 2:
                this.nextC = getC() + 1;
                break;
            case 3:
                this.nextC = getC();
                if(getDirCnt() == 4){
                    setC(getC() + 1);
                }
                break;
        }
    }

    public int getNextC() {
        return nextC;
    }




}
public class B_14503 {
    static int area = 0;
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        str = br.readLine().split(" ");
        Robot robot = new Robot();
        robot.r = Integer.parseInt(str[0]);
        robot.c = Integer.parseInt(str[1]);
        robot.dir = Integer.parseInt(str[2]);
        robot.dirCnt = 0;
        int[][] room = new int[N][M];
        for(int i = 0; i < N; ++i){
            str = br.readLine().split(" ");
            for (int j = 0; j < M; ++j){
                room[i][j] = Integer.parseInt(str[j]);
            }
        }
        clean(robot, room);
        System.out.println(area);
    }

    public static void clean(Robot robot, int[][] room){
        while(true){
            room[robot.getR()][robot.getC()] = 2;//청소
            area += 1;

            while(robot.getDirCnt() < 4){
                robot.setNextR();
                robot.setNextC();
                if(room[robot.getNextR()][robot.getNextC()] == 0){
                    robot.setR(robot.getNextR());
                    robot.setC(robot.getNextC());
                    robot.setNextDir();
                    robot.setDirCnt(0);
                    break;
                }else {
                    robot.dirCnt += 1;
                }
                robot.setNextDir();
                if(robot.getDirCnt() == 4){
                    robot.setNextR();
                    robot.setNextC();
                    if(room[robot.getR()][robot.getC()] == 1){
                        return;
                    }
                    else{
                        robot.setDirCnt(0);
                    }

                }
            }
        }
    }
}