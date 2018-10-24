package com.mau.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PassingCars {

    class Solution {
        public int solution(int[] A) {
            int countOne = 0;
            int pair = 0;
            int counter = 0;
            for (int i = 0; i < A.length; i++) {
                counter++;
                if (A[i] == 1) {
                    countOne++;
                    pair += counter - countOne;
                    if (pair > 1000000000) {
                        return -1;
                    }
                }
            }

            return pair;
        }
    }

    @Test
    public void test_01() {
        Solution s = new Solution();
        Assertions.assertEquals(5, s.solution(new int[]{0, 1, 0, 1, 1}));
    }
}
