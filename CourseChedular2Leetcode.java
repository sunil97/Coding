class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> []adj = new ArrayList[numCourses];
        for(int i = 0;i<numCourses;i++)
            adj[i] = new ArrayList<>();
        int []indeg = new int[numCourses];
        for(int []edge : prerequisites){
            adj[edge[0]].add(edge[1]);
            indeg[edge[1]]++;
        }
        int []res = new int[numCourses];
        Queue<Integer>q = new LinkedList<>();
        for(int i = 0;i<numCourses;i++)
            if(indeg[i]==0)
                q.add(i);
        int visited = 0;
       while(!q.isEmpty()){
           int x = q.poll();
           res[visited++]=x;
           for(int nei : adj[x]){
               if(--indeg[nei] ==0 )
                   q.add(nei);
           }
       }
       if(visited==numCourses) return res;
        return new int[0];
    }
}
