import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_2630(2) {
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] res = paperCnt(paper, N, 0, 0);
		System.out.println(res[0]);
		System.out.println(res[1]);
	}
	public static int[] paperCnt(int[][] paper, int N, int startI, int startJ) {
		int[] ret = new int[2];
		int paperkinds = paper[startI][startJ];
		for (int i = startI; i < startI + N; i++) {
			for (int j = startJ; j < startJ + N; j++) {
				if(paperkinds != paper[i][j]) {
					int[] cnt = paperCnt(paper, N / 2, startI, startJ);
					ret[0] += cnt[0];
					ret[1] += cnt[1];
					cnt = paperCnt(paper, N / 2, startI + N / 2, startJ);
					ret[0] += cnt[0];
					ret[1] += cnt[1];
					cnt = paperCnt(paper, N / 2, startI, startJ + N / 2);
					ret[0] += cnt[0];
					ret[1] += cnt[1];
					cnt = paperCnt(paper, N / 2, startI+ N / 2, startJ + N / 2);
					ret[0] += cnt[0];
					ret[1] += cnt[1];
					return ret;
				}
			}
		}
		ret[paperkinds] += 1;
		return ret;
			
	}
}
