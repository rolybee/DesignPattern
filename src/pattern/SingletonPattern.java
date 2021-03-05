package pattern;

/**
 * 单例模式：确保一个类只有一个实例，而且自行实例化并向整个系统提供这个实例。
 * 构造方法为private
 * 应用：序列号生成器，web页面计数器
 */
public class SingletonPattern {
    public static void main(String[] args) {
        System.out.println();
    }
}

class Singleton {
    /**
     * 饿汉式
     */
//    private static Singleton singleton = new Singleton();
//    private Singleton(){};
//
//    public static Singleton getInstance() {
//        return singleton;
//    }
    /**
     * 懒汉式
     */
    private volatile static Singleton singleton;

    private Singleton() {
    }

    ;

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

/**
 * 实例化时间：
 * 饿汉式：类加载时就进行实例化
 * 懒汉式：在第一次使用时进行实例化
 * **双重检查锁：
 * <p>
 * singleton = new Singleton() 可以拆解为3步：
 * 1、分配内存，2、初始化对象，3、指向刚分配的地址，
 * 若发生重排序，假设 A 线程执行了1和3，还没有执行2，B线程来到判断 NULL，
 * B线程就会直接返回还没初始化的instance了。volatile 可以避免重排序。
 */
