/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
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
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		System.setIn(new FileInputStream("res/sample_input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		/*1
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
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
					map[i][j] = Integer.parseInt(st.nextToken());//0은 공백 1은 상하좌우 2는 상하 3 좌우 4 상우 5 하우 6 하좌 7 상좌
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
			if(position.type == 1) {//상하좌우 다 봐야 댄다.
				addQueue(position.i - 1, position.j, visited, posQueue, map, position.time, mapValue[0]);//상1,2,5,6
				addQueue(position.i, position.j + 1, visited, posQueue, map, position.time, mapValue[1]);//우1,3,6,7
				addQueue(position.i + 1, position.j, visited, posQueue, map, position.time, mapValue[2]);//하1,2,4,7
				addQueue(position.i, position.j - 1, visited, posQueue, map, position.time, mapValue[3]);//좌1,3,4,5
			}else if(position.type == 2) {
				addQueue(position.i - 1, position.j, visited, posQueue, map, position.time, mapValue[0]);//상1,2,5,6
				addQueue(position.i + 1, position.j, visited, posQueue, map, position.time, mapValue[2]);//하1,2,4,7
			}else if(position.type == 3) {
				addQueue(position.i, position.j + 1, visited, posQueue, map, position.time, mapValue[1]);//우1,3,6,7
				addQueue(position.i, position.j - 1, visited, posQueue, map, position.time, mapValue[3]);//좌1,3,4,5
			}else if(position.type == 4) {
				addQueue(position.i - 1, position.j, visited, posQueue, map, position.time, mapValue[0]);//상1,2,5,6
				addQueue(position.i, position.j + 1, visited, posQueue, map, position.time, mapValue[1]);//우1,3,6,7
			}else if(position.type == 5) {
				addQueue(position.i, position.j + 1, visited, posQueue, map, position.time, mapValue[1]);//우1,3,6,7
				addQueue(position.i + 1, position.j, visited, posQueue, map, position.time, mapValue[2]);//하1,2,4,7
			}else if(position.type == 6) {
				addQueue(position.i + 1, position.j, visited, posQueue, map, position.time, mapValue[2]);//하1,2,4,7
				addQueue(position.i, position.j - 1, visited, posQueue, map, position.time, mapValue[3]);//좌1,3,4,5
			}else if(position.type == 7) {
				addQueue(position.i - 1, position.j, visited, posQueue, map, position.time, mapValue[0]);//상1,2,5,6
				addQueue(position.i, position.j - 1, visited, posQueue, map, position.time, mapValue[3]);//좌1,3,4,5
			}
		}
		return;
	}
	
	public static void addQueue(int tmpI, int tmpJ, boolean[][] visited, Queue<Position> posQueue, int[][] map, int time, int[] checkValue) {
		if(tmpI >= 0 && tmpI < N && tmpJ >= 0 && tmpJ < M) {//맵안에 있으면서
			if(!visited[tmpI][tmpJ]) {//한번도 방문한적이 없다..
				if(map[tmpI][tmpJ] == checkValue[0] || map[tmpI][tmpJ] == checkValue[1] || map[tmpI][tmpJ] == checkValue[2] || map[tmpI][tmpJ] == checkValue[3]) {
					posQueue.add(new Position(tmpI, tmpJ, map[tmpI][tmpJ], time + 1));
					cnt += 1;//방문한거 개수 늘려주고...
					visited[tmpI][tmpJ] = true;//방문한것으로 만둘고..
				}
			}
		}
	}
}