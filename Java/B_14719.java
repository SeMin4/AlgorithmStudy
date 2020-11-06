import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Block implements Comparable<Block>{
    int progress;
    int idx;
    public Block(int progress, int idx){
        this.progress = progress;
        this.idx = idx;
    }
    @Override
    public int compareTo(Block o) {
        if(this.progress > o.progress){
            return -1;
        }
        else if(this.progress == o.progress){
            return 0;
        }
        else return 1;
    }
}
public class B_14719 {
    static int W, H;
    public static void main(String[] args) throws IOException {
        // write your code here
//        2
//        6
//        6 2 11 0 3 5
//        6 3 0 9 0 5

//        3
//        10
//        6 12 0 2 8 4 0 7 3 6
//        6 1 3 0 2 8 0 0 13 8
//        6 3 0 10 6 5 7 0 0 3
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] blocks = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < blocks.length; i++) {

            blocks[i] = Integer.parseInt(st.nextToken());
        }
        solution(W,blocks);
    }
    private static void solution(int width, int[] blocks) {
        // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
        int cnt = 0;
        int[] progress = new int[width];
        PriorityQueue<Block> pq = new PriorityQueue<>();
        for (int j = 0; j < width; j++) {
            progress[j] += blocks[j];
            pq.offer(new Block(progress[j], j));
        }
        Block maxBlock = pq.poll();
        int leftPointer = maxBlock.idx;
        int rightPointer = maxBlock.idx;
        while (!pq.isEmpty()){
            Block block = pq.poll();
            if(leftPointer <= block.idx && rightPointer >= block.idx){
                continue;
            }
            else if(leftPointer > block.idx){
                for (int j = block.idx + 1; j < leftPointer; j++) {
                    cnt += (block.progress - progress[j]);
                    progress[j] = block.progress;
                }
                leftPointer = block.idx;
            }
            else {
                for(int j = block.idx - 1; j > rightPointer; j--){
                    cnt += (block.progress - progress[j]);
                    progress[j] = block.progress;
                }
                rightPointer = block.idx;
            }
        }
        System.out.println(cnt);
    }

}
