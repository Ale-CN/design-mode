package singleton;

import singleton.eager.EagerByStaticClass;
import singleton.lazy.LazyByEnum;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

//        beakEagerByStaticClass();


    }

    /**
     * 尝试破坏枚举单例
     */
    static void beakEnum() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        LazyByEnum lazyByEnum01 = LazyByEnum.INSTANCE;

        Class clz = Class.forName("singleton.lazy.LazyByEnum");
        // 枚举类没有无参构造方法，对应的构造方法是（String,int）
        // 实际上一个类声明为enum时会默认继承 Enum 抽象类，其构造方法 protected Enum(String name, int ordinal)
//        Constructor declaredConstructor = clz.getDeclaredConstructor();
        Constructor declaredConstructor = clz.getDeclaredConstructor(String.class, int.class);
        // 将private构造方法设置为可访问
        declaredConstructor.setAccessible(true);
        // 报错：Cannot reflectively create enum objects
        LazyByEnum lazyByEnum = (LazyByEnum) declaredConstructor.newInstance();

        System.out.println(lazyByEnum01);
        System.out.println(lazyByEnum);

    }

    static void beakEagerByStaticClass() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EagerByStaticClass eagerByStaticClass01 = EagerByStaticClass.getInstance();

        Class clz = Class.forName("singleton.eager.EagerByStaticClass");
        // 将private构造方法设置为可访问
        Constructor declaredConstructor = clz.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        EagerByStaticClass eagerByStaticClass = (EagerByStaticClass) declaredConstructor.newInstance();

        System.out.println(eagerByStaticClass01);
        System.out.println(eagerByStaticClass);
    }


}
