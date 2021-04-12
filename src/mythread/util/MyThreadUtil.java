package mythread.util;

import java.util.StringJoiner;

public class MyThreadUtil {

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印线程运行信息
     */
    public static void printThreadInfo(String tag) {
        System.out.println(getThreadInfo(tag));
    }

    public static String getThreadInfo(String tag) {
        return new StringJoiner("\t\t")
                .add(System.currentTimeMillis() + "")
                .add(Thread.currentThread().getId() + "")
                .add(Thread.currentThread().getName())
                .add(tag)
                .toString();
    }

}
