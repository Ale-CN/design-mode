package leetcode.array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i
 * 找出 A 中的坡的最大宽度，如果不存在，返回 0
 * 输入：[9,8,1,0,1,9,4,0,4,1]
 * 输出：7
 * 最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1
 * <p>
 * 链接：https://leetcode-cn.com/problems/maximum-width-ramp
 */
public class MaxWidthRamp {
    public static void main(String[] args) {
//        System.out.println(maxWidthRamp(new int[]{6,6}));
//        int[] ar = new int[]{8, 9, 0, 1, 1, 9, 4, 0, 4, 1};
        int[] ar = new int[]{8, 3, 9, 1, 0, 5, 3, 0, 1};
        // 0 1 2 3 4
        // ---------------------
        // 8,9,0,1,1,9,4,0,4,1
        // 2 7 3 4 9 6 8 0 1 5
        System.out.println(maxWidthRamp_t1(ar));
    }

    /**
     * 解法一：单调递减栈
     * 首先把A数组中的以A[0]开头的递减序列抽取出来，我们最后要求的最大的宽度坡一定是以这个序列中的某一个i为坡底的，我们反证一下
     * 假设存在某个元素位置k不存在于上面的递减序列中，且有最大宽度j-k，这也就说明k位置的元素一定是小于k前面所有的元素的，否则就会有更长的宽度，但是既然k小于前面所有的元素，那么k就一定会被加入到序列中，与假设矛盾，所以不存在k，解一定存在递减序列中
     * 这样的话我们可以逆向遍历数组，每次遇到元素大于栈顶的就可以计算宽度，然后将栈顶弹出，因为是逆序遍历的，所以这个宽度一定是栈顶这个坡底i能形成的最大宽度了， 逆序遍历再往前的话即使大于这个栈顶，形成的宽度也只会减小，所以这个栈顶是可以直接pop出去的，我们遍历所有的坡底求最大值就行了，时间复杂度O(N)
     * 作者：resolmi
     * 链接：https://leetcode-cn.com/problems/maximum-width-ramp/solution/java-dan-diao-zhan-er-fen-jie-fa-chang-shi-jie-shi/
     */
    public static int maxWidthRamp_t1(int[] A) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (stack.isEmpty() || A[stack.peek()] > A[i]) {
                stack.push(i);
            }
        }
        for (int i = A.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                int cur = stack.pop();
                res = Math.max(res, i - cur);
            }
        }
        return res;
    }

    public static int maxWidthRamp(int[] A) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] >= A[i]) {
                    if (j - i > max) {
                        max = j - i;
                    }
                }
            }
        }

        return max;
    }
}
