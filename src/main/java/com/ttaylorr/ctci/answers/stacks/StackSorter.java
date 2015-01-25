package com.ttaylorr.ctci.answers.stacks;

import com.ttaylorr.ctci.meta.Solution;

import java.util.Stack;

@Solution(chapter = 3, problem = 6)
public class StackSorter {
    protected final Stack<Integer> unsorted;

    public StackSorter(Stack<Integer> unsorted) {
        this.unsorted = unsorted;
    }

    @SuppressWarnings("unchecked")
    public Stack<Integer> sort() {
        // We create a clone of the original stack so as not to mutate what we have as
        // a member of the class.
        //
        // We also create a new, empty Stack of the same type which will be filled
        // in order with the sorted elements.
        Stack<Integer> unsorted = (Stack<Integer>) this.unsorted.clone();
        Stack<Integer> sorted = new Stack<>();

        // As we go, we'll remove elements from unsorted, marking them as sorted by their
        // nature of not being in the old list.  While there are still elements to be
        // sorted, this process should continue.
        while (!unsorted.isEmpty()) {
            // We pop the next unsorted element, and store it off in a local.
            int temp = unsorted.pop();

            // We then move all of the elements that we can that are not sorted into the sorted
            // list that come before the element that we are trying to insert (see above)
            while (!sorted.isEmpty() && sorted.peek() > temp) {
                sorted.push(unsorted.pop());
            }

            // Once that is complete, then we will push the element that we had stored off
            // in the local (see above comment for further explanation).
            sorted.push(temp);
        }

        // Finally, once we're here, everything has been sorted (again, see above) and we are
        // good to go.
        return sorted;
    }
}
