package mythread.sync;

import mythread.util.MyThreadUtil;

public class TestSynchronized {
    public static void main(String[] args) throws InterruptedException {
        testClassAndInstanceLock();
    }

    /**
     * 类锁和对象锁：由于【类对象】和【实例对象】分别拥有自己的监视器锁，因此【不会相互阻塞】
     * i.线程A访问实例对象的非static synchronized方法时，线程B也可以同时访问实例对象的static synchronized方法，
     * --因为前者获取的是实例对象的监视器锁，而后者获取的是类对象的监视器锁，两者不存在互斥关系。
     */
    public static void testClassAndInstanceLock() {
        Wallet wallet = new Wallet();
        Thread t1 = new Thread(() -> {
            int cycle = 0;
            while (cycle < 3) {
                cycle++;
                wallet.testInstanceLock();
            }
        });
        Thread t2 = new Thread(() -> {
            int cycle = 0;
            while (cycle < 3) {
                cycle++;
                wallet.testClassLock();
            }
        });
        t1.start();
        t2.start();

    }

    /**
     * 类锁：锁住的是类，即所有该类的实例，都互斥访问
     * 条件：synchrionized(A.class)、synchrionized修饰静态方法
     * <p>
     * 1.同一实例，互斥
     * 2.不同实例，互斥
     */
    public static void testClassLock() {
        Wallet wallet = new Wallet();
        Thread t1 = new Thread(() -> {
            int cycle = 0;
            while (cycle < 3) {
                cycle++;
                wallet.testClassLock();
            }
        });
        Thread t2 = new Thread(() -> {
            int cycle = 0;
            while (cycle < 3) {
                cycle++;
                wallet.testClassLock();
            }
        });
        t1.start();
        t2.start();

        MyThreadUtil.sleep(3500);
        System.out.println("2.不同实例，互斥");
        // 实例2
        Wallet wallet2 = new Wallet();

        Thread t3 = new Thread(() -> {
            int cycle = 0;
            while (cycle < 3) {
                cycle++;
                wallet.testClassLock();
            }
        });
        Thread t4 = new Thread(() -> {
            int cycle = 0;
            while (cycle < 3) {
                cycle++;
                wallet2.testClassLock();
            }
        });

        t3.start();
        t4.start();
    }

    /**
     * 对象锁：锁住的是对象实例，对象中所有synchrionized实例方法都互斥
     * i.如果一个线程正在访问实例对象的一个synchronized方法时，其它线程不仅不能访问该synchronized方法，
     * --该对象的其它synchronized方法也不能访问，因为一个对象只有一个监视器锁对象，但是其它线程可以访问该对象的非synchronized方法。
     * 条件：synchrionized(a)、synchrionized(this)、synchrionized修饰非静态方法
     * <p>
     * 1.同一实例，互斥
     * 2.不同实例，互不影响
     */
    public static void testInstanceLock() {
        Wallet wallet = new Wallet();
        Thread t1 = new Thread(() -> {
            int cycle = 0;
            while (cycle < 3) {
                cycle++;
                wallet.testInstanceLock();
            }
        });
        Thread t2 = new Thread(() -> {
            int cycle = 0;
            while (cycle < 3) {
                cycle++;
                wallet.testInstanceLock();
            }
        });
        t1.start();
        t2.start();

        MyThreadUtil.sleep(3500);
        System.out.println("2.不同实例，互不影响");
        // 实例2
        Wallet wallet2 = new Wallet();

        Thread t3 = new Thread(() -> {
            int cycle = 0;
            while (cycle < 3) {
                cycle++;
                wallet.testInstanceLock();
            }
        });
        Thread t4 = new Thread(() -> {
            int cycle = 0;
            while (cycle < 3) {
                cycle++;
                wallet2.testInstanceLock();
            }
        });

        t3.start();
        t4.start();
    }

    /**
     * 线程不安全
     *
     * @throws InterruptedException
     */
    public static void testUnSync() throws InterruptedException {

        Wallet wallet = new Wallet();

        Thread t1 = new Thread(() -> {
            int cycle = 0;
            while (cycle < 10000) {
                cycle++;
                wallet.addBalance(1);
            }
        });

        Thread t2 = new Thread(() -> {
            int cycle = 0;
            while (cycle < 10000) {
                cycle++;
                wallet.addBalance(1);
            }
        });

        t1.start();
        t2.start();

        Thread.sleep(100);

        System.out.println("wallet.balance = " + wallet.getBalance());

    }
}
