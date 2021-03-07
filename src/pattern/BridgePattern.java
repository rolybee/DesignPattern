package pattern;

/**
 * 桥接模式：将抽象和实现解耦，使得两者可以独立地变化。
 */
public class BridgePattern {
    public static void main(String[] args) {

    }
}

/**
 * 抽象类
 */
abstract class Abstraction {
    private Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public void doWork() {
        this.implementor.doSomething();
    }
}

/**
 * 实现接口
 */
interface Implementor {
    void doSomething();
}

/**
 * 实现类
 */
class ConcreteImplementor implements Implementor {
    @Override
    public void doSomething() {
        System.out.println("hello world");
    }
}