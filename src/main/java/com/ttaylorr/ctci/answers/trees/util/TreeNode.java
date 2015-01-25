package com.ttaylorr.ctci.answers.trees.util;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

/**
 * Empty implementation of a binary tree-node.
 * @param <E> The type of data that the node holds.
 */
public class TreeNode<E> {
    public @NotNull E value;
    public @Nullable TreeNode<E> left;
    public @Nullable TreeNode<E> right;

    public TreeNode(E value) {
        this.value = value;
    }
}
