package pattern;

import java.util.HashSet;
import java.util.Set;

/**
 * 享元模式：运用共享技术有效地支持大量细类度的对象。
 * 例子：池技术（线程池..)
 */
public class FlyweightPattern {
    public static void main(String[] args) {
        BikeFlyWeight bike1 = BikeFlyWeightFactory.getInstance().getBike();
        bike1.ride("jack");
        //bike1.back();

        BikeFlyWeight bike2 = BikeFlyWeightFactory.getInstance().getBike();
        bike2.ride("tom");
        bike2.back();

        BikeFlyWeight bike3 = BikeFlyWeightFactory.getInstance().getBike();
        bike3.ride("nancy");
        bike3.back();

        //验证能否使得创建对象减少
        System.out.println(bike1 == bike2);
        System.out.println(bike2 == bike3);
    }
}

abstract class BikeFlyWeight {
    protected int state;

    abstract void ride(String name);

    abstract void back();

    public int getState() {
        return state;
    }
}

class MoBikeFlyWeight extends BikeFlyWeight {
    private String bikeId;

    public MoBikeFlyWeight(String bikeId) {
        this.bikeId = bikeId;
    }

    @Override
    void ride(String name) {
        state = 1;
        System.out.println("name:" + name + ", bikeId:" + bikeId);
    }

    @Override
    void back() {
        state = 0;
    }
}

class BikeFlyWeightFactory {
    private static BikeFlyWeightFactory bikeFlyWeightFactory = new BikeFlyWeightFactory();
    private Set<BikeFlyWeight> pool = new HashSet<>();

    //单例饿汉式
    public static BikeFlyWeightFactory getInstance() {
        return bikeFlyWeightFactory;
    }

    //添加对象
    private BikeFlyWeightFactory() {
        for (int i = 0; i < 2; i++) {
            pool.add(new MoBikeFlyWeight("A" + i));
        }
    }

    //取未使用
    public BikeFlyWeight getBike() {
        for (BikeFlyWeight bike :
                pool) {
            if (bike.getState() == 0) {
                return bike;
            }
        }
        return null;
    }
}