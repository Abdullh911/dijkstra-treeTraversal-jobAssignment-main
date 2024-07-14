import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       // dijkstra.dijkstraAlg();

        ///
        Scanner scanner = new Scanner(System.in);
        System.out.println("welcome to graph assistant");
        System.out.println("--------------------------------------");
        int op ;
        do {

            System.out.println("1. dijkstra\n2. class assignment\n3. tree traversal\n4. exit");
            op = scanner.nextInt() ;
            switch (op){
                case 1 :
                    dijkstra.dijkstraAlg();
                    break;
                case 2 :
                    new coloring() ;
                    break;
                case 3 :
                    System.out.println("Enter the value of the root node:");
                    int rootValue = scanner.nextInt();

                    binaryTree treee = new binaryTree(rootValue);
                    treee.inputTreeNodes(scanner, treee.rootNode);

                    System.out.println("Preorder Traversal:");
                    treee.performPreorderTraversal(treee.rootNode);
                    System.out.println();

                    System.out.println("Inorder Traversal:");
                    treee.performInorderTraversal(treee.rootNode);
                    System.out.println();

                    System.out.println("Postorder Traversal:");
                    treee.performPostorderTraversal(treee.rootNode);
                    System.out.println();
                    break;
                case 4 :
                    System.exit(1);
                    break;
            }
        }while(false) ;


//
//        System.out.println("Enter the value of the root node:");
//        int rootValue = scanner.nextInt();
//
//        binaryTree customTree = new binaryTree(rootValue);
//        customTree.inputTreeNodes(scanner, customTree.rootNode);
//
//        System.out.println("Preorder Traversal:");
//        customTree.performPreorderTraversal(customTree.rootNode);
//        System.out.println();
//
//        System.out.println("Inorder Traversal:");
//        customTree.performInorderTraversal(customTree.rootNode);
//        System.out.println();
//
//        System.out.println("Postorder Traversal:");
//        customTree.performPostorderTraversal(customTree.rootNode);
    }
}