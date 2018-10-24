package com.mau.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.SortedSet;
import java.util.TreeSet;

public class GenomicRangeQuery {

    class Solution {

        public int decode(char c) {
            switch (c) {
                case 'A':
                    return 1;
                case 'C':
                    return 2;
                case 'G':
                    return 3;
                case 'T':
                    return 4;
                default:
                    return -1;
            }
        }

        public int[] solution(String S, int[] P, int[] Q) {
            int[] result = new int[P.length];
            for (int i = 0; i < P.length; i++) {
                SortedSet<Integer> sorted = new TreeSet<>();
                int a = P[i];
                int b = Q[i];
                final String substring = S.substring(a, b + 1);
                final char[] chars = substring.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    final char aChar = chars[j];
                    final int decoded = decode(aChar);
                    sorted.add(decoded);
                }
                final Integer last = sorted.first();
                result[i] = last;
            }

            return result;
        }
    }

    @Test
    public void test_01() {
        Solution s = new Solution();
        Assertions.assertArrayEquals(new int[]{2, 4, 1}, s.solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}));
    }

}
