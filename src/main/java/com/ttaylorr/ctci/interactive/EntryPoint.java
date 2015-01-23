package com.ttaylorr.ctci.interactive;

import java.util.List;

public class EntryPoint {
    public static void main(String[] args) {
        NamespaceLoader ns = new NamespaceLoader("com.ttaylorr.ctci.answers");
        List<Class<?>> answers = ns.load();

        // Eventually I will do something interesting here!
    }
}
