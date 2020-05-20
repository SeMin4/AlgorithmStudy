
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class B_15740{

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        BigInteger big1 = new BigInteger(str[0]);
        BigInteger big2 = new BigInteger(str[1]);
        BigInteger result = big1.add(big2);
        System.out.println(result);
    }
}
