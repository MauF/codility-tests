package com.mau.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.TreeMap;
import java.util.TreeSet;

public class MinAvgTwoSlice {

    class Solution {

        public int[] prefixSum(int[] A) {
            int[] ret = new int[A.length];
            ret[0] = A[0];
            for (int i = 1; i < A.length; i++) {
                ret[i] = ret[i - 1] + A[i];
            }
            return ret;
        }

        public int solution(int[] A) {
            //main idea: will find min average by checking only 2 and 3 contiguous elements at a time
            int sum1, sum2 = 0;
            double minAverage = Double.MAX_VALUE;
            double currentAverage1 = Double.MAX_VALUE;
            double currentAverage2 = Double.MAX_VALUE;
            int minAverageSliceIndex = 0; //for size 2 arrays, this will always be true

            //if array is > 2 elements
            for (int i = 0; i < A.length - 2; i++) {
                sum1 = A[i] + A[i + 1];
                currentAverage1 = sum1 / 2.0d;
                if (currentAverage1 < minAverage) {
                    minAverage = currentAverage1;
                    minAverageSliceIndex = i;
                }

                sum2 = sum1 + A[i + 2];
                currentAverage2 = sum2 / 3.0d;
                if (currentAverage2 < minAverage) {
                    minAverage = currentAverage2;
                    minAverageSliceIndex = i;
                }
            }

            //check last 2 contiguous elements from the end - they won't otherwise be checked because
            //when checking 2 and 3 contiguous elements at a time, will stop checking 3 elements from the end
            currentAverage1 = (A[A.length - 2] + A[A.length - 1]) / 2.0d;
            if (currentAverage1 < minAverage) {
                minAverage = currentAverage1;
                minAverageSliceIndex = A.length - 2;
            }

            return minAverageSliceIndex;
        }


    }

    @Test
    public void test_01() {
        Solution s = new Solution();
//        s.prefixSum(new int[]{10, 4, 16, 20});
        Assertions.assertEquals(1, s.solution(new int[]{4, 2, 2, 5, 1, 5, 8}));
    }

    @Test
    public void test_02() {
        Solution s = new Solution();
        Assertions.assertArrayEquals(new int[]{10, 14, 30, 50}, s.prefixSum(new int[]{10, 4, 16, 20}));
    }

}
