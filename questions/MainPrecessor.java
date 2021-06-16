import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Predecessor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");

        Predecessor bst = new Predecessor();

        for (String string : strings) {
            int number = Integer.parseInt(string);
            bst.insert(number);
        }

        int target = sc.nextInt();

        Node found = bst.search(target);

        List<Integer> walk = new ArrayList<>();
        bst.getPredecessor(found, walk);

        System.out.println(walk);
    }

    static class Node {
        int value;
        Node left;
        Node right;
        Node parent;

        Node(int value) {
            this.value = value;
        }
    }

    Node root;

    public void insert(int value) {
        if (this.root == null) {
            this.root = new Node(value);
        } else {
            this.insert(this.root, value);
        }
    }

    private void insert(Node node, int value) {
        if (value < node.value) {
            if (node.left == null) {
                Node newNode = new Node(value);
                node.left = newNode;
                newNode.parent = node;
                return;
            }

            insert(node.left, value);
        } else {
            if (node.right == null) {
                Node newNode = new Node(value);
                node.right = newNode;
                newNode.parent = node;
                return;
            }

            insert(node.right, value);
        }
    }

    private Node getMax(Node aux, List<Integer> walked) {
        if (aux == null) {
            return null;
        }
        walked.add(aux.value);

        if (aux.right == null) {
            return aux;
        }

        return getMax(aux.right, walked);
    }

    public void getPredecessor(Node node, List<Integer> walked) {
        if (node == null) {
            return;
        }
        walked.add(node.value);

        if (node.left != null) {
            getMax(node.left, walked);
        } else {
            Node aux = node.parent;

            while (aux != null && aux.value > node.value) {
                walked.add(aux.value);
                aux = aux.parent;
            }

            if (aux != null) {
                walked.add(aux.value);
            }

        }
    }

    public Node search(int value) {
        if (this.root == null) {
            return null;
        }

        return search(this.root, value);
    }

    private Node search(Node node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.value) {
            return search(node.left, value);
        }

        if (value > node.value) {
            return search(node.right, value);
        }

        return node;
    }
}