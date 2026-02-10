package org.example.twopointers;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,7};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(arr, target)));

    }
    private static int[] twoSum(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == target) {
                return new int[]{start, end};
            }
            if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return new int[] {-1,-1};
    }
}
