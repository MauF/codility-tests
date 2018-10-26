package com.mau.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxDoubleSliceSum {

    class Solution {

        // kadane's algorithm
        public int solution(int[] A) {
            int N = A.length;
            int[] K1 = new int[N];
            int[] K2 = new int[N];

            for (int i = 1; i < N - 1; i++) {
                K1[i] = Math.max(K1[i - 1] + A[i], 0);
            }
            for (int i = N - 2; i > 0; i--) {
                K2[i] = Math.max(K2[i + 1] + A[i], 0);
            }

            int max = 0;

            for (int i = 1; i < N - 1; i++) {
                max = Math.max(max, K1[i - 1] + K2[i + 1]);
            }

            return max;
        }
    }

    @Test
    public void test_01() {
        Solution s = new Solution();
        Assertions.assertEquals(17, s.solution(new int[]{3, 2, 6, -1, 4, 5, -1, 2}));
    }

}
