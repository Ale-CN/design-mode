package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 7, 9};
        int key = 8;
        System.out.println(Arrays.toString(solution(nums, key)));
    }

    public static int[] solution(int[] nums, int key) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(key - nums[i])) {// 1 2 4 5 7 9  7 6 4 3 1
                return new int[]{map.get(key - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
