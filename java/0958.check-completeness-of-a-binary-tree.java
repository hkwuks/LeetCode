/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        ArrayList<ANode> list = new ArrayList<>();
        list.add(new ANode(root,1));
        int i=0;
        while (i< list.size()) {
            ANode anode=list.get(i++);
            if (anode.node!=null) {
                list.add(new ANode(anode.node.left,anode.code*2));
                list.add(new ANode(anode.node.right,anode.code*2+1));
            }
        }
        return list.get(i-1).code==list.size();
    }



    class ANode {
        TreeNode node;
        int code;

        ANode(TreeNode node, int code) {
            this.node = node;
            this.code = code;
        }
    }
}