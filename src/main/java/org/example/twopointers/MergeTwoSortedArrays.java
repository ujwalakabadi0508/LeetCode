package org.example.twopointers;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] num1 = {1,3,5};
        int[] num2 = {2,4,6};

        System.out.println(Arrays.toString(mergeTwoSortedArrays(num1, num2)));
    }

    private static int[] mergeTwoSortedArrays(int[] num1, int[] nums2) {
        int[] res = new int[num1.length + nums2.length];
        int idx = 0;
        int i = 0, j = 0;

        while (i < num1.length && j < nums2.length){
            if (num1[i] < nums2[j]) {
                res[idx++] = num1[i++];
            } else {
                res[idx++] = nums2[j++];
            }
        }

        while (i < num1.length) {
            res[idx++] = num1[i++];
        }
        while (j < nums2.length) {
            res[idx++] = nums2[j++];
        }

        return res;
    }
}
