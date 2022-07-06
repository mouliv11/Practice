public class SearchNode {

    public class Node {
        private Node left;
        private Node right;
        private int data;

        public Node(Node left, Node right, int data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }

    public static Node dfs (Node root, int target) {
        if (root == null)
            return null;
        if (root.data == target)
            return root;
        Node left = dfs(root.left, target);
        if (left != null)
            return left;
        return dfs(root.right, target);
    }
}
