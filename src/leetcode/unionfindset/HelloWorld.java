package leetcode.unionfindset;

import java.util.Arrays;

/**
 * 并查集
 * [0,1,2,3,4]
 * i.初始化时每个人的父亲都是自己
 * [0,3,3,3,4]
 * ii.1,2的父亲为3（判断是否为根节点arr[x] == x ? true : false）
 */
public class HelloWorld {

    public static void main(String[] args) {
        int[] arr = init(5);

        setParent(arr, 1, 3);
        setParent(arr, 2, 1);
        setParent(arr, 3, 0);

        System.out.println(Arrays.toString(arr));

        System.out.println("findP = " + findParent(arr, 1));
        System.out.println("findP = " + findParent(arr, 2));

    }

    static int[] init(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        return arr;
    }

    static void setParent(int[] arr, int x, int p) {
        if (x > arr.length || p > arr.length)
            throw new IllegalArgumentException("非法参数");

        while (arr[p] != p) {
            p = arr[p];
        }
        arr[x] = p;
    }

    static int findParent(int[] arr, int x) {
        if (x > arr.length)
            throw new IllegalArgumentException("非法参数");

        while (arr[x] != x) {
            x = arr[x];
        }
        return x;
    }
}
