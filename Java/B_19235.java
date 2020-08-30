
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class B_19235 {
    static int[][] redMap = new int[4][4];

    static int[] dI = {0, -1, 0};
    static int[] dJ = {-1, 0, 1};
    static int N;
    static int Score = 0;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //t == 1 (1 x 1)
        //t == 2 (1 x 2 [x, y] [x, y + 1])
        //t == 3 (2 x 1 [x, y] [x + 1, y])
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] blueMap = new int[6][4];
        int[][] greenMap = new int[6][4];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int di = Integer.parseInt(st.nextToken());
            int dj = Integer.parseInt(st.nextToken());
            insertToMap(greenMap, type, dj, i);
            if(type == 2)
                insertToMap(blueMap, 3, di, i);
            else if(type == 3)
                insertToMap(blueMap, 2, di, i);
            else
                insertToMap(blueMap, 1, di, i);

//            System.out.println(i  + "회차!!!!!!!!!!!!!!!!!!!!! 블루맵");
//            printMap(blueMap);
//            System.out.println(i  + "회차!!!!!!!!!!!!!!!!!!!!! 그린맵");
//            printMap(greenMap);
//            System.out.println();
        }
        int greenCnt = 0;
        int blueCnt = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if(greenMap[i][j] != 0)
                    greenCnt += 1;
                if(blueMap[i][j] != 0)
                    blueCnt += 1;
            }
        }
        System.out.println(Score);
        System.out.println(greenCnt + blueCnt);
    }
    public static void insertToMap(int[][] map, int type, int dj, int blockNum){
        for (int i = 5; i >= 0 ; i--) {//밑에서 부터 서칭하면서 빈칸 찾기...
            if(type == 2 && map[i][dj] == 0 && map[i][dj + 1] == 0){
                if(UpAnythingBlock(map, i, dj, type)){
                    map[i][dj] = map[i][dj + 1] = blockNum;
                    break;
                }

            }
            else if(type == 3 && map[i][dj] == 0 && map[i - 1][dj] == 0){
                if(UpAnythingBlock(map, i, dj, type)) {
                    map[i][dj] = map[i - 1][dj] = blockNum;
                    break;
                }
            }
            else if(type == 1 && map[i][dj] == 0){
                if(UpAnythingBlock(map, i, dj, type)){
                    map[i][dj] = blockNum;
                    break;
                }
            }
        }
        deleteLine(map);
    }
    public static boolean UpAnythingBlock(int[][] map, int i, int j, int type){
        for (int k = i; k >= 0 ; k--) {
            if(type == 2 && (map[k][j] != 0 || map[k][j + 1] != 0))
                return false;
            else if(type == 3 && k > 0 && (map[k][j] != 0 || map[k - 1][j] != 0))
                return false;
            else if(type == 1 && map[k][j] != 0)
                return false;
        }
        return true;
    }
    public static void deleteLine(int[][] map){//꽉찬거 지우기
        boolean flag = false;
        for (int i = 5; i >= 0 ; i--) {
            if(checkLine(map, i)){//다 찼는가.?
                flag = true;
                for (int j = i; j >= 1; j--) {
                    map[j][0] = map[j - 1][0];
                    map[j][1] = map[j - 1][1];
                    map[j][2] = map[j - 1][2];
                    map[j][3] = map[j - 1][3];
                }
                map[0][0] = map[0][1] = map[0][2] = map[0][3] = 0;
                Score += 1;
                i += 1;
            }
        }
        if(flag){
            moveToDown(map);//지워진적이 있다면?
            deleteLine(map);
        }
        int lineCnt = 0;
        for (int j = 0; j < 4; j++) {
            if(map[1][j] != 0) {
                lineCnt += 1;
                break;
            }
        }
        for (int j = 0; j < 4; ++j){
            if(map[0][j] != 0){
                lineCnt += 1;
                break;
            }
        }
        if(lineCnt != 0)
            UnderLineMapDelete(map, lineCnt);

    }
    public static boolean checkLine(int[][] map, int i){//다 찼는가?
        return map[i][0] != 0 && map[i][1] != 0 && map[i][2] != 0 && map[i][3] != 0;
    }
    public static void moveToDown(int[][] map){//아래로 떨어 뜨리기
        for(int i = 4; i>=1 ; i--){
            for (int j = 0; j < 4; j++) {
                if(map[i][j] != 0 && map[i + 1][j] == 0){
                    int blockNumber = map[i][j];
                    boolean flag = false;
                    for (int k = 0; k < 3; k++) {
                        int tmpI = i + dI[k];
                        int tmpJ = j + dJ[k];
                        if(tmpI >= 0 && tmpI < 6 && tmpJ >= 0 && tmpJ < 4){
                            if(map[tmpI][tmpJ] == blockNumber && k == 1){//다른 타입의 블록에 의해서 지워진적이 있다면? 1 자 블록
                                map[i + 1][j] = blockNumber;
                                map[tmpI][tmpJ] = 0;
                                flag = true;
                                break;
                            }
                            else if(map[tmpI][tmpJ] == blockNumber){//ㅡ자 블록
                                if(map[tmpI + 1][tmpJ] == 0){
                                    map[i + 1][j] = map[i][j];
                                    map[tmpI + 1][tmpJ] = map[tmpI][tmpJ];
                                    map[i][j] = map[tmpI][tmpJ] = 0;
                                }
                                flag = true;
                                break;
                            }
                        }
                    }
                    if(!flag){
                        int k;
                        for (k = i + 1; k < 6; k++) {
                            if(map[k][j] != 0)
                                break;
                        }
                        map[k - 1][j] = map[i][j];
                        map[i][j]  = 0;
                    }
                }
            }
        }
    }
    public static void UnderLineMapDelete(int[][] map, int lineCnt){
        for (int i = 5 - lineCnt; i >= 0 ; i--) {
            map[i + lineCnt][0] = map[i][0];
            map[i + lineCnt][1] = map[i][1];
            map[i + lineCnt][2] = map[i][2];
            map[i + lineCnt][3] = map[i][3];
        }
        for (int i = 0; i < lineCnt; i++) {
            map[i][0] = map[i][1] = map[i][2] = map[i][3] = 0;
        }
    }
    public static void printMap(int[][] map){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }



}
