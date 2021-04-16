package pecs;

import java.util.List;

public class AnimalUtil<T> {

    /**
     * list 作为生产者，我们可以从 list 中消费 T
     *
     * @param list
     */
    public void get(List<? extends T> list) {
        for (T t : list) {
            System.out.println(t);
        }
    }

    /**
     * list 作为消费者，我们放入 T 到 list 中
     *
     * @param list
     */
    public void put(List<? super T> list, T t) {
        list.add(t);
    }

}
