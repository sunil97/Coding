package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphBipartite {

	public static void main(String[] args) {
		GraphBipartite obj = new GraphBipartite();
		int[][] graph =     {{1,2,3}, {0,2}, {0,1,3}, {0,2}}; 
			// { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } };
		System.out.println(obj.isBipartite(graph));
		
	}

	public boolean isBipartite(int[][] graph) {
		int [] color = new int [graph.length];
		//0 -not colored
		//1 -red
		//-1 -black
		for(int i =0;i<graph.length;i++) {
			if(color[i]!=0)continue;
			
			Queue<Integer>q= new LinkedList<Integer>();
			q.offer(i);
			color[i] =1;
			while(!q.isEmpty()) {
				int node = q.poll();
				for(int currentNode : graph[node]) {
					if(color[currentNode]==color[node])
						return false;
					if(color[currentNode]==0) {
					color[currentNode]=-color[node];
					
					q.offer(currentNode);
					}
				}
				
			}
			
		}
		return true;
	}

}
