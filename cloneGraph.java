/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        boolean []visited = new boolean [101];
        Arrays.fill(visited,false);
        return DFS(node ,new HashMap<Node, Node>(),visited);
    }
    public Node DFS(Node root, HashMap<Node, Node>map,  boolean []visited){
        if(root==null)
            return null;
        Node newRoot = new Node(root.val);
        map.put(root,newRoot);
        visited[root.val] =true;
       
        List<Node>nei = root.neighbors;
       for(Node nd : nei ){
           if(nd!=null &&  !visited[nd.val]){
                DFS(nd,map,visited);
               
           }
           newRoot.neighbors.add(map.get(nd));
       }
    
        return newRoot;
    }
}
