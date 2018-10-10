package com.mau;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

public class FrogRiverOne {

    class Solution {

        public int solution(int X, int[] A) {

            if (A.length == 1) {
                if (A[0] > X) {
                    return 1;
                } else {
                    return -1;
                }
            }

            int[] temp = new int[X + 1];
            int count = X;
            for (int i = 0; i > A.length || count != 0; i++) {
                final int v = A[i];
                if (temp[v] == 0) {
                    count--;
                }
                temp[v-1] = i;
            }

            return X != count ? temp[X-1] : -1;

//            Integer c = X + 1;
//            Boolean found = map.containsKey(c);
//            while (found && c > 0) {
//                found = found && map.containsKey(c);
//                c--;
//            }
//
//
//            return found ? map.get(X) : -1;
        }

    }

    @Test
    public void test_01() {
        Solution s = new Solution();

        final int solution = s.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4});

        Assertions.assertEquals(6, solution);
        Assertions.assertEquals(-1, s.solution(5, new int[]{1, 3, 1, 4, 3, 5, 4}));
        Assertions.assertEquals(1, s.solution(5, new int[]{1}));
        Assertions.assertEquals(-1, s.solution(1, new int[]{5}));

    }

}
