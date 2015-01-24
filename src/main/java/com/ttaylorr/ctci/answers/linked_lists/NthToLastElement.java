package com.ttaylorr.ctci.answers.linked_lists;

import com.ttaylorr.ctci.answers.linked_lists.util.LinkedList;
import com.ttaylorr.ctci.meta.Solution;

@Solution(chapter = 2, problem = 3)
public class NthToLastElement<E> {
    protected final LinkedList.Node<E> head;
    protected final int n;

    public NthToLastElement(LinkedList.Node<E> head, int n) {
        this.head = head;
        this.n = n;
    }

    public LinkedList.Node<E> get() {
        LinkedList.Node<E> a = this.head;
        LinkedList.Node<E> b = null;

        // Space the two pointers out by `n` degrees of sepration
        for (int i = 0; i < n; i++) b = (b == null) ? a : b.next();

        // Increase them both until we hit the end of the list
        while ((b = b.next()) != null) {
            a = a.next();
        }

        // Once we've done that, return the one further from the end of the list.
        return a;
    }
}
