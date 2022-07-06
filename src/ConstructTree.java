import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;

public class ConstructTree {



// you can also use imports, for example:
// import java.util.*;

        static Map<Character, Integer> hashMap;

        static class Node {
            char data;
            Node left;
            Node right;

            Node (char data) {
                this.data = data;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "data=" + data +
                        ", left=" + left +
                        ", right=" + right +
                        '}';
            }
        }

        public static void main(String [] args) {
            // you can write to stdout for debugging purposes, e.g.
            char[] inorder = new char[]{'D','B','A','G','E','H','C','F'};
            char[] preorder = new char[]{'A','B','D','C','E','G','H','F'};
            Node node = constructTree(inorder, preorder);
            System.out.println("node :" + node);


        }

        private static Node constructTree(char[] inorder, char[] preorder) {

            if (preorder == null || inorder == null)
                return null;

            hashMap = new HashMap<>();
            for (int i=0; i<inorder.length; i++) {
                hashMap.put(inorder[i], i);
            }

            return constructTree(0, 0, inorder.length-1, preorder);
        }

        private static Node constructTree(int preStart, int inStart, int inEnd, char[] preorder) {
            if (preStart > preorder.length || inStart > inEnd)
                return null;

            Node node = new Node(preorder[preStart]);
            int rootIdx = hashMap.get(node.data);
            node.left = constructTree(preStart+1, inStart, rootIdx-1, preorder);
            node.right = constructTree(preStart + rootIdx - inStart + 1, rootIdx+1, inEnd, preorder);
            return node;
        }
    }

// inorder: Left, root, node
// preorder: root, left, node

//    A
//  B      C
// D    E     F
//   G   H






