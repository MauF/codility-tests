package com.mau.test27102018;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task2 {

    class Solution {

        public static final String UP = "up";
        public static final String DOWN = "down";
        public static final String SAME = "same";

        public String detectDirection(int p1, int p2) {
            if (p1 > p2) {
                return DOWN;
            }
            if (p1 < p2) {
                return UP;
            }
            if (p1 == p2) {
                return SAME;
            }
            return "impossible";
        }

        public int eval(int[] A, int start, int end, String previous, int counter) {
            if (end == A.length) {
                String dir = detectDirection(A[A.length - 2], A[A.length - 1]);
                switch (previous) {
                    case SAME:
                        return counter + 1;
                    case UP:
                        if (dir.equals(DOWN)) {
                            return counter;
                        } else {
                            return counter + 2;
                        }
                    case DOWN:
                        if (dir.equals(UP)) {
                            return counter;
                        } else {
                            return counter + 2;
                        }
                }
            }
            String dir = detectDirection(A[start], A[end]);
            switch (previous) {
                case SAME:
                    return counter + 1;
                case UP:
                    if (dir.equals(DOWN)) {
                        counter++;
                    } else {
                        return counter + 1;
                    }
                    break;
                case DOWN:
                    if (dir.equals(UP)) {
                        counter++;
                    } else {
                        return counter + 1;
                    }
                    break;
            }
            return eval(A, start + 1, end + 1, dir, counter);
        }

        public int solution(int[] A) {
            for (int i = 0; i < A.length; i++) {
                System.out.print(A[i] + " ");
            }

            System.out.println();

            if (A.length == 1) {
                return 1;
            }

            if (A.length == 2) {
                if (A[0] > A[1] || A[0] < A[1]) {
                    return 1;
                }
            }

            int counter = 1;
            int max = 0;

            int index = 0;
            while (index < A.length - 1) {
                counter = eval(A, index, index + 1, index == 0 ? detectDirection(A[index], A[index + 1]) : detectDirection(A[index - 1], A[index]), counter);
                index += counter;
                if (counter > max) {
                    max = counter;
                    counter = 1;
                }
            }

            return max;
        }
    }

    @Test
    public void test_00() {
        Solution s = new Solution();
        Assertions.assertEquals(2, s.solution(new int[]{4, 8, 12, 16}));
    }

    @Test
    public void test_01() {
        Solution s = new Solution();
        Assertions.assertEquals(5, s.solution(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}));
    }

    @Test
    public void test_02() {
        Solution s = new Solution();
        Assertions.assertEquals(1, s.solution(new int[]{100}));
    }

    @Test
    public void test_03() {
        Solution s = new Solution();

        int[] input = new int[100];

        for (int i = 0; i < input.length - 1; i += 2) {
            input[i] = 50;
            input[i + 1] = 150;
        }

        Assertions.assertEquals(100, s.solution(input));
    }

    @Test
    public void test_04() {
        Solution s = new Solution();

        int[] input = new int[100];

        for (int i = 0; i < input.length - 1; i += 2) {
            input[i] = 150;
            input[i + 1] = 50;
        }

        Assertions.assertEquals(100, s.solution(input));
    }

    //228.14

}
