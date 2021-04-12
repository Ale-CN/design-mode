package leetcode.dp;

/**
 * 经典的0-1背包问题
 * 我们从N个物品选若干塞到可以承受最大重量W的包包里面，要价值最大，因此就可以将任务分成N个步骤，每个步骤面对第i号物品，
 * 决策有两条：选，还是放弃，这里的状态，就是影响之后步骤决策的因素，在这里，就是“背包的剩余空间”
 * 比如，物品的重量是1,2,3,4,5,6，W=12，从头决策，0表示放弃，1表示选，BFS三次后有八种状态：
 * 000 剩12
 * 001 剩9
 * ……（略）
 * 110 剩9
 * ……（略）
 * 前三次步骤后，
 * 001和110到达了同样的状态，都是剩余可装重量9的东西，
 * 这样在剩下的决策中，这俩分支走的路都是一样的，
 * 跟你之前是选了001还是110没有任何关系（无后效性），
 * 因此只要看001价值大，还是110价值大就可以了，8个状态减少为7个，继续BFS下去，
 * 每一轮都合并同样状态，完成后，从最后一轮的所有状态中，找到价值最大的就ok了
 * <p>
 * 链接：https://www.zhihu.com/question/39948290/answer/83942329
 */
public class KnapSack01 {

    //记忆化搜索
    private static int[][] memo;

    public static void main(String[] args) {

        int[] w = {1, 2, 3, 4, 5, 6};// 重量
        int[] v = {10, 22, 33, 1, 5, 6};// 价值
        int n = 12;
        memo = new int[w.length][n + 1];
//        Set<String> set = new HashSet<>();
        System.out.println(solveKS(w, v, w.length - 1, n));
    }

    static int solveKS(int[] w, int[] v, int index, int capacity) {
        // 是、否
        if (index < 0 || capacity <= 0)
            return 0;

        //如果此子问题已经求解过，则直接返回上次求解的结果
        if (memo[index][capacity] != 0) {
            return memo[index][capacity];
        }

        // 不放入第 index 个物品
        int res = solveKS(w, v, index - 1, capacity);
        // 放入第 index 个物品
        if (w[index] <= capacity) {
            res = Math.max(res, v[index] + solveKS(w, v, index - 1, capacity - w[index]));
        }
        memo[index][capacity] = res;
        return res;
    }
}
