package com.mau.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Fish {

    class Solution {
        public int solution(int[] A, int[] B) {
            Stack<Integer> stack = new Stack<>();

            for (int i = 0, j = 1; i < A.length && j < A.length; i++, j++) {

                int fsh = A[i];

                stack.push(A[i]);
            }

            return 0;
        }
    }

    @Test
    public void test_01() {
        Solution s = new Solution();
        Assertions.assertEquals(2, s.solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0}));
    }

}
