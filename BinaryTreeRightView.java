import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeRightView {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Node root = createTree();
        System.out.println("Right View:");
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size() - 1; i++) {
                Node tempNode = queue.poll();
                if (tempNode.left != null)
                    queue.offer(tempNode.left);
                if (tempNode.right != null)
                    queue.offer(tempNode.right);
            }
            Node tempNode = queue.poll();
            System.out.println(tempNode.data);
            if (tempNode.left != null)
                queue.offer(tempNode.left);
            if (tempNode.right != null)
                queue.offer(tempNode.right);
        }
    }

    static Node createTree() {
        Node root = null;

        System.out.println("Enter data: ");
        int data = sc.nextInt();

        if (data == -1)
            return root;

        root = new Node(data);
        System.out.println("Left subtree data for " + data + ": ");
        root.left = createTree();

        System.out.println("Right subtree data for " + data + ": ");
        root.right = createTree();

        return root;
    }
}
