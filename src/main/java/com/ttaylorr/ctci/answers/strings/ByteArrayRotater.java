package com.ttaylorr.ctci.answers.strings;

import com.ttaylorr.ctci.meta.Solution;

@Solution(chapter = 1, problem = 6)
public class ByteArrayRotater {
    protected byte[][] arr;

    public ByteArrayRotater(byte[][] arr) {
        this.arr = arr;
    }

    /**
     * Mutates and returns a rotated byte array.
     *
     * @return The rotated byte array.
     */
    public byte[][] rotate() {
        // Keep track of the layer that we're on, incrementing our pointer by 1 each
        // time and only going through the first half of the array.
        for (int layer = 0; layer < this.arr.length / 2; layer++) {
            int first = layer;
            int last = this.arr.length - layer - 1;

            // Then determine the un-rotated elements in that array, and do a 4-way
            // shuffle through those elements.
            for (int i = first; i < last; i++) {
                int offset = i - first;
                byte top = this.arr[first][i];

                // Transform left -> top
                this.arr[first][i] = this.arr[last - offset][first];

                // Transform bottom -> left
                this.arr[last - offset][first] = this.arr[last][last - offset];

                // Transform right -> bottom
                this.arr[last][last - offset] = this.arr[i][last];

                // Transform top -> right
                this.arr[i][last] = top;
            }
        }

        return this.arr;
    }
}
