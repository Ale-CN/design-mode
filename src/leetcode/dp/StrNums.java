package leetcode.dp;

/**
 * 一个由L、O、A组成的长度为30的字符串，
 * 不能出现连续3个或以上的A，最多出现一个L，有多少个这样的字符串？
 * 分析：很明显需要30步决策，每次决策时候要从3个字母里面选合法的，O任何情况都合法，L在没出现过的情况下合法，
 * A则在现有串最后不是AA时候合法，因此状态就是是否出现过L和最后两个字母中A的分布情况的一个组合，L是否出现有两个值，
 * A的分布有**，A*，*A，AA四种（*代表O或L，不用展开了），所以就是2*4=8种状态啦
 *
 * 链接：https://www.zhihu.com/question/39948290/answer/83942329
 */
public class StrNums {
    public static void main(String[] args) {

    }

    static int sum(){
        StringBuffer sb = new StringBuffer();


        return -1;
    }
}
