package com.ttaylorr.ctci.answers.graphs.utils;

import java.util.List;
import java.util.Set;

public interface Graph<E> {
    public Set<Node<E>> getNodes();

    public static interface Node<E> {
        public List<Node<E>> getAdjacent();
        public E getData();
    }
}
