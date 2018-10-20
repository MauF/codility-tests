package com.mau;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Brackets {

    class Solution {

        public int solution(String S) {
            Stack<Character> leftBrackets = new Stack<Character>();
            for (int i = 0; i < S.length(); i++) {
                char ch = S.charAt(i);
                if (ch == ')' || ch == ']' || ch == '}') {
                    if (leftBrackets.empty()) {
                        return 0;
                    }
                    char top = leftBrackets.pop();
                    if ((ch == ')' && top != '(') || (ch == ']' && top != '[')
                            || (ch == '}' && top != '{')) {
                        return 0;
                    }
                } else {
                    leftBrackets.push(ch);
                }
            }
            return leftBrackets.empty() ? 1 : 0;
        }
    }

    @Test
    public void test_01() {
        Solution s = new Solution();
        Assertions.assertEquals(1, s.solution("{[()()]}"));
        Assertions.assertEquals(0, s.solution("([)()]"));
        Assertions.assertEquals(0, s.solution("([)()]}"));
        Assertions.assertEquals(1, s.solution(""));
    }

}
