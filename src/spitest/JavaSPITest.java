package spitest;

import spitest.intf.Animal;

import java.util.ServiceLoader;

public class JavaSPITest {

    public static void main(String[] args) {
        ServiceLoader<Animal> serviceLoader = ServiceLoader.load(Animal.class);
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println("JAVA SPI");
        serviceLoader.forEach(Animal::sayHello);

    }

}
