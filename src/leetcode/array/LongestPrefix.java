package leetcode.array;

public class LongestPrefix {
    public static void main(String[] args) {
        String[] arr = new String[]{"flower", "flow", "flight"};
        String result = longest(arr);
        System.out.println(result);
    }

    static String longest(String[] arr) {

        String result = "";
        char[] chars = arr[0].toCharArray();
        boolean flag = true;

        for (int i = 0; i < chars.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (i >= arr[j].length())
                    break;
                if (chars[i] == arr[j].charAt(i)) {
                    continue;
                } else {
                    flag = false;
                }
            }
            if (flag)
                result += chars[i];
        }

        return result;
    }
}
