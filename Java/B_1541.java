import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B_1541 {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] arr = str.split("-");
        for (int i = 0; i < arr.length; i++) {
            String[] arr2 = arr[i].split("\\+");
            if(arr2.length > 1){
                int sum = 0;
                for (int j = 0; j < arr2.length; j++) {
                    sum += Integer.parseInt(arr2[j]);
                }
                arr[i] = Integer.toString(sum);
            }
        }
        int result = Integer.parseInt(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            result -= Integer.parseInt(arr[i]);
        }
        System.out.println(result);

    }
}
