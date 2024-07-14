import java.util.Scanner;

public class binaryTree {
    Node rootNode;

    public binaryTree(int rootValue) {
        this.rootNode = new Node(rootValue);
    }

    public void inputTreeNodes(Scanner scanner, Node rootNode) {
        if (rootNode == null) {
            return;
        }

        System.out.println("Enter the value of the left child of " + rootNode.data + " (or -1 to skip):");
        int leftValue = scanner.nextInt();
        if (leftValue != -1) {
            rootNode.left = new Node(leftValue);
            inputTreeNodes(scanner, rootNode.left);
        }

        System.out.println("Enter the value of the right child of " + rootNode.data + " (or -1 to skip):");
        int rightValue = scanner.nextInt();
        if (rightValue != -1) {
            rootNode.right = new Node(rightValue);
            inputTreeNodes(scanner, rootNode.right);
        }
    }

    public void performPreorderTraversal(Node rootNode) {
        if (rootNode != null) {
            System.out.print(rootNode.data + " ");
            performPreorderTraversal(rootNode.left);
            performPreorderTraversal(rootNode.right);
        }
    }

    public void performInorderTraversal(Node rootNode) {
        if (rootNode != null) {
            performInorderTraversal(rootNode.left);
            System.out.print(rootNode.data + " ");
            performInorderTraversal(rootNode.right);
        }
    }

    public void performPostorderTraversal(Node rootNode) {
        if (rootNode != null) {
            performPostorderTraversal(rootNode.left);
            performPostorderTraversal(rootNode.right);
            System.out.print(rootNode.data + " ");
        }
    }
}
