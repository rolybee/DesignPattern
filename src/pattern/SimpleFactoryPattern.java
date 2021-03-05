package pattern;

/**
 * 简单工厂模式，又称为静态工厂模式，属于类创建型模式
 * 在简单工厂模式中，可以跟据参数的不同返回不同类的实例。
 * 简单工厂模式专门定义一个类来负责创建其他类的实例，被创建的实例通常都具有相同的父类。
 * 优点：创建和使用分离。
 * 缺点：工厂类不够灵活。
 */
public class SimpleFactoryPattern {

    public static Product craetProduct(String type) {
        if (type.equals("A")) {
            return new ProductA();
        } else {
            return new ProductB();
        }
    }

    public static void main(String[] args) {
        Product product = craetProduct("A");
        product.print();
    }
}

abstract class Product {
    public abstract void print();
}

class ProductA extends Product {
    @Override
    public void print() {
        System.out.println("产品A");
    }
}

class ProductB extends Product {
    @Override
    public void print() {
        System.out.println("产品B");
    }
}