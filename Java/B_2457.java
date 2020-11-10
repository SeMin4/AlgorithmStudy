
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Flower implements Comparable<Flower>{
    int startDay;
    int endDay;
    int distance;
    public Flower(int startDay, int endDay){
        this.startDay = startDay;
        this.endDay = endDay;
        this.distance = endDay - startDay;
    }

    @Override
    public int compareTo(Flower o) {
        if(this.startDay < o.startDay) return -1;
        else if(this.startDay == o.startDay){
            if(this.endDay < o.endDay) return -1;
            else if(this.endDay == o.endDay) return 0;
            else return 1;
        }
        else return 1;
    }
}
public class B_2457 {
    static int N;
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList<Flower> flowers = new ArrayList<>();
//        PriorityQueue<Flower> pq = new PriorityQueue();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());
            startDay = getDay(startMonth, startDay);
            endDay = getDay(endMonth, endDay);
            flowers.add(new Flower(startDay, endDay - 1));
        }

        Collections.sort(flowers);
        int princessStart = getDay(3, 0);
        int princessEnd = getDay(11, 30);
        int pick = 0;
//        int startIdx = 0;
        for (int i = 0; i < flowers.size(); i++) {
            Flower flower = flowers.get(i);
            if((flower.startDay <= princessStart || flower.startDay - 1 == princessStart)){
                int maxEndDay = flower.endDay;
                i += 1;
                for (; i < flowers.size(); i++) {
                    if(flowers.get(i).startDay <= princessStart || flowers.get(i).startDay - 1== princessStart){
                        maxEndDay = Math.max(maxEndDay, flowers.get(i).endDay);
                    }
                    else break;
                }
                i -= 1;
                princessStart = maxEndDay;
                pick += 1;
                if(princessStart >= princessEnd)
                    break;
            }
        }
        if (princessStart >= princessEnd){
            System.out.println(pick);
        }
        else System.out.println(0);


    }
    public static int getDay(int Month, int Day){
        int ret = Month * 100;
        ret += Day;
        return ret;
    }
}
