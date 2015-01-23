package com.ttaylorr.ctci.answers.chapter_1;

public class StringAnagramTester {
    protected final String s1;
    protected final String s2;

    public StringAnagramTester(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public boolean areAnagrams() {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] count = new int[StringUniquenessTest.MAX_CHAR_SIZE];

        for (char c : s1.toCharArray()) count[(int) c]++;
        for (char c : s2.toCharArray()) count[(int) c]--;

        for (int i : count) {
            if (i != 0) return false;
        }

        return true;
    }
}
