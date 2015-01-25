package com.ttaylorr.ctci.answers.graphs;

import com.ttaylorr.ctci.answers.graphs.utils.Graph;
import com.ttaylorr.ctci.meta.Solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@Solution(chapter = 4, problem = 2)
public class PathFinder<E> {
    protected final Graph<E> graph;

    public PathFinder(Graph<E> g) {
        this.graph = g;
    }

    public boolean existsPath(Graph.Node start, Graph.Node end) {
        Map<Graph.Node, State> states = new HashMap<>();

        Stack<Graph.Node<E>> stack = new Stack<>();
        stack.add(start);

        while (!stack.isEmpty()) {
            Graph.Node<E> current = stack.pop();
            if (current != null) {
                for (Graph.Node<E> sibbling : current.getAdjacent()) {
                    if (states.get(sibbling) != State.NotVisited) {
                        if (sibbling == end) {
                            return true;
                        } else {
                            states.put(sibbling, State.Visited);
                            stack.push(sibbling);
                        }
                    }
                }
            }
        }

        return false;
    }

    public static enum State {
        Visited, NotVisited;
    }
}
