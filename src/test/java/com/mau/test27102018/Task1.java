package com.mau.test27102018;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task1 {

    class Solution {

        public int follow(int[] A, int index, int head) {
            int a = A[index];
            if(a == 0) {
                System.out.print(a);
                return 1;
            }
            if (a == head) {
                System.out.print(a);
                return 1;
            }
            if (a == index) {
                System.out.print(a);
                return 1;
            }
            System.out.print(a +" ->");
            return 1 + follow(A, a, head);
        }

        public int solution(int[] A) {
            int max = 0;

            for (int i = 0; i < A.length; i++) {
                int counter = follow(A, i, i);
                if(counter > max) {
                    max = counter;
                }
                System.out.println();
            }

            return max;
        }
    }

    @Test
    public void test_01() {
        Solution s = new Solution();
        Assertions.assertEquals(4, s.solution(new int[]{5, 4, 0, 3, 1, 6, 2}));
    }

}
