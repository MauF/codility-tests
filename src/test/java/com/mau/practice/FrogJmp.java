package com.mau.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FrogJmp {

    class Solution {
        public int solution(int X, int Y, int D) {
            return (int) Math.ceil((float)(Y-X)/D);
        }
    }

    @Test
    public void test_01() {
        Solution s = new Solution();

        final int solution = s.solution(10, 85, 30);

        Assertions.assertEquals(3, solution);
        Assertions.assertEquals(4, s.solution(1, 5, 1));
    }

}
