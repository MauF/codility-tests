package com.mau;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.

For example, in array A such that:

  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the elements at indexes 0 and 2 have value 9,
the elements at indexes 1 and 3 have value 3,
the elements at indexes 4 and 6 have value 9,
the element at index 5 has value 7 and is unpaired.
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.

For example, given array A such that:

  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the function should return 7, as explained in the example above.

Write an efficient algorithm for the following assumptions:

N is an odd integer within the range [1..1,000,000];
each element of array A is an integer within the range [1..1,000,000,000];
all but one of the values in A occur an even number of times.

 */
public class OddOccurencesInArray {

    class Solution {
        public int solution(int[] A) {
            Arrays.sort(A);
            int i, j, count = 0;
            for (i = 0; i < A.length; i++) {
                for (j = i + 1; j < A.length; j++) {
                    if (A[i] == A[j]) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (count % 2 == 0) {
                    return A[i];
                } else {
                    i = j - 1;
                    count = 0;
                }
            }

            return -1;

//            LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
//
//            for (int i = 0, last = i; i < A.length; i++, last = i) {
//                int n = A[i];
//                Integer counter = 0;
//                if (map.containsKey(n)) {
//                    counter = map.get(n);
//                    map.put(n, counter++);
//                }
//                map.put(n, counter);
//            }
//
//            final List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream().parallel().filter(e -> e.getValue() % 2 == 0).collect(Collectors.toList());
//
//            return collect.get(0).getKey();

        }
    }

    @Test
    public void test01() {
        Solution solution = new Solution();

        final int response = solution.solution(new int[]{9, 3, 9, 3, 9, 7, 9});

        assertEquals(7, response);
    }
}
