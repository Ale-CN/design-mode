package spitest.intf.impl;

import spitest.intf.Animal;

public class Dog implements Animal {
    @Override
    public void sayHello() {
        System.out.println("I am a Dog! 汪汪");
    }
}
