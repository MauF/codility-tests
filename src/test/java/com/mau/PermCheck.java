package com.mau;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PermCheck {

    class Solution {

        public int solution(int[] A) {

            Arrays.sort(A);

            for (int i = 0; i < A.length; i++) {
                if (A[i] != i + 1) {
                    return 0;
                }
            }

            return 1;
        }

    }

    @Test
    public void test_01() {
        Solution s = new Solution();

        final int solution = s.solution(new int[]{4,1,3,2});

        Assertions.assertEquals(1, solution);
        Assertions.assertEquals(0, s.solution(new int[]{4,1,3}));

    }

}
