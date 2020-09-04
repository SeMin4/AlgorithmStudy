import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Door{
    int i;
    int j;
    public Door(int i, int j){
        this.i = i;
        this.j = j;
    }
}
public class B_9328 {
    static int N;
    static int H, W;
    static int[] dI = {-1, 0, 1, 0};
    static int[] dJ = {0, 1, 0, -1};
    static int doc = 0;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            doc = 0;
            char[][] map = new char[H + 2][W + 2];
//            for (int j = 0; j < H + 2; j++) {
//                Arrays.fill(map[j], '.');
//            }
            Queue<Door>[] queues = new Queue[26];
            for (int j = 0; j < 26; j++) {
                queues[j] = new LinkedList<>();
            }
            for (int j = 0; j < H + 2; j++) {
                if(j == 0 || j == H + 1){
                    Arrays.fill(map[j], '.');
                    continue;
                }
                String tmp = br.readLine();
                for (int k = 0; k < W + 2; k++) {
                    if(k == 0 || k == W + 1){
                        map[j][k] = '.';
                        continue;
                    }
                    map[j][k] = tmp.charAt(k - 1);
                    if(map[j][k] >= 'A' && map[j][k] <= 'Z'){
                        queues[map[j][k] -'A'].offer(new Door(j, k));
                    }
                }
            }
            String keys = br.readLine();
            boolean[] hasKey = new boolean[26];
            if(keys.charAt(0) !='0'){
                for (int j = 0; j < keys.length(); j++) {
                    int key = keys.charAt(j) - 'a';
                    hasKey[key] = true;
                    while (!queues[key].isEmpty()){
                        Door door = queues[key].poll();
                        map[door.i][door.j] = '.';//먼저 문을 다 따놓자..
                    }
                }
            }
            bfs(map, hasKey, queues);
            System.out.println(doc);

        }
    }
    public static void bfs(char[][] map, boolean[] hasKey , Queue<Door>[] doorsQueue){
        boolean[][] visit = new boolean[H + 2][W + 2];
        Queue<Door> queue = new LinkedList<>();
        queue.offer(new Door(0, 0));
        while (!queue.isEmpty()){
            Door door = queue.poll();
            for (int i = 0; i < 4; i++) {
                int tmpI = door.i + dI[i];
                int tmpJ = door.j + dJ[i];
                if(tmpI >= 0 && tmpI < H + 2 && tmpJ >= 0 && tmpJ < W + 2){
                    if(map[tmpI][tmpJ] =='$' && !visit[tmpI][tmpJ]){//문서를 찾았을때..
                        doc += 1;
                        queue.offer(new Door(tmpI, tmpJ));
                        visit[tmpI][tmpJ] = true;
                    }
                    if(map[tmpI][tmpJ] == '.' && !visit[tmpI][tmpJ]){//일반 길을 만났을때..
                        visit[tmpI][tmpJ] = true;
                        queue.offer(new Door(tmpI, tmpJ));
                    }
                    else if(map[tmpI][tmpJ] >= 'a' && map[tmpI][tmpJ] <= 'z' && !visit[tmpI][tmpJ]){//열쇠를 만났다면...
                        if(!hasKey[map[tmpI][tmpJ] -'a']){//가지고 있지 않던 열쇠라면...
                            hasKey[map[tmpI][tmpJ] -'a'] = true;
                            Queue<Door> doorQueue = doorsQueue[map[tmpI][tmpJ] -'a'];
                            while (!doorQueue.isEmpty()){
                                Door chkDoor = doorQueue.poll();//그 문들을 검사...
                                for (int j = 0; j < 4; j++) {
                                    int doorI = chkDoor.i + dI[j];
                                    int doorJ = chkDoor.j + dJ[j];
                                    if(visit[doorI][doorJ]){//주변을 방문해본적이 있다!.. 그렇다면 그냥 원래 돌고 있는 큐에다가 다시 넣기..
                                        queue.offer(new Door(chkDoor.i, chkDoor.j));
                                        visit[chkDoor.i][chkDoor.j] = true;
                                        map[chkDoor.i][chkDoor.j] = '.';
                                        break;
                                    }
                                    //방문한적이 없다면 그냥 그대로 두기...
                                }
                            }
                        }
                        queue.offer(new Door(tmpI, tmpJ));//가지고 있었던 가지고 있지 않았던 무조건 큐에 넣어주기
                        visit[tmpI][tmpJ] = true;
                    }
                    else if(map[tmpI][tmpJ] >= 'A' && map[tmpI][tmpJ] <= 'Z' && !visit[tmpI][tmpJ]){//방문한곳이 문이라면??...
                        if(hasKey[map[tmpI][tmpJ] - 'A']){//이미 열쇠를 가지고 있는 곳이라면?
                            visit[tmpI][tmpJ] = true;
                            map[tmpI][tmpJ] = '.';
                            queue.offer(new Door(tmpI, tmpJ));
                        }
                    }
                }
            }
        }
    }
}
