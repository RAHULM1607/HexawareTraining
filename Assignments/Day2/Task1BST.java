package Day2Assignment;

public class Task1BST {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static class BST {
        Node root;

        void insert(int data) {
            root = insertNode(root, data);
        }

        Node insertNode(Node root, int data) {
            if (root == null) return new Node(data);

            if (data < root.data) {
                root.left = insertNode(root.left, data);
            } else if (data > root.data) {
                root.right = insertNode(root.right, data);
            }
            return root;
        }

        boolean search(int data) {
            Node temp = root;

            while (temp != null) {
                if (temp.data == data) return true;
                else if (data < temp.data) temp = temp.left;
                else temp = temp.right;
            }
            return false;
        }

        void inorder(Node root) {
            if (root == null) return;
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        void preorder(Node root) {
            if (root == null) return;
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        void postorder(Node root) {
            if (root == null) return;
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();

        int[] values = {50, 30, 70, 20, 40, 60, 80, 50};
        for (int value : values) bst.insert(value);

        System.out.print("Inorder: ");
        bst.inorder(bst.root);

        System.out.print("\nPreorder: ");
        bst.preorder(bst.root);

        System.out.print("\nPostorder: ");
        bst.postorder(bst.root);

        System.out.println("\nSearch 60: " + bst.search(60));
        System.out.println("Search 90: " + bst.search(90));
        System.out.println("Empty BST search: " + new BST().search(10));
    }
}
