import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public List<Integer> traverse(Node tree) {
        List<Integer> result = new ArrayList<>();
        if (tree == null)
            return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            result.add(cur.value);
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
        return result;
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        root.left = n2;
        root.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        BFS bfs = new BFS();
        bfs.traverse(root);
    }
}
