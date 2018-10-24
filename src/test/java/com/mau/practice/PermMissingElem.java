package com.mau.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PermMissingElem {

    class Solution {
        public int solution(int[] A) {

            if (A.length == 0) {
                return 1;
            }

            if (A.length == 1) {
                return A[0] - 1;
            }

            Arrays.sort(A);

            int i = 0;

            for (i = 0; i < A.length; i++) {
                if (A[i] != i + 1) {
                    return i + 1;
                }
            }

            return i + 1;

        }
    }

    @Test
    public void test_01() {
        Solution s = new Solution();

        final int solution = s.solution(new int[]{2, 3, 1, 5});

        Assertions.assertEquals(4, solution);

    }

}
