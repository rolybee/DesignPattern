package pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式：定义对象间的一种一对多依赖关系，使得每当一个对象状态发生改变时，其相关依赖对象皆得到通知并被自动更新。
 */
public class ObserverPattern {
    public static void main(String[] args) {
        Debet mike = new Mike();
        mike.borrow(new Jack());
        mike.borrow(new Nancy());
        mike.notifyCredits();
    }
}

interface Debet {
    void borrow(Credit credit);

    void notifyCredits();
}

interface Credit {
    void takeMoney();
}

class Mike implements Debet {
    private List<Credit> allCredits = new ArrayList<>();
    private Integer state = 0; //1表示有钱

    @Override
    public void borrow(Credit credit) {
        allCredits.add(credit);
    }

    @Override
    public void notifyCredits() {
        allCredits.forEach(credit -> credit.takeMoney());
    }
}

class Jack implements Credit {
    @Override
    public void takeMoney() {
        System.out.println("Jack take money");
    }
}

class Nancy implements Credit {
    @Override
    public void takeMoney() {
        System.out.println("Nancy take money");
    }
}
