package com.ttaylorr.ctci.answers.chapter_1;

import com.ttaylorr.ctci.meta.Solution;

@Solution(chapter = 1, problem = 2)
public class StringReverser {
    protected final String str;

    public StringReverser(String str) {
        this.str = str;
    }

    public String reverse() {
        char[] chars = this.str.toCharArray();
        // Since this is a "C-style" string, it has a null-terminator, which isn't counted here
        int length = chars.length - 1;

        for (int i = 0; i < length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[length - i];
            chars[length - i] = temp;
        }

        return new String(chars);
    }
}
