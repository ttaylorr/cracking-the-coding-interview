package com.ttaylorr.ctci.answers.strings;

import com.ttaylorr.ctci.meta.Solution;

@Solution(chapter = 1, problem = 4)
public class AnagramTester {
    protected final String s1;
    protected final String s2;

    public AnagramTester(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public boolean areAnagrams() {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] count = new int[UniquenessTest.MAX_CHAR_SIZE];

        for (char c : s1.toCharArray()) count[(int) c]++;
        for (char c : s2.toCharArray()) count[(int) c]--;

        for (int i : count) {
            if (i != 0) return false;
        }

        return true;
    }
}
