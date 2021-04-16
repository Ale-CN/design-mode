package pecs;

import pecs.ext.Cat;
import pecs.ext.Lion;
import pecs.ext.Tiger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * PECS原则:生产者(Producer)使用 <? extends T>,消费者(Consumer)使用 <? super T>（这里的生产者和消费者是相对容器而言的）
 * - 从集合中取元素, 使用<? extends T>通配符——list 作为生产者，我们可以从 list 中消费 T
 *      -避免调用者向此容器内写入数据，只能读取里面的数据
 * - 向集合中放元素, 使用 <? super T> 通配符——list 作为消费者，我们可以放入 T 到 list 中
 *      -可以向此容器写入数据，读取时无法确定类型只能用 Object 接收
 */
public class PECS {
    public static void main(String[] args) {

        // 1.生产者，生产数据
        // 存入方式一：初始化赋值
        List<? extends Cat> cats = Arrays.asList(new Tiger("tiger-A")
                , new Tiger("tiger-B"), new Lion("Lion-A"));
        // 存入方式二：通过赋值为指定子类集合
        List<? extends Cat> catList;
        List<Lion> lions = Arrays.asList(new Lion("Lion-A"), new Lion("Lion-B"));
        cats = lions;

        // 取出时类型默认为T
        Cat cat = cats.get(0);


        // 2.消费者，接受数据
        List<? super Cat> objects = new ArrayList<>();

        // 可以添加 T的子类、T、T的父类
        objects.add(new Tiger("Tiger-1"));
        objects.add(new Lion("Lion-1"));
        objects.add(new Cat("Cat-1"));

        // 消费数据
        copy(objects, cats);

    }

    /**
     * 消费数据
     *
     * @param dest
     * @param src
     * @param <T>
     */
    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        if (src != null && src.size() > 0) {
            for (int i = 0; i < src.size(); i++) {
                dest.add(src.get(i));
            }
        }
    }
}
