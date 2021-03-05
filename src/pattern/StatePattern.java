package pattern;

/**
 * 状态模式：允许一个的对象在其内部状态改变时改变它的行为，对象看起来似乎修改了它的类，
 * 其别名为状态对象(Object for States)，状态模式是一种对象行为型模式。
 * 优点：封装了转换规则，并枚举了可能的状态，它将所有与某个对状态有关的行为放到状态类中，
 * 可以方便地增加新的状态，还可以让多个环境对象共享一个状态对象，从而减少系统中对象的个数。
 * 缺点：会增加系统类和对象的个数。
 */
public class StatePattern {
    public static void main(String[] args) {
        Context mike = new Context();
        mike.changeState(new Happy());
        mike.doSomething();
        mike.changeState(new Sad());
        mike.doSomething();
    }
}

abstract class State {
    abstract void doWork();
}

class Happy extends State {
    @Override
    void doWork() {
        System.out.println("happy");
    }
}

class Angry extends State {
    @Override
    void doWork() {
        System.out.println("angry");
    }
}

class Sad extends State {
    @Override
    void doWork() {
        System.out.println("sad");
    }
}

class Context {
    private State state;

    public void changeState(State state) {
        this.state = state;
    }

    public void doSomething() {
        state.doWork();
    }
}