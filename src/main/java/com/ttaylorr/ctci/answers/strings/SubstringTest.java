package com.ttaylorr.ctci.answers.strings;

import com.ttaylorr.ctci.meta.Solution;

@Solution(chapter = 1, problem = 8)
public class SubstringTest {
    public static SubstringTest of(String base) {
        return new SubstringTest(base);
    }

    protected final String base;
    protected SubstringTest(String base) {
        this.base = base;
    }

    public boolean isContainedWithin(String other) {
        return (this.base + this.base).contains(other);
    }

    // Example usage:
    // SubstringTest.of("foo").isContainedWithin("oofoof");
}
