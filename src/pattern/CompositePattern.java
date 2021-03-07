package pattern;

import com.sun.xml.internal.ws.api.pipe.FiberContextSwitchInterceptor;

import javax.crypto.Cipher;
import java.nio.channels.ConnectionPendingException;
import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式：是一种结构型设计模式，你可以使用它将对象组合成树状结构，并且能够像使用独立对象一样使用它们。
 */
public class CompositePattern {
    public static void main(String[] args) {
        Composite china = new Composite();
        china.add(new City(1000));
        china.add(new City(2000));

        Composite shanghai = new Composite();
        shanghai.add(new City(3000));
        shanghai.add(new City(4000));

        china.add(shanghai);

        System.out.println(china.count());
    }
}

interface Counter {
    int count();
}

class City implements Counter {
    private int sum;

    public City(int sum) {
        this.sum = sum;
    }

    @Override
    public int count() {
        return sum;
    }
}

/**
 * 容器
 */
class Composite implements Counter {
    private List<Counter> counterList = new ArrayList<>();

    public void add(Counter counter) {
        counterList.add(counter);
    }

    public void delete(Counter counter) {
        counterList.remove(counter);
    }

    public List<Counter> getChild() {
        return counterList;
    }

    @Override
    public int count() {
        int sum = 0;
        for (Counter counter : counterList) {
            sum += counter.count();
        }
        return sum;
    }
}
