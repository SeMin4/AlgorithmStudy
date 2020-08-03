import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class P_동굴탐험 {
    static HashMap<Integer, Integer> pointList = new HashMap<>();
    static int cnt = 0;
    static int N;
    static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    static HashMap<Integer, Integer> priority = new HashMap<>();
    public static void main(String[] args) {
	// write your code here
        int n = 9;
        int[][] path = {{0,1},{0,3},{0,7},{8,1 },{3,6},{1,2},{4,7},{7,5}};
        int[][] order = {{8,5},{6,7},{4,1}};
        boolean result = solution(n, path, order);
        System.out.println(result);
    }
    public static boolean solution(int n, int[][] path, int[][] order) {
        N = n;
        for (int i = 0; i < path.length; i++) {//grpah 나타내기
            if(graph.get(path[i][0]) != null){
                graph.get(path[i][0]).add(path[i][1]);
            }
            else{
                graph.put(path[i][0], new ArrayList<>(Arrays.asList(path[i][1])));
            }
            if(graph.get(path[i][1]) != null){
                graph.get(path[i][1]).add(path[i][0]);
            }
            else{
                graph.put(path[i][1], new ArrayList<>(Arrays.asList(path[i][0])));
            }
        }
        for (int i = 0; i < order.length; i++) {
            priority.put(order[i][1], order[i][0]);
        }
        if(priority.get(0) != null){//0번보다 우선순위가 있으면 바로 나감...
            return false;
        }
        boolean[] visit = new boolean[n];
        try{
            dfs(visit, 0);
        }catch (Error e){
            return true;
        }
        if(cnt == N)
            return true;
        else
            return false;
    }
    public static void dfs(boolean[] visit, int vertex) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(vertex);
        while (!stack.isEmpty()){
            vertex = stack.pop();
            visit[vertex] = true;
            cnt += 1;
            if(pointList.get(vertex) != null){
                int p = pointList.get(vertex);
                pointList.remove(vertex);
                stack.push(p);
            }
            ArrayList<Integer> list = graph.get(vertex);
            for (int i = 0; i < list.size(); i++) {
                int point = list.get(i);
                Integer priority_num = priority.get(point);
                if(priority_num != null && !visit[priority_num]){
                    pointList.put(priority_num, point);
                }
                else if(!visit[point]){
                    stack.push(point);
                }
            }
        }

    }
}
