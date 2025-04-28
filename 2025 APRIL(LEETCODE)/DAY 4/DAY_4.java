// 1123. Lowest Common Ancestor of Deepest Leaves
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class DAY_4 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        // Start the DFS traversal to find the LCA of deepest leaves
        return dfs(root).getKey();
    }

    private Pair<TreeNode, Integer> dfs(TreeNode root) {
        // Base case: if the node is null, return (null, 0)
        if (root == null) return new Pair<>(null, 0);

        // Recursively find the LCA and depth for left and right subtrees
        Pair<TreeNode, Integer> left = dfs(root.left);
        Pair<TreeNode, Integer> right = dfs(root.right);

        // Compare depths of left and right subtrees
        if (left.getValue() > right.getValue()) {
            // Left subtree is deeper
            return new Pair<>(left.getKey(), left.getValue() + 1);
        }
        if (left.getValue() < right.getValue()) {
            // Right subtree is deeper
            return new Pair<>(right.getKey(), right.getValue() + 1);
        }
        // Both subtrees have the same depth, current node is the LCA
        return new Pair<>(root, left.getValue() + 1);
    }
}