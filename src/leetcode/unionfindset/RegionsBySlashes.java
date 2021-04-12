package leetcode.unionfindset;

public class RegionsBySlashes {
    public static void main(String[] args) {

        String str = "//\\";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

    }

    static int regionsBySlashes(String[] grid) {

        for (int i = 0; i < grid.length; i++) {
            String str = grid[i];
            char[] chars = str.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if("/".equals(chars[j])){

                }else if("\\".equals(chars[j])){

                }
            }

        }
        return 1;
    }

}
