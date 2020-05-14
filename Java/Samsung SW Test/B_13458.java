

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class B_13458 {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] examRoom = new int[N];
        String[] str = br.readLine().split(" ");
        for(int i = 0; i < N; ++i){
            examRoom[i] = Integer.parseInt(str[i]);
        }
        int B, C;
        str = br.readLine().split(" ");
        B = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);
        for(int i = 0; i < N; ++i){
            examRoom[i] -= B;
        }
        BigInteger people = new BigInteger("" + N);
        for(int i = 0; i < N; ++i){
            if(examRoom[i] > 0){
                people = people.add(BigInteger.valueOf((examRoom[i] / C)));
                if(examRoom[i] % C != 0){
                    people = people.add(BigInteger.valueOf(1));
                }
            }

        }
        System.out.println(people);
    }
}
