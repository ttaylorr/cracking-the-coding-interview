package com.ttaylorr.ctci.answers.trees;

import com.ttaylorr.ctci.answers.trees.util.TreeNode;
import com.ttaylorr.ctci.meta.Solution;

@Solution(chapter = 4, problem = 3)
public class MinimalBSTCreator {
    // It is assumed that this array will be sorted in increasing order.
    protected final int[] arr;

    public MinimalBSTCreator(int[] arr) {
        this.arr = arr;
    }

    public TreeNode getTree() {
        return this.addToTree(0, this.arr.length - 1);
    }

    private TreeNode addToTree(int start, int end) {
        if (end < start) {
            return null;
        } else {
            int mid = (end + start) / 2;

            TreeNode<Integer> node = new TreeNode(this.arr[mid]);
            node.left = this.addToTree(start, mid - 1);
            node.right = this.addToTree(mid + 1, end);

            return node;
        }
    }
}
