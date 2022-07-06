public class UpsideBT {

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;
    }

    public TreeNode upsideDown(TreeNode root) {
        if (root == null)
            return null;
        return upsideDown(root, null);
    }

    private TreeNode upsideDown(TreeNode cur, TreeNode parent) {
        TreeNode newNode = cur;
        if (cur.left != null) {
            newNode = upsideDown(cur.left, cur);
        }
        if (parent != null) {
            cur.left = parent.right;
            cur.right = parent;
            parent.left = null;
            parent.right = null;
        }
        return newNode;
    }

}
