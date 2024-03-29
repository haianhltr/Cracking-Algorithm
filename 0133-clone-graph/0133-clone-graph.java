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
        HashMap<Node, Node> hash = new HashMap();
        if(node == null) return null;
        DFS(node, hash);
    
        return hash.get(node);
        
    }
    
    public void DFS(Node node, HashMap<Node, Node> hash)
    {
        if(!hash.containsKey(node))
        {
            hash.put(node, new Node(node.val));
        }
        else
        {
            return;
        }
        
        for(Node nei : node.neighbors)
        {
            DFS(nei, hash);
            hash.get(node).neighbors.add(hash.get(nei));
        }
    }
}