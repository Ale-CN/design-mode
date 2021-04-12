package leetcode.str;

public class DetectCapitalUse {
    public static void main(String[] args) {

        String[] arrays = {"aaaa", "BBBB", "Basgagas", "AAa", "asF", "aaaaaaaaaF", "AgagA"};
        for (String s : arrays)
            System.out.println(detectCapitalUse("AgagA"));
    }

    public static boolean detectCapitalUse(String word) {
        boolean firstUp = false;
        boolean up = false;
        boolean down = false;

        char[] chars = word.toCharArray();
        if (chars.length == 1)
            return true;
        if ('A' <= chars[0] && chars[0] <= 'Z') {
            firstUp = true;
        }
        for (int i = 1; i < chars.length; i++) {
            if (firstUp) {
                if ('a' <= chars[i] && chars[i] <= 'z') {
                    down = true;
                }
                if ('A' <= chars[i] && chars[i] <= 'Z') {
                    up = true;
                }
                return !(up && down);
            } else {
                if ('A' <= chars[i] && chars[i] <= 'Z') {
                    return false;
                } else {
                    down = true;
                }
            }
        }
        return true;
    }
}
