package com.mau;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ASample {

    class Solution {
        public int solution(int[] A) {
            return 0;
        }
    }

    @Test
    public void test_01() {
        Solution s = new Solution();
        Assertions.assertEquals(4, s.solution(new int[]{}));
    }

}
