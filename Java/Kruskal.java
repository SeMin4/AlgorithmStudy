class Edge implements Comparable<Edge>{
	int V1;
	int V2;
	int weight;
	public Edge(int V1, int V2, int weight) {
		this.V1 = V1;
		this.V2 = V2;
		this.weight = weight;
	}
	@Override
	public int compareTo(Edge o) {
		if(this.weight < o.weight) return -1;
		else if(this.weight == o.weight) return 0;
		else return 1;
	}
	
}
public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.offer(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		int[] parent = new int[V + 1];
		for (int i = 1; i <= V; i++) parent[i] = i;
		int sum = 0;
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(union(edge.V1, edge.V2, parent)){
				sum += edge.weight;
			}
		}
		System.out.println(sum);
	}
	public static int find(int V, int[] parent) {
		if(V != parent[V]) {
			return find(parent[V], parent);
		}
		return V;
	}
	public static boolean union(int V1, int V2, int[] parent) {
		V1 = find(V1, parent);
		V2 = find(V2, parent);
		if(V1 != V2) {
			parent[V2] = V1;
			return true;
		}
		return false;
	}
}

