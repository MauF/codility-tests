package com.mau.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Socks {

    class Solution {
        public int solution(int K, int[] C, int[] D) {
            int[] s = new int[50];

            for (int i = 0; i < C.length; i++) {
                int val = C[i];
                if (s[val] == 0) {
                    s[val] = 1;
                } else {
                    s[val] = s[val] + 1;
                }
            }

            int counter = 0;

            ArrayList<Integer> colorToSeek = new ArrayList<>();

            for (int i = 1; i < s.length - 1; i++) {
                int val = s[i];
                if (val != 0) {
                    if (val % 2 == 0) {
                        counter += val / 2;
                        s[i] = 0;
                    } else {
                        colorToSeek.add(i);
                    }
                }
            }

            for (int i = 0; i < D.length; i++) {
                int val = D[i];
                boolean contains = colorToSeek.contains(Integer.valueOf(val));
                if (contains && K > 0) {
                    if (s[val] == 0) {
                        s[val] = 1;
                    } else {
                        s[val] = s[val] + 1;
                        if (s[val] % 2 == 0) {
                            counter += s[val] / 2;
                        }
                    }
                    K--;
                }
            }

            return counter;
        }

    }

    @Test
    public void test_01() {
        Solution s = new Solution();
        Assertions.assertEquals(3, s.solution(2, new int[]{1, 2, 1, 1}, new int[]{1, 4, 3, 2, 4}));
    }

}
