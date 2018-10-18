package com.mau;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

public class MinAvgTwoSlice {

    class Solution {

        public int[] prefixSum(int[] A) {

            final int length = A.length;
            int[] result = new int[length];

            result[0] = A[0];

            for (int i = 1; i < length; i++) {
                result[i] = result[i - 1] + A[i];
            }

            return result;
        }

        public int calculateAvg(int[] A, int P, int Q) {

            final int length = (Q - P) + 1;
            int[] partial = new int[length];

            for (int i = P; i < length; i++) {
                partial[i] = A[i];
            }

            int[] pSum = prefixSum(partial);

            int valP = pSum[P];
            int valQ = pSum[Q];

            final int difference = valP + valQ;

            return difference/length;
        }

        public int solution(int[] A) {

            TreeSet<Integer> set = new TreeSet<>();

            for (int i = 0; i < A.length; i++) {
                for (int j = i; j < A.length; j++) {
                    if(j == 0) {
                        continue;
                    }
                    final int avg = calculateAvg(A, i, j);
                    set.add(avg);
                }
            }

            return set.first();
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
        Assertions.assertArrayEquals(new int[]{10,14,30,50}, s.prefixSum(new int[]{10, 4, 16, 20}));
    }

}
