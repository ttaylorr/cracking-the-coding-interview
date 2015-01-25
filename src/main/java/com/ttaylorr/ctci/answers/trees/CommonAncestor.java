package com.ttaylorr.ctci.answers.trees;

import com.ttaylorr.ctci.answers.trees.util.TreeNode;
import com.ttaylorr.ctci.meta.Solution;

@Solution(chapter = 4, problem = 6)
public class CommonAncestor {
    // Example usage: CommonAncestorFinder.of(foo, bar).in(baz);
    public static CommonAncestor.Builder of(TreeNode a, TreeNode b) {
        return new CommonAncestor.Builder(a, b);
    }

    private static class Builder {
        private TreeNode a, b;
        public Builder(TreeNode a, TreeNode b) {
            this.a = a;
            this.b = b;
        }

        public TreeNode in(TreeNode root) {
            return new CommonAncestor(a, b).findCommonAncestor(root);
        }
    }

    protected final TreeNode a, b;
    public CommonAncestor(TreeNode a, TreeNode b) {
        this.a = a;
        this.b = b;
    }

    public TreeNode findCommonAncestor(TreeNode root) {
        if (this.covers(root.left, this.a) && this.covers(root.left, this.b)) {
            return this.findCommonAncestor(root.left);
        } else if (this.covers(root.right, this.a) && this.covers(root.right, this.b)) {
            return this.findCommonAncestor(root.right);
        } else {
            return root;
        }
    }

    /**
     * Determine whether the other node is contained within the root.
     */
    private boolean covers(TreeNode root, TreeNode other) {
        if (root == null) return false;
        if (root == other) return true;
        else return this.covers(root.left, other) || this.covers(root.right, other);
    }
}
