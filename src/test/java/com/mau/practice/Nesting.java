package com.mau.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Nesting {

    class Solution {
        public int solution(String S) {
            if (S.isEmpty()) {
                return 1;
            }

            if (!(S.contains("(") && S.contains(")"))) {
                return 0;
            }

            if (S.length() %2 != 0) {
                return 0;
            }

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                if (c == '(') {
                    stack.push(c);
                } else if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            return stack.isEmpty() ? 1 : 0;
        }
    }

    @Test
    public void test_01() {
        Solution s = new Solution();
        Assertions.assertEquals(1, s.solution("(()(())())"));
        Assertions.assertEquals(0, s.solution("())"));
        Assertions.assertEquals(1, s.solution(""));
        Assertions.assertEquals(0, s.solution("abhg"));
    }

}
