package com.ttaylorr.ctci.answers.trees;

import com.ttaylorr.ctci.answers.trees.util.TreeNode;
import com.ttaylorr.ctci.meta.Solution;

@Solution(chapter = 4, problem = 7)
public class SubtreeTest {
    public static SubtreeTest of(TreeNode largeBase) {
        return new SubtreeTest(largeBase);
    }

    protected final TreeNode largeBase;
    public SubtreeTest(TreeNode largeBase) {
        this.largeBase = largeBase;
    }

    public boolean containsTree(TreeNode other) {
        if (other == null) return true;
        else return this.subTree(this.largeBase, other);
    }

    private boolean subTree(TreeNode a, TreeNode b) {
        if (a == null) {
            return false;
        } else if (a.value == b.value) {
            return this.matchTree(a, b);
        } else {
            return subTree(a.left, b) || subTree(a.right, b);
        }
    }

    private boolean matchTree(TreeNode a, TreeNode b) {
        if (b == null && a == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        } else if (a.value != b.value) {
            return false;
        } else {
            return this.matchTree(a.left, b.left) && this.matchTree(a.right, b.right);
        }
    }
}
