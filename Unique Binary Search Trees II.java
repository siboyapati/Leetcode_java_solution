/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>(n);
        for(int i=1; i<=n; i++) list.add(i);
        return generateTrees0(list);
    }
    private List<TreeNode> generateTrees0(ArrayList<Integer> list) {
        List<TreeNode> r = new ArrayList<TreeNode>();
        if(list.isEmpty()) {
            r.add(null);
            return r;
        }
        for(int i=0; i<list.size(); i++) {
            ArrayList<Integer> leftList = new ArrayList<Integer>();
            for(int j=0; j<i; j++) leftList.add(list.get(j));
            ArrayList<Integer> rightList = new ArrayList<Integer>();
            for(int j=i+1; j<list.size(); j++) rightList.add(list.get(j));
            for(TreeNode ln : generateTrees0(leftList)) {
                for(TreeNode rn : generateTrees0(rightList)) {
                    TreeNode root = new TreeNode(list.get(i));
                    root.left = ln;
                    root.right = rn;
                    r.add(root);
                }
            }
        }
        return r;
    }
}
