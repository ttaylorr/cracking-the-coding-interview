package com.ttaylorr.ctci.answers.linked_lists.util;

public abstract class LinkedList<E> {
    public static interface Node<E> {
        public E data();

        public Node<E> next();
        public Node<E> next(Node<? extends E> other);
    }
}
