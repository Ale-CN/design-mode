package mythread.sync;

import mythread.util.MyThreadUtil;

/**
 * 钱包
 */
public class Wallet {
    // 余额
    private int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void addBalance(int money) {
        this.balance = this.balance + money;
    }

    public void testNewInstanceLock(){
        synchronized (new Object()){
            MyThreadUtil.printThreadInfo("testNewInstanceLock");
            MyThreadUtil.sleep(500);
        }
    }

    public void testInstanceLock() {
        synchronized (this) {
            MyThreadUtil.printThreadInfo("testClassLock");
            MyThreadUtil.sleep(500);
        }
    }

    public void testInstanceLock2() {
        synchronized (this) {
            System.out.println("testInstanceLock2");
            MyThreadUtil.printThreadInfo("testClassLock");
            MyThreadUtil.sleep(500);
        }
    }

    public void testClassLock() {
        synchronized (Wallet.class) {
            MyThreadUtil.printThreadInfo("testClassLock");
            MyThreadUtil.sleep(500);
        }
    }
}
