package org.example.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SquareOfSortedArray {
    public static void main(String[] args) {
        int[] nums = {-4,-2,-1,3,5};
//        System.out.println(Arrays.toString(squareOfSortedArray(nums)));
        System.out.println(Arrays.toString(squareOfSortedArrayOptimised(nums)));

    }
    private static int[] squareOfSortedArray(int[] nums) {
        if (nums.length == 0) {
            return new int[]{-1,-1};
        }

        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();


        for (int num: nums) {
            if (num > 0) {
                positive.add(num * num);
            } else {
                negative.add(num * num);
            }
        }

        if (negative.isEmpty()) {
            return positive.stream().mapToInt(i-> i).toArray();
        }

        Collections.reverse(negative);
        if (positive.isEmpty()) {
            return negative.stream().mapToInt(i->i).toArray();
        }

        //Merge
        int i = 0;
        int j = 0;
        int[] arr = new int[nums.length];
        int idx = 0;
        while (i < positive.size() && j < negative.size()) {
            if (positive.get(i) < negative.get(j)) {
                arr[idx++] = positive.get(i++);
            } else {
                arr[idx++] = negative.get(j++);
            }
        }
        while (i < positive.size()) {
            arr[idx++] = positive.get(i++);
        }
        while (j < negative.size()) {
            arr[idx++] = negative.get(j++);
        }
        return arr;
    }

    private static int[] squareOfSortedArrayOptimised(int nums[]) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;


        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[i] = nums[left] * nums[left];
                left++;
            } else {
                res[i] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }
}
