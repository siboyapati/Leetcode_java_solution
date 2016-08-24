/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
        while(!stack.isEmpty()) {
            node = stack.pop();
            int cnt = nodeCount(node, map);
            map.put(node, cnt);
            if(cnt >= k) {
                // now we have a sub tree containing the target
                return findTarget(node, map, k);
            }
        }
        return -1;
    }
    
    private int findTarget(TreeNode node, Map<TreeNode, Integer> map, int k) {
        int leftCnt = nodeCount(node.left, map);
        if(leftCnt >= k) return findTarget(node.left, map, k);
        else if(leftCnt + 1 == k) return node.val;
        else return findTarget(node.right, map, k-leftCnt-1);
    }
    
    private int nodeCount(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null) return 0;
        else if(map.containsKey(node)) return map.get(node);
        else return 1 + nodeCount(node.left, map) + nodeCount(node.right, map);
    }
}
