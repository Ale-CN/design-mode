package pecs;

import pecs.ext.Animal;
import pecs.ext.Cat;
import pecs.ext.Lion;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        AnimalUtil<Animal> util = new AnimalUtil<>();

        List<Cat> list = new ArrayList<>();
        list.add(new Cat("1"));
        list.add(new Cat("2"));

        util.get(list);

        //
        List<? super Animal> slist = new ArrayList<>();
        util.put(slist,new Lion("lion-1"));

        // 只能用 Object 接收
        Object object = slist.get(0);
        System.out.println(slist.get(0));


    }
}
