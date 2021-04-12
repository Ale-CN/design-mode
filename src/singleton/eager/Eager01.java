package singleton.eager;

/**
 * 最简单的饿汉模式
 */
public class Eager01 {
    private Eager01() {
    }

    private static final Eager01 EAGER = new Eager01();

    public static Eager01 getInstance() {
        return EAGER;
    }
}
