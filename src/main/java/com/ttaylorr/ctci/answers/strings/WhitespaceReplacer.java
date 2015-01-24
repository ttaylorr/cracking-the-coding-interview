package com.ttaylorr.ctci.answers.strings;

import com.ttaylorr.ctci.meta.Solution;

@Solution(chapter = 1, problem = 5)
public class WhitespaceReplacer {
    protected final String str;

    public WhitespaceReplacer(String str) {
        this.str = str;
    }

    public String asReplacedWhitespace() {
        char[] chars = this.str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                char[] temp = new char[chars.length+3-1];

                System.arraycopy(chars, 0, temp, 0, i - 1);

                temp[i] = '%';
                temp[i+1] = '2';
                temp[i+2] = '0';

                System.arraycopy(chars, i+1, temp, i+3, temp.length - 3);

                chars = temp;
                i+=2;
            }
        }

        return new String(chars);
    }
}
