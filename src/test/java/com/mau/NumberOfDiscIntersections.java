package com.mau;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class NumberOfDiscIntersections {

    class Solution {
        public int solution(int[] A) {

            if(A.length == 0) {
                return 0;
            }

            Arrays.sort(A);

            int counter = 0;
            int i = 0;
            while (A[i] == 0) {
                i++;
                counter++;
            }

            counter += ((A.length - i) * 2);

            return counter > 10000000 ? -1 : counter;
        }
    }

    @Test
    public void test_01() {
        Solution s = new Solution();
        Assertions.assertEquals(11, s.solution(new int[]{1, 5, 2, 1, 4, 0}));
    }

}
