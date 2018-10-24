package com.mau.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.TreeSet;

public class MaxProductOfThree {

    class Solution {
        public int solution(int[] A) {

            TreeSet<Integer> set = new TreeSet<>();

            Arrays.sort(A);

//            for (int i = 0; i < A.length -2; i++) {
//
//                final int PVal = A[i];
//                final int QVal = A[i + 1];
//                final int RVal = A[i + 2];
//
//                set.add(PVal*QVal*RVal);
//            }

            int F = 0, L = A.length - 1;
            int s1 = A[F] * A[F + 1] * A[F + 2];
            int s2 = A[F] * A[F + 1] * A[L];
            int s3 = A[F] * A[L - 1] * A[L];
            int s4 = A[L - 2] * A[L - 1] * A[L];

            set.addAll(Arrays.asList(s1, s2, s3, s4));


            return set.last();
        }
    }

    @Test
    public void test_01() {
        Solution s = new Solution();
        Assertions.assertEquals(60, s.solution(new int[]{-3, 1, 2, -2, 5, 6}));
    }

}
