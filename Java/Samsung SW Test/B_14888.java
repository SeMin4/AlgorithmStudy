import javax.lang.model.type.IntersectionType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B_14888 {
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        String[] str = br.readLine().split(" ");
        for(int i = 0; i < N; ++i){
            num[i] = Integer.parseInt(str[i]);
        }
        int[] fourOperator = new int[4];
        str = br.readLine().split(" ");
        for(int i = 0; i < 4; ++i){
            fourOperator[i] = Integer.parseInt(str[i]);
        }


        ArrayList<Integer> operatorInteger = new ArrayList<>();
        overlapCombination(operatorInteger, fourOperator, N, num);
        System.out.println(maxValue);
        System.out.println(minValue);
    }
    public static void overlapCombination(ArrayList<Integer> operatorInteger, int[] fourOperator, int N, int[] num){
        if(operatorInteger.size() == N - 1){
            int result = calculate(num, operatorInteger);
            if(result > maxValue){
                maxValue = result;
            }
            if(result < minValue){
                minValue = result;
            }
        }
        for(int i = 0; i < fourOperator.length; ++i){
            if(fourOperator[i] > 0){
                operatorInteger.add(i);
                fourOperator[i] -= 1;
                overlapCombination(operatorInteger, fourOperator, N, num);
                operatorInteger.remove(operatorInteger.size() - 1);
                fourOperator[i] += 1;
            }

        }
    }
    public static int calculate(int[] num, ArrayList<Integer> operatorInteger){
        int result = num[0];
        for(int i = 1; i < num.length; ++i){
            result = eachCal(result, operatorInteger.get(i - 1), num[i]);
        }
        return result;
    }
    public static int eachCal(int a, int operator, int b){
        switch (operator){
            case 0://+
                a += b;
                break;
            case 1://-
                a -= b;
                break;
            case 2://*
                a *= b;
                break;
            case 3:// /
                if(a < 0){
                    a *= -1;
                    a /= b;
                    a *= -1;
                }else
                    a /= b;
                break;
        }
        return a;
    }
}
