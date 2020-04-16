class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n<=0 || edges.length<=0) new ArrayList<Integer>();
        ArrayList<Integer> []adj = new ArrayList[n];
        for(int i=0;i<n;i++)
            adj[i] = new ArrayList<Integer>();
        for(int []a : edges)
        {
            adj[a[0]].add(a[1]);
            adj[a[1]].add(a[0]);
        }
        
        //now we will find 2 node for which dist between them will be max in graph.
        //ALGO-: choose random node and find max dist node(y) from this .and 
            // then find max dist node from  this new Node(y).
        //we choose 0 as random node
        int y  = 0; 
            int [] dist1 = new int[n];
            int [] dist2 = new int[n];
            int [] parent  = new int[n];
            findMaxDistUsingBFS(0,adj,dist1,parent);
            for(int i =0;i<n;i++)
                if(dist1[i]>dist1[y])
                    y = i;
        
            findMaxDistUsingBFS(y,adj,dist2,parent);
            int z =0;
            for(int i =0;i<n;i++)
                if(dist2[i]>dist2[z])
                    z = i;
            ArrayList<Integer> path = new ArrayList<>();
            while(z!=-1){
                path.add(z);
                z = parent[z] ; 
            }
        int size = path.size();
        if(size%2==0) 
            return Arrays.asList(path.get(size/2),path.get(size/2-1));
        return Arrays.asList(path.get(size/2));
    }
    
    private void findMaxDistUsingBFS(int start , ArrayList<Integer> []adj, int [] dist ,int []                        parent ){
        boolean []visited = new boolean[dist.length];
        dist[start] = 0;
        parent[start] = -1;
        visited[start]=true;
        Queue<Integer>q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int x = q.poll();
            for(int nei : adj[x]){
                if(!visited[nei]){
                    visited[nei] =true;
                    dist[nei] = dist[x]+1;
                    parent[nei] = x;
                    q.add(nei);
                }
            }
        }
        
    }
}
