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
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
   ����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
 */
class Position{
	int i;
	int j;
	int type;
	int time;
	public Position(int i, int j, int type, int time) {
		this.i = i;
		this.j = j;
		this.type = type;
		this.time = time;
	}
}
class SW_1953
{
	static int N, M, L;
	static int[][] mapValue = {{1,2,5,6}, {1,3,6,7},{1,2,4,7},{1,3,4,5}};
	static int cnt = 0;
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
		
		
		/*1
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		*/
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][M];
			boolean[][] visited = new boolean[N][M];
			cnt = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());//0�� ���� 1�� �����¿� 2�� ���� 3 �¿� 4 ��� 5 �Ͽ� 6 ���� 7 ����
				}
			}
			BFS(visited, R, C, map);
			System.out.println("#"+test_case + " " + cnt);
			
		}
	}
	
	public static void BFS(boolean[][] visited, int R, int C, int[][] map) {
		visited[R][C] = true;
		Queue<Position> posQueue = new LinkedList<>();
		posQueue.add(new Position(R, C, map[R][C], 1));
		cnt += 1;
		while(!posQueue.isEmpty()) {
			Position position = posQueue.poll();
			if(position.time == L) {
				break;
			}
			if(position.type == 1) {//�����¿� �� ���� ���.
				addQueue(position.i - 1, position.j, visited, posQueue, map, position.time, mapValue[0]);//��1,2,5,6
				addQueue(position.i, position.j + 1, visited, posQueue, map, position.time, mapValue[1]);//��1,3,6,7
				addQueue(position.i + 1, position.j, visited, posQueue, map, position.time, mapValue[2]);//��1,2,4,7
				addQueue(position.i, position.j - 1, visited, posQueue, map, position.time, mapValue[3]);//��1,3,4,5
			}else if(position.type == 2) {
				addQueue(position.i - 1, position.j, visited, posQueue, map, position.time, mapValue[0]);//��1,2,5,6
				addQueue(position.i + 1, position.j, visited, posQueue, map, position.time, mapValue[2]);//��1,2,4,7
			}else if(position.type == 3) {
				addQueue(position.i, position.j + 1, visited, posQueue, map, position.time, mapValue[1]);//��1,3,6,7
				addQueue(position.i, position.j - 1, visited, posQueue, map, position.time, mapValue[3]);//��1,3,4,5
			}else if(position.type == 4) {
				addQueue(position.i - 1, position.j, visited, posQueue, map, position.time, mapValue[0]);//��1,2,5,6
				addQueue(position.i, position.j + 1, visited, posQueue, map, position.time, mapValue[1]);//��1,3,6,7
			}else if(position.type == 5) {
				addQueue(position.i, position.j + 1, visited, posQueue, map, position.time, mapValue[1]);//��1,3,6,7
				addQueue(position.i + 1, position.j, visited, posQueue, map, position.time, mapValue[2]);//��1,2,4,7
			}else if(position.type == 6) {
				addQueue(position.i + 1, position.j, visited, posQueue, map, position.time, mapValue[2]);//��1,2,4,7
				addQueue(position.i, position.j - 1, visited, posQueue, map, position.time, mapValue[3]);//��1,3,4,5
			}else if(position.type == 7) {
				addQueue(position.i - 1, position.j, visited, posQueue, map, position.time, mapValue[0]);//��1,2,5,6
				addQueue(position.i, position.j - 1, visited, posQueue, map, position.time, mapValue[3]);//��1,3,4,5
			}
		}
		return;
	}
	
	public static void addQueue(int tmpI, int tmpJ, boolean[][] visited, Queue<Position> posQueue, int[][] map, int time, int[] checkValue) {
		if(tmpI >= 0 && tmpI < N && tmpJ >= 0 && tmpJ < M) {//�ʾȿ� �����鼭
			if(!visited[tmpI][tmpJ]) {//�ѹ��� �湮������ ����..
				if(map[tmpI][tmpJ] == checkValue[0] || map[tmpI][tmpJ] == checkValue[1] || map[tmpI][tmpJ] == checkValue[2] || map[tmpI][tmpJ] == checkValue[3]) {
					posQueue.add(new Position(tmpI, tmpJ, map[tmpI][tmpJ], time + 1));
					cnt += 1;//�湮�Ѱ� ���� �÷��ְ�...
					visited[tmpI][tmpJ] = true;//�湮�Ѱ����� ���Ѱ�..
				}
			}
		}
	}
}