import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class B_15829 {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        BigInteger bigInteger = new BigInteger("1");
        BigInteger sum = new BigInteger("0");
        BigInteger MOD = new BigInteger("1234567891");
        BigInteger MUL = new BigInteger("31");
        String inputStr = br.readLine();
        for (int i = 0; i < length; i++) {
            int tmpValue = inputStr.charAt(i) - 'a' + 1;
            BigInteger tmp = new BigInteger(""+ tmpValue);
            tmp = tmp.multiply(bigInteger).mod(MOD);
            sum = sum.add(tmp);
            bigInteger = bigInteger.multiply(MUL);
            bigInteger = bigInteger.mod(MOD);
        }
        sum = sum.mod(MOD);

        System.out.println(sum);
    }
}
