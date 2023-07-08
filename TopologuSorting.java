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


static class  Graph{
        int v ;
        LinkedList<Integer> []adj;
        public Graph(int v){
            this.v = v;
            adj = new LinkedList[v];
            for(int i=0;i<v;i++)
                adj[i] = new LinkedList<Integer>();
        }

        public void addEdge(int u, int v) {
            adj[u].add(v);
        }

        public void topologicalSort() {
            int []indegree = new int[v];
            calculateIndegree(indegree);
            Queue<Integer> q = new LinkedList<>();
            for(int i=0;i<v;i++){
                if(indegree[i] ==0)
                    q.offer(i);
            }
            int[] ans = new int[v];
            int i=0;
            while(!q.isEmpty()){
                int x = q.poll();
                ans[i++] = x;
                for(int nei : adj[x]){
                    indegree[nei]--;
                    if(indegree[nei] == 0){
                        q.offer(nei);
                    }
                }
            }
            if(!q.isEmpty()){
                System.out.println("the given gtaph is not DAG graph");
            }else{
                Arrays.stream(ans).forEach(x->System.out.print(x+" "));
            }
        }

        private void calculateIndegree(int[] indegree) {
            for(int i=0;i<v;i++){
                for(int x : adj[i])
                    indegree[x]++;
            }
        }
    }
