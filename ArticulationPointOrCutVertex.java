package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArticulationPointOrCutVertex {

	static class Graph{
		int vertx ;
		List<Integer> [] adj ;
		public Graph(int n ) {
			vertx = n;
			adj = new ArrayList[n];
			for(int i=0;i<n;i++)
				adj[i] = new ArrayList<>();
		}
		void addEdge(int u,int v) {
			adj[u].add(v);
			adj[v].add(u);
		}
		 int time =0;
		public Set<Integer> articulationPoint() {
					int  []parent = new int [vertx];
					Arrays.fill(parent, -1);
					boolean []visited = new boolean[vertx];
					int []discTime = new int[vertx];
					int []lowTime = new int[vertx];
					Set<Integer> ap = new HashSet<>();
					dfs(0,parent,visited,discTime,lowTime,ap);
					
					
			return ap;
		}
		private void dfs(int i, int[] parent, boolean[] visited, int[] discTime, int[] lowTime, Set<Integer> ap) {
			int child=0;
			visited[i]=true;
			discTime[i]= lowTime[i]=++time;
			List<Integer>list = adj[i];
			for(int u : list) {
				if(!visited[u]) {
					parent[u]=i;
					child++;
					dfs(u, parent, visited, discTime, lowTime, ap);
					lowTime[i] = Math.min(lowTime[i], lowTime[u]);
					
					//case 1: when i is root child and have more then 1 children
					if(parent[i]==-1 && child>1)
						ap.add(i);
					//case 2 : when subtree rooted at u has a back -age 
					//it means dicovery time of i <= then  lowTime of u (u can't be reached before and at same time as of i).
					if(parent[i]!=-1 && discTime[i]<=lowTime[u]) {
					ap.add(i);	
					}
				}
				lowTime[i] = Math.min(lowTime[i], discTime[u]);
			}
			
		}
	}
	public static void main(String[] args) {
			int n = 7;
			Graph graph = new Graph(n);
			graph.addEdge(0, 1); 
			graph.addEdge(1, 2); 
			graph.addEdge(2, 0); 
			graph.addEdge(1, 3); 
			graph.addEdge(1, 4); 
			graph.addEdge(1, 6); 
			graph.addEdge(3, 5); 
			graph.addEdge(4, 5); 
		
		
	    
			Set<Integer> ap = graph.articulationPoint(); 
		for(int x : ap)
			System.out.print(x+" ");
	}
	

}
