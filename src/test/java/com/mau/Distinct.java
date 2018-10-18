package com.mau;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

public class Distinct {

    class Solution {
        public int solution(int[] A) {
            TreeSet<Integer> set = new TreeSet<>();

            for (int i = 0; i < A.length; i++) {
                set.add(A[i]);
            }

            return set.size();
        }
    }

    @Test
    public void test_01() {
        Solution s = new Solution();
        Assertions.assertEquals(3, s.solution(new int[]{2, 1, 1, 2, 3, 1}));
    }

}
