package leetcode.array;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 */
public class Test {
    public static void main(String[] args) {
//        maxLength(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
//        maxLength(new int[]{4,10,4,3,8,9});
//        coin(null, 0);
        coinChange(new int[]{1,3}, 3);
    }


    static int maxLength(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        if (nums == null || nums.length == 0)
            return 0;
        if (nums != null && nums.length == 1)
            return 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] > nums[i - 1] ? dp[i - 1] + 1 : 1;
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
        return max;
    }

    static int ss(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }


    static int coin(int[] coins, int amount) {
        coins = new int[]{1, 2, 5, 7, 10};
        amount = 14;
        int[] dp = new int[amount + 1];
        // 初始化
        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        // 递推
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
                    if (dp[i] == -1 || dp[i] > dp[i - coins[j]] + 1) {
                        dp[i] = dp[i - coins[j]] + 1;
                    }
                }
            }
        }
        System.out.println(dp[amount]);
        return dp[amount];

    }

    static int[] memo;

    public static int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        memo = new int[amount + 1];

        return findWay(coins, amount);
    }

    // memo[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
    // findWay函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
    public static int findWay(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        // 记忆化的处理，memo[n]用赋予了值，就不用继续下面的循环
        // 直接的返回memo[n] 的最优值
        if (memo[amount] != 0) {
            return memo[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = findWay(coins, amount - coins[i]);
            if (res >= 0 && res < min) {
                min = res + 1; // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
            }
        }
        memo[amount] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount];

    }
}
