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
        if(node == null) return null;
        Node result = new Node();
        Queue<Node> queue = new LinkedList();
        HashMap<Node, Node> hash = new HashMap();
        hash.put(node, new Node(node.val));
        queue.add(node);
        while(!queue.isEmpty())
        {
            Node current  = queue.poll();
            for(Node neigh : current.neighbors)
            {
                if(!hash.containsKey(neigh))
                {
                    hash.put(neigh, new Node(neigh.val));
                    queue.add(neigh);
                }
                
                hash.get(current).neighbors.add(hash.get(neigh));
                
            }
            
            
            
        }
        return hash.get(node);
    }
}