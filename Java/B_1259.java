import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1259{

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        while(Integer.parseInt(str) != 0){
            String compare = "";
            for(int i = str.length() - 1; i >= 0; --i){
                compare += str.charAt(i);
            }
            if(str.equals(compare)){
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }
            str = br.readLine();
        }
    }
}
