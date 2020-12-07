class Edge{
	int vertex;
	int weight;
	public Edge(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
}
public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] distance = new int[N + 1];
		Arrays.fill(distance, 99999999);
		ArrayList<Edge>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int V1 = Integer.parseInt(st.nextToken());
			int V2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[V1].add(new Edge(V2, weight));
			graph[V2].add(new Edge(V1, weight));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int dest = Integer.parseInt(st.nextToken());
		distance[start] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				if(o1.weight < o2.weight) return -1;
				else if(o1.weight == o2.weight) return 0;
				else return 1;
			}
		});
		pq.offer(new Edge(start, 0));
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			for (int i = 0; i < graph[edge.vertex].size(); i++) {
				Edge tmp = graph[edge.vertex].get(i);
				if(distance[tmp.vertex] > edge.vertex + tmp.weight) {
					distance[tmp.vertex] = edge.vertex + tmp.weight;
					pq.add(new Edge(tmp.vertex, distance[tmp.vertex]));
				}
			}
		}
		System.out.println(distance[dest]);
	}
}