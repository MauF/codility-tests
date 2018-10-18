package com.mau;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class CountDiv {

    class Solution {
        public int solution(int A, int B, int K) {
            return (B/K) - (A/K) + (A%K == 0 ? 1 : 0);
//            if(K > B) {
//                return 0;
//            }
//
//            if(K == B) {
//                return 1;
//            }
//
//            int count = A;
//
//            if(K >= count) {
//                count = K;
//            }
//
//            HashSet<Integer> hashSet = new HashSet<>();
//            while(count <= B) {
//                if(count % K == 0) {
//                    hashSet.add(count);
//                }
//                count++;
//            }
//
//            return hashSet.size();
        }
    }

    @Test
    public void test_01() {
        Solution s = new Solution();
        Assertions.assertEquals(3, s.solution(6,11,2));
    }

    public static void main(String[] args) {
        String aa = "test1.txt";


        final boolean matches = aa.matches(Pattern.compile(".*.txt").pattern());

        System.out.println();
    }

}
