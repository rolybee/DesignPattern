package pattern;

/**
 * 装饰器模式：动态地给一个对象添加一些额外的功能。
 * 就增加功能来说，装饰器模式比生成子类更灵活。
 * 四类角色：component, concrete component, decoration, concrete decoration
 * java io流大量使用该模式
 */

public class DecoratorPattern {
    public static void main(String[] args) {
        DecoratorRobot decoratorRobot = new DecoratorRobot(new FirstRobot());
        decoratorRobot.doSomething();
        decoratorRobot.doMoreThing();
    }
}

interface Robot {
    void doSomething();
}

class FirstRobot implements Robot {

    @Override
    public void doSomething() {
        System.out.println("say");
        System.out.println("dance");
    }
}

class DecoratorRobot implements Robot {

    private Robot robot;

    public DecoratorRobot(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void doSomething() {
        robot.doSomething();
    }

    public void doMoreThing() {
        //robot.doSomething();
        System.out.println("sing");
    }
}