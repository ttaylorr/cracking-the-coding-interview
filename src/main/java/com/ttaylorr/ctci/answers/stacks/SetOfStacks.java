package com.ttaylorr.ctci.answers.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetOfStacks<E> extends Stack<E> {
    protected final int threshold;
    protected final List<Stack<E>> stacks = new ArrayList<>();

    public SetOfStacks(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public E push(E value) {
        Stack<E> last = this.getLastStack();
        if (last != null && last.size() < threshold) {
            return last.push(value);
        } else {
            last = new Stack<>();
            this.stacks.add(last);

            return last.push(value);
        }
    }

    @Override
    public E pop() {
        Stack<E> last = this.getLastStack();
        return last == null ? null : last.pop();
    }

    private Stack<E> getLastStack() {
        return this.stacks.isEmpty() ? null : this.stacks.get(this.stacks.size() - 1);
    }
}
