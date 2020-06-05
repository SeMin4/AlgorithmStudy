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
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
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
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
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
					if(map[i][j] > maxHeight) {//가장 높은 등산로의 봉우리를 지정
						maxHeight = map[i][j];
					}
				}
			}
			ArrayList<Mountain> mountainArrayList = new ArrayList<>();
			for (int i = 0; i < map.length; i++) {//가장 높은 봉우리를 저장....
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
			if(tmpI >= 0 && tmpI < N && tmpJ >= 0 && tmpJ < N) {//맵안에 있는지 확인
				if(visited[tmpI][tmpJ] == false) {
					if(map[tmpI][tmpJ] < map[mountainI][mountainJ]) {//원래 부터 갈수 있나?
						DFS(flag, tmpI, tmpJ, depth + 1);
						visited[tmpI][tmpJ] = false;
					}
					else {//원래 부터 못가는 경우
						int diff = map[tmpI][tmpJ] - map[mountainI][mountainJ];
						if(diff < K) {//깍아서라도 갈수 있나?
							if(flag) {
								for(int k = diff + 1; k <= K; ++k) {
									map[tmpI][tmpJ] -= k;
									DFS(false, tmpI, tmpJ, depth + 1);
									map[tmpI][tmpJ] += k;
									visited[tmpI][tmpJ] = false;
								}
							}else {//깍아도 못가...
								continue;
							}
						}
						else {
							continue;
						}
						
					}
				}
				else {//이미 방문했던 곳....
					continue;
				}
				
			}
		}
		if(depth > maxLength) {
			maxLength = depth;
		}
		
	}
}