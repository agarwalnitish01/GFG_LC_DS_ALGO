class BalancedTree1 {
    Node root;

    boolean isBalanced(Node node)
    {
        int lh;
        int rh;

        if (node == null)
            return true;

        lh = height(node.left);
        rh = height(node.right);

        return Math.abs(lh - rh) <= 1
                && isBalanced(node.left)
                && isBalanced(node.right);

    }

    int height(Node node)
    {
        if (node == null)
            return 0;
        int l = height(node.left);
        int r = height(node.right);

        return 1 + Math.max(l, r);
    }

    public static void main(String args[])
    {
        BalancedTree1 tree = new BalancedTree1();
        /* Constructed binary tree is
                   1
                 /   \
                2      3
              /  \
            4     5
            /
           8
           */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(8);

        if (tree.isBalanced(tree.root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}
