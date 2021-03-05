package pattern;

/**
 * 适配器模式：将一个类的接口变换成客户端所期待的另一种接口，从而使原本因接口不匹配而无法在一起工作的两个类能够在一起工作。
 * 例子：手机通过充电器使用220V交流电
 * 角色：Adapter, Adaptee
 * 使用：转换接口；装饰器模式：修改接口
 */
public class AdapterPattern {
    public static void main(String[] args) {
        Adapter adapter = new Adapter(new Speaker());
        String res = adapter.translate();
        System.out.println(res);
    }
}

class Speaker {
    public String speak() {
        return "java";
    }
}

interface Translator {
    public String translate();
}

class Adapter implements Translator {

    private Speaker speaker;

    public Adapter(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public String translate() {
        String res = speaker.speak();
        //System.out.println(res);
        return res;
    }
}
