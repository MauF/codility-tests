package com.mau.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TennisTournament {

    class Solution {
        public int solution(int P, int C) {
            return P > C * 2 ? C : P / 2;
        }
    }

    @Test
    public void test_01() {
        Solution s = new Solution();
        Assertions.assertEquals(2, s.solution(5,3));
    }

    @Test
    public void test_02() {
        Solution s = new Solution();
        Assertions.assertEquals(3, s.solution(10,3));
    }

}
