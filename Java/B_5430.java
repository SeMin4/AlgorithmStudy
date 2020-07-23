import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_5430 {
    static int testCase;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String command = br.readLine();
            int size = Integer.parseInt(br.readLine());
            int[] arr = new int[size];
            String tmp = br.readLine();
            String[] list = tmp.split("\\[");
            list = list[1].split("]");
            boolean flag = false;
            if(list.length == 0){
                for (int j = 0; j < command.length(); j++) {
                    if(command.charAt(j) == 'D'){
                        System.out.println("error");
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    continue;
                }
                else{
                    System.out.println("[]");
                    continue;
                }
            }
            list = list[0].split(",");
            for (int j = 0; j < size; j++) {
                arr[j] = Integer.parseInt(list[j]);
            }
            int start = 0, end = size;
            int pointer = 0;

            for (int j = 0; j < command.length() ; j++) {
                if(command.charAt(j) == 'R'){
                   if(pointer == start){
                       pointer = end;
                   }else{
                       pointer = start;
                   }
                }else{
                    if(end - start == 0){
                        System.out.println("error");
                        flag = true;
                        break;
                    }
                    if(pointer == start){
                        start += 1;
                        pointer += 1;
                    }else{
                        end -= 1;
                        pointer -= 1;
                    }
                }
            }
            if(flag){
                continue;
            }
            if(pointer == start){
                System.out.print("[");
                for (int j = start; j < end; j++) {
                    if(j != end - 1){
                        System.out.print(arr[j] + ",");
                    }
                    else{
                        System.out.print(arr[j]);
                    }

                }
                System.out.println("]");
            }else{
                System.out.print("[");
                for (int j = end - 1; j >= start; j--) {
                    if(j != start){
                        System.out.print(arr[j] + ",");
                    }
                    else{
                        System.out.print(arr[j]);
                    }

                }
                System.out.println("]");
            }

        }
    }
}
