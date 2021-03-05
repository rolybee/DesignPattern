package pattern;

/**
 * 外观模式：要求子系统的外部与其内部的通信必须通过一个统一的对象进行。
 * 外观模式提供一个高层次的接口，使得子系统更容易使用。
 * 例子：client facade subsystem1 subsystem2...
 * 缺点：不符合开闭原则。新增子流程需要修改facade
 */
public class FacadePattern {
    public static void main(String[] args) {
        System.out.println(new Facade().prove());
    }
}

class SubFlow1 {
    boolean isTrue() {
        return true;
    }
}

class SubFlow2 {
    boolean isOk() {
        return true;
    }
}

class SubFlow3 {
    boolean isFine() {
        return true;
    }
}

/**
 * facade**
 */
class Facade {
    SubFlow1 s1 = new SubFlow1();
    SubFlow2 s2 = new SubFlow2();
    SubFlow3 s3 = new SubFlow3();

    public String prove() {
        if (s1.isTrue() && s2.isOk() && s3.isFine()) {
            return "true";
        }
        return "false";
    }
}