package com.ttaylorr.ctci.answers.stacks;

import com.ttaylorr.ctci.meta.Solution;

import java.util.Stack;

@Solution(chapter = 3, problem = 2)
public class StackWithMin {
    // Common sense would tell you to extend this class, but since we actually want to manipulate
    // the data-store with `Node`s, instead of raw E's, we'll compose it instead.
    protected final Stack<MinNode> stack;
    public StackWithMin() {
        this.stack = new Stack<>();
    }

    public int push(int num) {
        int min = Math.min(num, this.min());
        this.stack.push(new MinNode(num, min));

        return num;
    }

    public int min() {
        return this.stack.peek().min;
    }

    static class MinNode {
        public final int value;
        protected final int min;

        protected MinNode(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }
}
