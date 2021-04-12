package leetcode.array;

public class BestSell {
    public static void main(String[] args) {
        int[] arr = {2, 200, 1, 3, 99, 7, 8};
        System.out.println(sell(arr));
        System.out.println("dpWay = " + dpWay(arr));
    }

    static int dpWay(int[] arr) {
        if(arr == null || arr.length == 0)
            return 0;

        int[][] dp = new int[arr.length][2];
        dp[0][0] = 0;
        dp[0][1] = -arr[0];

        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
        }

        return dp[arr.length - 1][0];
    }

    static int sell(int[] arr) {
        // 2, 200, 1, 3, 99, 7, 8 -> 198
        int min = arr[0];
        int result = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else {
                result = Math.max(result, arr[i] - min);
            }
        }
        return result;
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        //{2, 200, 1, 3, 99, 7, 8};
        int profit0 = 0, profit1 = -prices[0];
        int length = prices.length;
        for (int i = 1; i < length; i++) {
            profit0 = Math.max(profit0, profit1 + prices[i]);
            profit1 = Math.max(profit1, -prices[i]);
        }
        return profit0;
    }

}
