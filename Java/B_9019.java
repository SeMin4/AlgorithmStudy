import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Foo{
    int A;
    String command = "";
    public Foo(int A, String command){
        this.A = A;
        this.command = command;
    }
}
public class B_9019 {
    static int T;
    static int A, B;
    static String result;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        int d1 = 0,  d2 = 0,  d3 = 0, d4 = 0;
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            boolean[] visit = new boolean[10000];
            bfs(A, B, visit);
            bw.write(result);
            bw.write("\n");
        }





        bw.close();

    }
    public static void bfs (int A, int B, boolean[] visit){
        Queue<Foo> queue = new LinkedList<>();
        queue.add(new Foo(A, ""));
        visit[A] = true;
        while (!queue.isEmpty()){
            Foo foo = queue.poll();
            if(foo.A == B){
                result = foo.command;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int tmp_num = 0;
                switch (i){
                    case 0:
                        tmp_num = foo.A;
                        tmp_num *= 2;
                        tmp_num %= 10000;
                        if(!visit[tmp_num]){
                            queue.add(new Foo(tmp_num, foo.command.concat("D")));
                            visit[tmp_num] = true;
                        }

                        break;
                    case 1:
                        tmp_num = foo.A;
                        if(tmp_num == 0)
                            tmp_num = 9999;
                        else
                            tmp_num -= 1;
                        if(!visit[tmp_num]){
                            queue.add(new Foo(tmp_num, foo.command.concat("S")));
                            visit[tmp_num] = true;
                        }
                        break;
                    case 2:
                        tmp_num = foo.A % 1000;
                        tmp_num *= 10;
                        tmp_num += foo.A / 1000;
                        if(!visit[tmp_num]){
                            queue.add(new Foo(tmp_num, foo.command.concat("L")));
                            visit[tmp_num] = true;
                        }
                        break;
                    case 3:
                        tmp_num = foo.A / 10;
                        tmp_num += (foo.A % 10) * 1000;
                        if(!visit[tmp_num]){
                            queue.add(new Foo(tmp_num, foo.command.concat("R")));
                            visit[tmp_num] = true;
                        }
                        break;
                }
            }
        }
    }
}
