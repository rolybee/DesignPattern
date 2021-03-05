package pattern;

/**
 * 抽象工厂模式
 * 抽象工厂类可以创建多个大类
 */

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        Factory factory = new HuaweiFactory();
        Phone phone = factory.createPhone();
        phone.print();
    }
}

interface Phone {
    void print();
}

class IPhone implements Phone {
    @Override
    public void print() {
        System.out.println("IPhone");
    }
}

class Huawei implements Phone {
    @Override
    public void print() {
        System.out.println("Huawei");
    }
}

interface Factory {
    Phone createPhone();
}

class IPhoneFactory implements Factory {

    @Override
    public Phone createPhone() {
        return new IPhone();
    }
}

class HuaweiFactory implements Factory {

    @Override
    public Phone createPhone() {
        return new Huawei();
    }
}

/**
 * 抽象工厂拓展
 */
interface AbstractFactory {
    Phone createPhone();
    Mask createMask();
}

interface Mask{
    void createMask();
}

class N95 implements Mask{
    @Override
    public void createMask() {
        System.out.println("N95");
    }
}