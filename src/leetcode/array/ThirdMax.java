package leetcode.array;

import java.util.TreeSet;

public class ThirdMax {

    /**
     * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
     */
    public static void main(String[] args) {
//        int[] nums = {2, 1, 3}; // 1
//        int[] nums = {2,1}; // 2
//        int[] nums = {2, 2, 1, 3}; // 1
        int[] nums = {-2147483648, 1, 2, -2147483648};
        System.out.println(thirdMax(nums));
        ;
    }

    static int solution(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            treeSet.add(num);
            if (treeSet.size() > 3)
                treeSet.remove(treeSet.first()); // 元素个数>3时，移除最小的元素
        }
        return treeSet.size() < 3 ? treeSet.last() : treeSet.first();   // set.last() 里面最大的元素
    }


    public static int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        boolean flag = true;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            // 兼容Integer.MIN_VALUE
            if (nums[i] == Integer.MIN_VALUE && flag) {
                count++;
                flag = false;
            }
            if (nums[i] > max1) {
                count++;
                //原先第二大传递给第三大
                max3 = max2;
                //原先最大值传递给第二大
                max2 = max1;
                //更新最大值
                max1 = nums[i];
            } else if (nums[i] > max2 && nums[i] < max1) {
                count++;
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] > max3 && nums[i] < max2) {
                count++;
                max3 = nums[i];
            }
        }
        return count >= 3 ? max3 : max1;
    }

}
