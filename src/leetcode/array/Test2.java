package leetcode.array;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(stair(5, new int[6]));
    }


    static int stair(int n, int[] cache) {

        if (n == 1) return 1;
        if (n == 2) return 2;

        if (cache[n] != 0) {
            return cache[n];
        }

        int a = stair(n - 1, cache);
        int b = stair(n - 2, cache);
        // 记忆优化，缓存到记忆集里
        cache[n] = a + b;

        return cache[n];
    }
}
