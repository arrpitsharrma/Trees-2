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
    class Pair{
        TreeNode node;
        int value;
        public Pair(TreeNode node, int value){
            this.node = node;
            this.value = value;
        }
        
        public TreeNode getKey(){
            return this.node;
        }
        
        public int getValue(){
            return this.value;
        }
    }
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        Stack<Pair> st = new Stack<>();
        int currSum = 0; int res = 0;
        while(root != null || !st.isEmpty()){
            while(root != null){
                currSum = currSum * 10 + root.val;
                st.push(new Pair(root, currSum));
                root = root.left;
            }
            Pair p = st.pop();
            root = p.getKey();
            currSum = p.getValue();
            if(root.left == null && root.right == null) res += currSum;
            root = root.right;
        }
        return res;
    }
}
