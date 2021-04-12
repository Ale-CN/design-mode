package singleton.lazy;

/**
 * 使用枚举实现单例模式，还能防止通过反射破坏单例。
 *
 * 反射创建对象的源码中，当该类为ENUM时，直接抛出异常！！！保证了单例完整性
 * if ((clazz.getModifiers() & Modifier.ENUM) != 0)
 *      throw new IllegalArgumentException("Cannot reflectively create enum objects");
 */
public enum LazyByEnum {
    INSTANCE;

    void doSth() {
        System.out.println("这里就是单例的方法。");
    }
}
