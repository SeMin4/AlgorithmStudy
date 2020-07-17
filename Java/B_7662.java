import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class B_7662 {
    static int testCase;
    static int max, min;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int command = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> integerIntegerTreeMap = new TreeMap<>();
            for (int j = 0; j < command; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String comStr = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if(comStr.equals("I")){
                    if(integerIntegerTreeMap.containsKey(num)){
                        integerIntegerTreeMap.put(num, integerIntegerTreeMap.get(num) + 1);
                    }else{
                        integerIntegerTreeMap.put(num, 1);
                    }

                }else if(comStr.equals("D")){
                    if(integerIntegerTreeMap.isEmpty())
                        continue;
                    if(num == 1){
                        int maxValue = integerIntegerTreeMap.lastKey();
                        int cnt = integerIntegerTreeMap.get(maxValue);
                        cnt -= 1;
                        if(cnt == 0){
                            integerIntegerTreeMap.remove(maxValue);
                        }else
                            integerIntegerTreeMap.put(maxValue, cnt);

                    }else if(num == -1){//최소값
                        int minValue = integerIntegerTreeMap.firstKey();
                        int cnt = integerIntegerTreeMap.get(minValue);
                        cnt -= 1;
                        if(cnt == 0){
                            integerIntegerTreeMap.remove(minValue);
                        }else
                            integerIntegerTreeMap.put(minValue, cnt);
                    }
                }

            }
            if(integerIntegerTreeMap.isEmpty()){
                System.out.println("EMPTY");
            }else{
                min = integerIntegerTreeMap.firstKey();
                max = integerIntegerTreeMap.lastKey();
                System.out.println(max + " " + min);
            }


        }
    }
}
