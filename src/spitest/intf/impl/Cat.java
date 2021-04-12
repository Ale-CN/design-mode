package spitest.intf.impl;

import spitest.intf.Animal;

public class Cat implements Animal {
    @Override
    public void sayHello() {
        System.out.println("I am a Cat! 喵喵");
    }
}
