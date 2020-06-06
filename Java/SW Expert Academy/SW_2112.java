/////////////////////////////////////////////////////////////////////////////////////////////
// �⺻ �����ڵ�� ���� �����ص� ���� �����ϴ�. ��, ����� ���� ����
// �Ʒ� ǥ�� ����� ���� �ʿ�� �����ϼ���.
// ǥ�� �Է� ����
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int ���� 1�� �Է¹޴� ����
// b = sc.nextDouble();                        // double ���� 1�� �Է¹޴� ����
// g = sc.nextByte();                          // char ���� 1�� �Է¹޴� ����
// var = sc.next();                            // ���ڿ� 1�� �Է¹޴� ����
// AB = sc.nextLong();                         // long ���� 1�� �Է¹޴� ����
/////////////////////////////////////////////////////////////////////////////////////////////
// ǥ�� ��� ����
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int ���� 1�� ����ϴ� ����
//System.out.println(b); 		       						 // double ���� 1�� ����ϴ� ����
//System.out.println(g);		       						 // char ���� 1�� ����ϴ� ����
//System.out.println(var);		       				   // ���ڿ� 1�� ����ϴ� ����
//System.out.println(AB);		       				     // long ���� 1�� ����ϴ� ����
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
   ����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
 */
class Solution
{
	static int D, W, K;
	static int[][] flim;
	static int minUpdate = Integer.MAX_VALUE;
	public static void main(String args[]) throws Exception
	{
		/*
		   �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   �������� �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��,
		   �� �ڵ带 ���α׷��� ó�� �κп� �߰��ϸ� ���� �Է��� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�.
		   ���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�.
		   ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
		System.setIn(new FileInputStream("res/sample_input.txt"));

		/*
		   ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		/*
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			minUpdate = D;
			flim = new int[D][W];
			for (int i = 0; i < flim.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < flim[i].length; j++) {
					flim[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if(K == 1) {
				System.out.println("#"+test_case + " " + 0);
			}
			else {
				updateFlim(0, 0);
				System.out.println("#"+test_case + " " + minUpdate);
			}
		}
	}
	
	public static boolean checkValid() {
		for(int j = 0; j < W; ++j) {
			int cnt = 1;
			int prev = flim[0][j];
			for(int i = 1; i < D; ++i) {
				if(prev == flim[i][j]) {
					cnt += 1;
				}else {
					cnt = 1;//ó������ ���� ����..
					prev = flim[i][j];//�޶����� �������� �ٲ���
				}
				if(cnt >= K) {
					break;
				}
			}
			if(cnt < K) {
				return false;
			}
		}
		
		return true;
	}
	public static void updateFlim(int cnt, int currentRow) {
		if(cnt >= minUpdate) {
			return;
		}
		if(currentRow >= D) {
			if(checkValid()) {
				minUpdate = cnt;
			}
			return;
		}
		else {
			int[] prev = new int[W];
			updateFlim(cnt, currentRow + 1);
			for(int j = 0; j <W; ++ j) {
				prev[j] = flim[currentRow][j];
			}
			Arrays.fill(flim[currentRow], 0);//�� �Ѹ���
			updateFlim(cnt + 1, currentRow + 1);
			Arrays.fill(flim[currentRow], 1);//��Ѹ���
			updateFlim(cnt + 1, currentRow + 1);
			for(int j = 0; j <W; ++ j) {
				flim[currentRow][j] = prev[j];
			}
		}
		
		
	}
}