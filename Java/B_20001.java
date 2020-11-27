import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_20001{

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = br.readLine();
        Stack<Integer> stack = new Stack<>();
        while (!(tmp = br.readLine()).equals("고무오리 디버깅 끝")){
            if(tmp.equals("문제")){
                stack.push(1);
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    stack.push(1);
                    stack.push(1);
                }
            }
        }
        if(stack.isEmpty()){
            System.out.println("고무오리야 사랑해");
        }
        else{
            System.out.println("힝구");
        }
    }
}
