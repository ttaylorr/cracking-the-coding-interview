package com.ttaylorr.ctci.answers.strings;

import com.ttaylorr.ctci.meta.Solution;

@Solution(chapter = 1, problem = 1)
public class UniquenessTest {
    public static final int MAX_CHAR_SIZE = 128;
    protected final String str;

    public UniquenessTest(String str) {
        this.str = str;
    }

    public boolean isUnique() {
        if (this.str.length() < 2) return true;

        int[] count = new int[MAX_CHAR_SIZE];
        for (char c : this.str.toCharArray()) {
            if (count[(int) c]++ > 1) return false;
        }

        return true;
    }
}
