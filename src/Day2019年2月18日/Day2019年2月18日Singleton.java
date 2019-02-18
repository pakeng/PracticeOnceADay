package Day2019年2月18日;

/**
 *  @author: Vito
 *  @Email: dai625125312@gmail.com
 *  @Date: 2019/2/18 12:40
 *  @Description:  几种单例的写法
 */
public class Day2019年2月18日Singleton {
    /**
     * 单例模式，懒汉式，线程安全
     * 当类加载的时候创建实例
     */
    public static class Singleton{
        private final static Singleton INSTANCE = new Singleton();
        private Singleton(){}
        public static Singleton getInstance(){
            return INSTANCE;
        }
    }

    /**
     *  单例模式， 饿汉式， 线程安全
     *  因为使用了同步锁， 多线程下效率不高
     *  用时创建实例
     */
    public static class Singleton1{
        private static Singleton1 INSTANCE = null;
        private Singleton1(){}

        public static synchronized Singleton1 getInstance() {
            if (INSTANCE == null) {
                INSTANCE = new Singleton1();
            }
            return INSTANCE;
        }
    }

    /**
     * 单例模式，饿汉式， 线程不安全
     * 多线程同时获取INSTANCE的时候 INSTANCE == null导致多次进入 new Singleton2 创建多个实例
     */
    public static class Singleton2{
        private static Singleton2 INSTANCE = null;
        private Singleton2(){}
        public static Singleton2 getInstance(){
            if (INSTANCE==null){
                INSTANCE = new Singleton2();
            }
            return INSTANCE;
        }
    }

    /**
     * 静态内部类，使用双重校验锁，线程安全
     */
    public static class Singleton3 {
        private volatile static Singleton3 INSTANCE = null;
        private Singleton3() {
        }
        public static Singleton3 getInstance() {
            if (INSTANCE == null) {
                synchronized (Singleton3.class) {
                    if (INSTANCE == null) {
                        INSTANCE = new Singleton3();
                    }
                }
            }
            return INSTANCE;
        }
    }

    /**
     * 单例模式，懒汉式，变种，线程安全
     * 同第一个写法
     */
    public static class Singleton4 {
        private static Singleton4 INSTANCE = null;
        static {
            INSTANCE = new Singleton4();
        }
        private Singleton4() {
        }
        public static Singleton4 getInstance() {
            return INSTANCE;
        }

    }

    /**
     * 单例模式，使用静态内部类，线程安全 ☆☆☆
     */
    public static class Singleton5 {
        private final static class SingletonHolder {
            private static final Singleton5 INSTANCE = new Singleton5();
        }
        private Singleton5() {
        }
        public static Singleton5 getInstance() {
            return SingletonHolder.INSTANCE;
        }
    }

    /**
     * 静态内部类，使用枚举方式，线程安全  ☆☆☆
     */
    public enum Singleton6 {
        INSTANCE;
        public void someMethod() {
        }
    }

}
