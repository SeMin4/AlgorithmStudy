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
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
   ����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
 */
class Mountain{
	int i;
	int j;
	public Mountain(int i, int j) {
		this.i = i;
		this.j = j;
	}
}
class SW_1949
{
	static int N, K;
	static int[] dI = {-1, 0, 1, 0};
	static int[] dJ = {0, 1, 0, -1};
	static int[][] map;
	static boolean[][] visited;
	static int maxLength = Integer.MIN_VALUE;
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
//			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//			String tmp = br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			maxLength = Integer.MIN_VALUE;
			map = new int[N][N];
			int maxHeight = Integer.MIN_VALUE;
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] > maxHeight) {//���� ���� ������ ���츮�� ����
						maxHeight = map[i][j];
					}
				}
			}
			ArrayList<Mountain> mountainArrayList = new ArrayList<>();
			for (int i = 0; i < map.length; i++) {//���� ���� ���츮�� ����....
				for (int j = 0; j < map.length; j++) {
					if(map[i][j] == maxHeight) {
						mountainArrayList.add(new Mountain(i, j));
					}
				}
			}
			boolean flag = true;
			visited = new boolean[N][N];
			for (Mountain mountain : mountainArrayList) {
				for (int i = 0; i < visited.length; i++) {
					for (int j = 0; j < visited.length; j++) {
						visited[i][j] = false;
					}
				}
				flag = true;
				DFS(flag, mountain.i , mountain.j , 1);
			}
			System.out.println("#" + test_case + " " + maxLength);
			
		}
	}
	
	public static void DFS(boolean flag, int mountainI, int mountainJ, int depth) {
		visited[mountainI][mountainJ] = true;
		for (int i = 0; i < 4; i++) {
			int tmpI = mountainI + dI[i];
			int tmpJ = mountainJ + dJ[i];
			if(tmpI >= 0 && tmpI < N && tmpJ >= 0 && tmpJ < N) {//�ʾȿ� �ִ��� Ȯ��
				if(visited[tmpI][tmpJ] == false) {
					if(map[tmpI][tmpJ] < map[mountainI][mountainJ]) {//���� ���� ���� �ֳ�?
						DFS(flag, tmpI, tmpJ, depth + 1);
						visited[tmpI][tmpJ] = false;
					}
					else {//���� ���� ������ ���
						int diff = map[tmpI][tmpJ] - map[mountainI][mountainJ];
						if(diff < K) {//��Ƽ��� ���� �ֳ�?
							if(flag) {
								for(int k = diff + 1; k <= K; ++k) {
									map[tmpI][tmpJ] -= k;
									DFS(false, tmpI, tmpJ, depth + 1);
									map[tmpI][tmpJ] += k;
									visited[tmpI][tmpJ] = false;
								}
							}else {//��Ƶ� ����...
								continue;
							}
						}
						else {
							continue;
						}
						
					}
				}
				else {//�̹� �湮�ߴ� ��....
					continue;
				}
				
			}
		}
		if(depth > maxLength) {
			maxLength = depth;
		}
		
	}
}