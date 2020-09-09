import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Info implements Comparable<Info>{
    int vertex;
    int length;
    public Info(int vertex, int length){
        this.vertex = vertex;
        this.length = length;
    }

    @Override
    public int compareTo(Info o) {
        if(this.length < o.length)
            return -1;
        else if(this.length == o.length)
            return 0;
        else
            return 1;
    }
}
public class B_5719 {
    static int N, M;
    static int start, end;
    public static void main(String[] args) throws IOException {
        // write your code here
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader("C:\\Users\\SeMin\\Desktop\\contest2_testdata\\testset_2008\\almost.in");
        BufferedReader br = new BufferedReader(fr);
        String tmp;
        while ((tmp = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(tmp);
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N == 0 && M == 0)
                break;
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            int[][] graph = new int[N][N];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int V1 = Integer.parseInt(st.nextToken());
                int V2 = Integer.parseInt(st.nextToken());
                int Weight = Integer.parseInt(st.nextToken());
                graph[V1][V2] = Weight;
            }
            int[] distance = new int[N];
            Queue[] parent = new Queue[N];
            Arrays.fill(distance, Integer.MAX_VALUE);
            for (int i = 0; i < N; i++) {
                parent[i] = new LinkedList<>();
            }
            distance[start] = 0;
            dijkstra(graph ,distance, parent);
            int min = distance[end];
            int result = min;
            //처음부터 없을때 코드 추가 되어야 한다.
            removeEdge(graph, parent, end);
            distance = new int[N];
            parent = new Queue[N];
            Arrays.fill(distance, Integer.MAX_VALUE);
            for (int i = 0; i < N; i++) {
                parent[i] = new LinkedList<>();
            }
            distance[start] = 0;
            dijkstra(graph ,distance, parent);
            result = (distance[end] == Integer.MAX_VALUE) ? -1 : distance[end];
            System.out.println(result);

        }

    }
    public static void dijkstra(int[][] graph, int[] distance, Queue[] parent){
        PriorityQueue<Info> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Info(start, 0));
        while (!priorityQueue.isEmpty()){
            Info info = priorityQueue.poll();
            for (int i = 0; i < N; i++) {
                if(graph[info.vertex][i] != 0){
                    int length = info.length + graph[info.vertex][i];
                    if(length < distance[i]){
                        distance[i] = length;
                        parent[i].clear();
                        parent[i].add(info.vertex);
                        priorityQueue.offer(new Info(i, length));
                    }
                    else if(length == distance[i]){
                        parent[i].offer(info.vertex);
                    }
                }

            }
        }

    }
    public static void removeEdge(int[][] graph, Queue[] parent, int vertex){
        Queue<Integer> vList = new LinkedList<>();
        vList.offer(vertex);
        while (!vList.isEmpty()){
            vertex = vList.poll();
            while (!parent[vertex].isEmpty()){
                int prev = (int) parent[vertex].poll();
                graph[prev][vertex] = 0;
                vList.offer(prev);
            }
        }

    }
}
