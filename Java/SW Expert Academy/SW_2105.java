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
	static int N;
	static int maxStore = -1;
	static int[] dI = {1, 1, -1, -1};
	static int[] dJ = {1, -1, -1, 1};
	static int[][] map;
	static boolean[] check = new boolean[101];
	static int startPosI, startPosJ;
	public static void main(String args[]) throws Exception
	{
		/*
		   �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   �������� �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��,
		   �� �ڵ带 ���α׷��� ó�� �κп� �߰��ϸ� ���� �Է��� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�.
		   ���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�.
		   ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
		System.setIn(new FileInputStream("res\\sample_input.txt"));

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
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			maxStore = -1;
			for (int i = 0; i < map.length; i++) {
				StringTokenizer  st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < map.length - 1; i++) {
				for (int j = 0; j < map.length - 1; j++) {
					for (int k = 0; k < check.length; k++) {
						check[k] = false;
					}
					check[0] = true;
					check[map[i][j]] = true;
					startPosI = i;
					startPosJ = j;
					DFS(i, j, 1 , 0);
				}
			}
			System.out.println("#"+test_case + " " + maxStore);

		}
	}
	public static void DFS(int startPointI, int startPointJ, int depth, int  currentDir) {
		int tmpI, tmpJ;
		for (int i = currentDir; i <= currentDir + 1 && i < 4; i++) {
			tmpI = startPointI + dI[i];
			tmpJ = startPointJ + dJ[i];
			if(tmpI == startPosI && tmpJ == startPosJ) {
				if(depth > maxStore) {
					maxStore = depth;
					return;
				}
			}
			if(tmpI >= 0 && tmpI < N && tmpJ >= 0 && tmpJ < N) {
				if(check[map[tmpI][tmpJ]] == false) {//�������� �ѹ��� �湮������ ���ٸ�
					check[map[tmpI][tmpJ]] = true;
					DFS(tmpI, tmpJ, depth + 1, i);
					check[map[tmpI][tmpJ]] = false;
				}
			}
		}
	}
}