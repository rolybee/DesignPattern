package pattern;

/**
 * 代理模式：为其他对象提供一种代理以控制对这个对象的访问。
 */
public class ProxyPattern {
    public static void main(String[] args) {
        new RealSubjectProxy(new RealSubject()).doWork();
    }
}

interface Subject {
    void doWork();
}

class RealSubject implements Subject {

    @Override
    public void doWork() {
        System.out.println("working");
    }
}

class RealSubjectProxy implements Subject {
    private RealSubject realSubject;

    public RealSubjectProxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    public void connect() {
        System.out.println("connect");
    }

    public void log() {
        System.out.println("log");
    }

    @Override
    public void doWork() {
        connect();
        realSubject.doWork();
        log();
    }
}
