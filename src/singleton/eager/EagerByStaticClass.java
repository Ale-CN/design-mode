package singleton.eager;

import java.io.Serializable;

/**
 * 饿汉模式：
 * 通过静态内部类实现，可以起到懒加载作用
 */
public class EagerByStaticClass implements Serializable {

    private EagerByStaticClass() {
        if(InnerClass.EAGER != null){
            throw new RuntimeException("单例构造器禁止反射破坏！");
        }
    }

    public static EagerByStaticClass getInstance() {
        return InnerClass.EAGER;
    }

    static class InnerClass {

        private static final EagerByStaticClass EAGER = new EagerByStaticClass();

    }

    protected EagerByStaticClass readResolve(){
        return getInstance();
    }
}
