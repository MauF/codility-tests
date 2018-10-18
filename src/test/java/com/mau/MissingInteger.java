package com.mau;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class MissingInteger {

    class Solution {

        public int solution(int[] A) {
            Arrays.sort(A);

            HashSet<Integer> set = new HashSet<>(Arrays.stream(A).boxed().collect(Collectors.toList()));

            int solution = 1;

            for (Integer val : set) {
                if (val <= 0) {
                    continue;
                }

                if (val == solution) {
                    solution++;
                } else {
                    break;
                }
            }

            return solution;
        }

    }

    @Test
    public void test_01() {
        Solution s = new Solution();

        final int solution = s.solution(new int[]{1, 3, 6, 4, 1, 2});

        Assertions.assertEquals(5, solution);

    }

    @Test
    public void test_02() {
        Solution s = new Solution();

        Assertions.assertEquals(1, s.solution(new int[]{-1, -3}));


    }

    @Test
    public void test_03() {
        Solution s = new Solution();
        new ArrayList();
        Assertions.assertEquals(4, s.solution(new int[]{1, 2, 3}));

    }

}
