class Node {
    int data;
    Node left, right;
    boolean color; // true - red, false - black

    public Node(int data) {
        this.data = data;
        color = true;
        left = right = null;
    }
}

public class RedBlackTree {
    public static int operations = 0;
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node rotateLeft(Node h) {
        operations++;
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h) {
        operations++;
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h) {
        operations++;
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void insert(int data) {
        root = insert(root, data);
        root.color = BLACK;
    }

    private Node insert(Node h, int data) {
        operations++;
        if (h == null) return new Node(data);

        if (data < h.data)
            h.left = insert(h.left, data);
        else if (data > h.data)
            h.right = insert(h.right, data);
        else
            h.data = data;

        if (isRed(h.right) && !isRed(h.left))
            h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left))
            h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))
            flipColors(h);

        return h;
    }

    private boolean isRed(Node node) {
        operations++;
        if (node == null) return false;
        return node.color == RED;
    }

    public Node search(int data) {
        return search(root, data);
    }

    private Node search(Node x, int data) {
        operations++;
        if (x == null || x.data == data)
            return x;
        if (data < x.data)
            return search(x.left, data);
        else
            return search(x.right, data);
    }

    public void delete(int data) {
        root = delete(root, data);
        if (root != null)
            root.color = BLACK;
    }

    private Node delete(Node h, int data) {
        operations++;
        if (h == null) return null;

        if (data < h.data) {
            h.left = delete(h.left, data);
        } else if (data > h.data) {
            h.right = delete(h.right, data);
        } else {
            if (h.right == null) return h.left;
            if (h.left == null) return h.right;

            Node temp = h;
            h = min(temp.right);
            h.right = deleteMin(temp.right);
            h.left = temp.left;
        }

        return h;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    private Node deleteMin(Node x) {
        operations++;
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }
}