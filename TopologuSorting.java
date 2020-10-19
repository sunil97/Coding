import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSorting {

	static class graph{
		int v ;
		ArrayList<Integer> []adj ;
		public graph(int v) {
			this.v = v;
			adj = new ArrayList[v];
			for(int i=0;i<v;i++)
				adj[i] = new ArrayList<>();
		}
		public  void addEdge(int u, int v) {
			adj[v].add(v);
		}
		private void topologicalSort() {
				Stack<Integer>st = new Stack<>();
				boolean []visited = new boolean[v];
				Arrays.fill(visited, false);
				
				for(int i=0;i<v;i++) {
						if(!visited[i])
							topoUtils(visited,i,st);
				}
				//System.out.println("size :"+st.size());
				while(!st.isEmpty())
					System.out.print(st.pop()+" ");

		}
		private void topoUtils(boolean[] visited, int id, Stack<Integer> st) {
			visited[id] =true;
			List<Integer>list = adj[id];
			for(int i =0;i<list.size();i++ ) {
			//	System.out.println("inside for");
				int cur = list.get(i);
				if(!visited[cur])
					topoUtils(visited, cur, st);
			}
			//System.out.println("size1 :"+st.size());
			st.add(id);
		}
	}
	
	public static void main(String[] args) {
		graph g = new graph(6);
			g.addEdge(5, 2); 
	        g.addEdge(5, 0); 
	        g.addEdge(4, 0); 
	        g.addEdge(4, 1); 
	        g.addEdge(2, 3); 
	        g.addEdge(3, 1); 
	        
	        g.topologicalSort();
	}

}
