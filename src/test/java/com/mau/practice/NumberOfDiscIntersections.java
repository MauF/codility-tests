package com.mau.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class NumberOfDiscIntersections {

    class Solution {

        // 81%
         /*
         1. Simple solution, treat it as a math problem. The only situation that two disks don't intersect is : right-A[right]>i+A[i]
    However, n(n-1)/2 may cause arithmetic overflow of integer and the O(n*n)performance is bad. Use long instead.
    */
        public int solution(int[] A) {
            // write your code in Java SE 8
            int n = A.length;
            int sum = 0;

            long total = (long) n * (n - 1) / 2;
            for (int i = 0; i < n; i++) {
                for (int right = i + 1; right < n; right++) {
                    if (right - A[i] - i > A[right]) { //right>A[i]+i+A[right] will cause overflow
                        sum++;
                    }
                }
            }

            if ((total - sum) > 10000000) {
                return -1;
            }
            return (int) (total - sum);

        }

        /*2. Time complexity is O(N*log(N)) or O(N).
The largest value of right-A[right] is n-1. We just need to find right-A[right]>0 and how many i+A[i] is smaller than it.*/
        public int solution2(int[] A) {
            int n = A.length;
            int[] sum = new int[n];

            for (int i = 0; i < n; i++) {
                int right;
                //if i+A[i]<= n-1, that's it, extract this i+A[i], let sum[i+A[i]]++, means there is one disk that i+A[i]
                if (n - i - 1 >= A[i]){
                    right = i + A[i];
                } else {
                    right = n - 1;
                }

                sum[right]++;
            }

            for (int i = 1; i < n; i++) {
                sum[i] += sum[i - 1];  //sum[i] means that there are sum[i] number of values that <= i;
            }

            long ans = (long) n * (n - 1) / 2;

            for (int i = 0; i < n; i++) {
                int left;

                if (A[i] > i) {
                    left = 0;
                } else {
                    left = i - A[i];// Find the positive i-A[i].
                }

                if (left > 0){
                    ans -= sum[left - 1];//Find the number that is smaller than 1-A[i], sum[n-1] will never be used as we only need sum[n-1-1] at most.
                }
            }

            if (ans > 10000000) {
                return -1;
            }

            return (int) ans;
        }

    }

    @Test
    public void test_01() {
        Solution s = new Solution();
        Assertions.assertEquals(11, s.solution(new int[]{1, 5, 2, 1, 4, 0}));
        Assertions.assertEquals(11, s.solution2(new int[]{1, 5, 2, 1, 4, 0}));
    }

}
