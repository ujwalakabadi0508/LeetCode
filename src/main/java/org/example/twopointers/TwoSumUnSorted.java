package org.example.twopointers;

import java.util.Arrays;

public class TwoSumUnSorted {
    public static void main(String[] args) {
        int[] nums = {7,1,5,3,2};
        // i = 7 j = 1 >> T >> // j = 5; i = 7 >> T // i = 7 j 3 >> T // i == 7 j 2
        // {1, 5, 3, 2, 7}
        sortArray(nums);

        System.out.println(Arrays.toString(twoSumUnSorted(nums, 9)));
    }

    private static int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }
    private static int[] twoSumUnSorted(int[] arr, int target) {
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
