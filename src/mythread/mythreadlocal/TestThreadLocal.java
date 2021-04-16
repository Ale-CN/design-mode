package mythread.mythreadlocal;

public class TestThreadLocal {

    private static final ThreadLocal<String> LOCAL = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            LOCAL.set("1");
            System.out.println(LOCAL.get());
            LOCAL.remove();
        }).start();

        new Thread(() -> {
            LOCAL.set("2");
            System.out.println(LOCAL.get());
            LOCAL.remove();
        }).start();
    }

}
