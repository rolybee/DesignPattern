package pattern;

/**
 * 模板模式：定义一个操作中的算法和框架，而将一些步骤延迟到子类中。使得子类可以不改变一个算法结构
 * 即可重定义该算法的某些特定步骤。
 */
public class TemplatePattern {
    public static void main(String[] args) {
        Cooking cooking = new CookingFood();
        cooking.cook();
    }
}

abstract class Cooking {
    protected abstract void step1();
    protected abstract void step2();

    public void cook() {
        System.out.println("start cook");
        step1();
        step2();
        System.out.println("finish cook");
    }
}

class CookingFood extends Cooking {

    @Override
    protected void step1() {
        System.out.println("oil");
    }

    @Override
    protected void step2() {
        System.out.println("meat");
    }
}
