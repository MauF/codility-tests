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

        final int solution = s.solution(new int[]{});

        Assertions.assertEquals(4, solution);

    }

}
