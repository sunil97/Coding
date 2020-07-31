public class PrintingPathsinDijkstrasShortestPathAlgorithm {
	static int INF = 100000;
	public static void main(String[] args) {

		int n =4;
		int [][]edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
		
//		int n =5;
//		int [][]edges = 	{{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};
		
		List<int []> []adj = new ArrayList[n];
		int [][]dist = new int[n][n];
		for(int i=0;i<n;i++) {
			Arrays.fill(dist[i],INF );
			dist[i][i] = 0;
		}
		for(int i=0;i<n;i++)
			adj[i] = new ArrayList<int[]>();
		for(int []e : edges) {
			int u = e[0];
			int v = e[1];
			int d = e[2];
			
			adj[u].add(new int[] {v,d});
			adj[v].add(new int[] {u,d});
		
			
		}

		List<List<Integer>> paths = new ArrayList<>();
		dijkstra(paths,n,adj,dist[0],0);
		System.out.println("path :"+paths);
	}

	private static void dijkstra(List<List<Integer>> paths, int n, List<int[]>[] adj, int[] dist, int src) {

		boolean[] vis = new boolean[n];
		Arrays.fill(vis, false);
		vis[0] = true;
		// paths.add(new ArrayList<Integer>() {{add(src);}});
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
		q.offer(new int[] { src, src });
		// parent array to get the path.
		int[] parent = new int[n];
		parent[0] = 0;
		while (!q.isEmpty()) {
			int[] v = q.remove();
			int vert = v[0];
			int d = v[1];
			List<int[]> nei = adj[vert];
			for (int[] e : nei) {
				// System.out.println("nei iterarion");
				if (dist[e[0]] > (d + e[1])) {
					dist[e[0]] = (d + e[1]);
					parent[e[0]] = vert;

					// System.out.println(path);
					q.offer(new int[] { e[0], dist[e[0]] });
				}
			}
		}
		for (int i = 0; i < n; i++) {
			addPath(parent, i, paths, new ArrayList<>());
		}

	}
	private static void addPath(int[] parent, int i, List<List<Integer>> paths, ArrayList<Integer> path) {
		path.add(i);
		if(i==0) {
			
			paths.add(path);
			return;
		}
		addPath(parent, parent[i], paths, path);
		
		
	}

}
