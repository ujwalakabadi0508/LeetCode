package org.example.twopointers;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(arr));
    }

    private static int removeDuplicates(int[] arr) {
        int unique = 1;
        int prev = 0;
        int nxt = 1;

        while (nxt < arr.length) {
            if (arr[nxt] == arr[prev]) {
                nxt++;
                continue;
            }
            arr[prev + 1] = arr[nxt];
            prev++;
            nxt++;
            unique++;
        }
        return unique;
    }
}
