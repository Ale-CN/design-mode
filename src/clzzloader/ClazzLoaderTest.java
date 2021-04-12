package clzzloader;

import java.net.URL;

public class ClazzLoaderTest {

    public static void main(String[] args) {

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();// AppClassLoader
        ClassLoader parent = systemClassLoader.getParent();// ExtClassLoader
        ClassLoader pp = parent.getParent();// BootStrapClassLoader是C语言写的，所以获取不到

        System.out.println(systemClassLoader);
        System.out.println(parent);
        System.out.println(pp);

        URL url = ClassLoader.getSystemResource("META-INF/services/spitest.intf.Animal");
        System.out.println(url.getPath());


    }
}
