package com.ttaylorr.ctci.answers.linked_lists;

import com.ttaylorr.ctci.answers.linked_lists.util.LinkedList;
import com.ttaylorr.ctci.meta.Solution;

import java.util.HashSet;
import java.util.Set;

@Solution(chapter = 2, problem = 1)
public class UnsortedDuplicateRemover<E> {
    protected final LinkedList.Node<E> head;

    public UnsortedDuplicateRemover(LinkedList.Node<E> head) {
        this.head = head;
    }

    public void removeWithBuffer() {
        if (this.head == null) return;

        Set<LinkedList.Node<E>> set = new HashSet<>();

        LinkedList.Node current = this.head;
        set.add(current);

        while ((current = current.next()) != null) {
            if(set.contains(current)) {
                // Skip the next element if it's already been found in the list
                current.next(current.next());
            } else {
                set.add(current);
            }
        }
    }

    public void removeWithoutBuffer() {
        if (this.head == null) return;

        // Keep track of the current and previous node (we'll remember the previous one
        // so that we can create a link to the next one if need-be.
        LinkedList.Node<E> previous = this.head;
        LinkedList.Node<E> current = previous.next();

        // Keep advancing until we hit the end of the list
        while (current != null) {
            // Create a runner which will loop through the head of the list up through the current
            // element and check for duplicates.
            LinkedList.Node<E> runner = this.head;
            while (runner != current) {
                // If we have a match (i.e., a duplicate) then create a link
                // over the duplicated element, and move on with our search.
                if (runner.data() == current.data()) {
                    LinkedList.Node<E> temp = current.next();
                    previous.next(temp);
                    current = temp;

                    // We can break here because we will only find at max one duplicate
                    // per element that we visit.
                    break;
                }
            }

            // If we haven't updated our pointer, do so now.
            if (runner == current) {
                previous = current;
                current = current.next();
            }
        }
    }
}

