package com.mau;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinAvgTwoSlice {

    class Solution {

        public int[] prefixSum(int[] A, int start, int end) {

            final int length = (end - start) + 1;
            int[] result = new int[length];

            result[0] = A[start];

            for (int i = 1; i < length; i++) {
                result[i] = result[i - 1] + A[++start];
            }

            return result;
        }

        public int[] calculateAvg(int[] A, int P, int Q) {

            int avg = 0;

            for (int i = P; i < Q; i++) {

            }
            int valP = A[P];
            int valQ = A[Q];

            final int difference = P - Q;

            return null;
        }

        public int solution(int[] A) {
            return 0;
        }
    }

    @Test
    public void test_01() {
        Solution s = new Solution();
        Assertions.assertEquals(1, s.solution(new int[]{4, 2, 2, 5, 1, 5, 8}));
    }

    @Test
    public void test_02() {
        Solution s = new Solution();
        Assertions.assertArrayEquals(new int[]{10,14,30,50}, s.prefixSum(new int[]{10, 4, 16, 20}, 0, 3));
    }

}
