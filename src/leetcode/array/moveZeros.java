package leetcode.array;

import java.util.Arrays;

public class moveZeros {
    public static void main(String[] args) {


//        int[] nums = {1, 3, 0, 4, 0, 0, 6, 9};
        int[] nums = {0, 3, 0, 4, 0, 0, 6, 0};

        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                if (j > i) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
                i++;
            }
            j++;
        }

        System.out.println(Arrays.toString(nums));

    }
}
