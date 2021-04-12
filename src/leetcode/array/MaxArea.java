package leetcode.array;

public class MaxArea {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 4};
        System.out.println(maxArea(arr));
    }

    static int maxArea(int[] height) {
        int max = 0;
        int low = 0;
        for (int i = height.length - 1; i >= 0; ) {
            if (low == i)
                break;
            max = height[low] < height[i] ? Math.max(max, height[low++] * (i - low)) : Math.max(max, height[i--] * (i - low));
        }

        return max;
    }
}
