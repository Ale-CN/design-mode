package singleton.lazy;

/**
 * 懒汉模式：
 * 使用双重校验锁机制，防止多线程初始化破坏单例模式。
 */
public class LazyByDoubleCheck {

    private LazyByDoubleCheck() {
    }

    /**
     * volatile防止指令重排序
     */
    private static volatile LazyByDoubleCheck lazy;

    public static LazyByDoubleCheck getInstance() {
        if (lazy == null) {
            synchronized (LazyByDoubleCheck.class) {
                if (lazy == null) {
                    lazy = new LazyByDoubleCheck();
                }
            }
        }
        return lazy;
    }

}
