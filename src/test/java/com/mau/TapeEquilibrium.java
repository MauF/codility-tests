package com.mau;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TapeEquilibrium {

    class Solution {

        public int solution(int[] A) {

            Integer totSum = 0;

            for (int i = 0; i < A.length; i++) {
                totSum += A[i];
            }

            int min = 0;
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < A.length; i++) {
                final int elem = A[i];
                sum1 += elem;
                sum2 = totSum - sum1;
                final int abs = Math.abs(sum1 - sum2);
                min = i == 0 ? abs : Math.min(abs, min);
            }


            return min;

        }

    }

    @Test
    public void test_01() {
        Solution s = new Solution();

        final int solution = s.solution(new int[]{3, 1, 2, 4, 3});

        Assertions.assertEquals(1, solution);
        Assertions.assertEquals(0, s.solution(new int[]{2}));


    }

}
