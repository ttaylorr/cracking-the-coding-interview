package com.ttaylorr.ctci.answers.trees;

import com.ttaylorr.ctci.answers.trees.util.TreeNode;
import com.ttaylorr.ctci.meta.Solution;

@Solution(chapter = 4, problem = 1)
public class TreeBalanceChecker<E> {
    protected final TreeNode<E> root;

    public TreeBalanceChecker(TreeNode<E> root) {
        this.root = root;
    }

    private int maxDepth(TreeNode<E> root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(this.maxDepth(root.left), this.maxDepth(root.right));
        }
    }

    private int minDepth(TreeNode<E> root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.min(this.minDepth(root.left), this.minDepth(root.right));
        }
    }

    public boolean isBalanced() {
        return (this.maxDepth(this.root) - this.minDepth(root)) <= 1;
    }
}
