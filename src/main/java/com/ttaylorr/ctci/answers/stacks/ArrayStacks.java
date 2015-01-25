package com.ttaylorr.ctci.answers.stacks;

import com.ttaylorr.ctci.meta.Solution;

@Solution(chapter = 3, problem = 1)
public class ArrayStacks {
    public static final int STACK_SIZE = 128;

    /**
     * To implement several stacks using one array, we will chunk the array into `n`
     * pieces and use those chunks to represent each stack.
     */
    protected Object[] arr;

    /**
     * To keep track of where the head of that stack is within each array, we will
     * store off an "offset" pointer to tell us where the head of the stack is, relative
     * to n * stack_size.
     *
     * For example: the head of stack 6 is:
     *      int head = (6 * stackSize) + this.pointers[6] + 1;
     */
    protected final int[] pointers;

    public ArrayStacks(int numStacks) {
        assert numStacks > 0;
        this.arr = new Object[STACK_SIZE * numStacks];
        this.pointers = new int[numStacks];
    }

    public void push(int stack, Object o) {
        int index = stack * STACK_SIZE + this.pointers[stack] + 1;
        this.pointers[stack]++;
        this.arr[index] = o;
    }

    public Object pop(int stack) {
        // Determine the index at the head of the stack for the one we are asking for
        int index = stack * STACK_SIZE + this.pointers[stack];

        // Grab the value we want and store it off in a local so we can later return it
        // Then null out the value that was in its place
        Object value = this.arr[index];
        this.arr[index] = null;

        // Decrement the pointer because we have removed an element from that stack
        this.pointers[stack]--;

        // Finally, return.
        return value;
    }
}
