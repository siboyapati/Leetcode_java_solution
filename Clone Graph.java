/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
import java.util.*;

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        /*
            def cloneGraph(self, node):
                if node is None:
                    return None
                q=[]
                copied={}
                q.append(node)
                copied[node] = UndirectedGraphNode(node.label)
                while q:
                    n = q.pop()
                    for nb in n.neighbors:
                        if copied.__contains__(nb):
                            copied[n].neighbors.append(copied[nb])
                        else:
                            new_nb = UndirectedGraphNode(nb.label)
                            copied[n].neighbors.append(new_nb)
                            copied[nb]=new_nb
                            q.append(nb)
                return copied[node]
                
                time O(V+E) space O(V)
        */
        if(node==null) return null;
        ArrayDeque<UndirectedGraphNode> q = new ArrayDeque<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = 
            new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        q.push(node);
        map.put(node, new UndirectedGraphNode(node.label));
        while(!q.isEmpty()) {
            UndirectedGraphNode n = q.pop();
            for(UndirectedGraphNode nb : n.neighbors) {
                if(map.containsKey(nb)) {
                    UndirectedGraphNode nn = map.get(n);
                    nn.neighbors.add(map.get(nb));
                    map.put(n,nn);
                } else {
                    UndirectedGraphNode newNb = new UndirectedGraphNode(nb.label);
                    UndirectedGraphNode nn = map.get(n);
                    nn.neighbors.add(newNb);
                    map.put(n,nn);
                    map.put(nb,newNb);
                    q.push(nb);
                }
            }
        }
        return map.get(node);
    }
}
