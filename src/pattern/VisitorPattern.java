package pattern;

import java.nio.channels.AcceptPendingException;

/**
 * 访问者模式：用于封装一些作用于某种数据结构中的各元素的操作，它可以在不该比那数据结构的前提下
 * 定义作用于这些元素的新的操作。
 * 优点：开闭原则，单一职责
 * 缺点：访问方法太多
 */
public class VisitorPattern {
    public static void main(String[] args) {
        EggRobot eggRobot = new EggRobot();
        eggRobot.calculate();
        NewVisitor newVisitor = new NewVisitor();
        eggRobot.accept(newVisitor);
        eggRobot.calculate();
    }
}

interface Visitor {
    void visitCPU(CPU cpu);
    void visitDisk(Disk disk);
}

class NewVisitor implements Visitor {
    @Override
    public void visitCPU(CPU cpu) {
        cpu.command += "100";
    }

    @Override
    public void visitDisk(Disk disk) {
        disk.command += "001";
    }
}

class EggRobot {
    private CPU cpu;
    private Disk disk;

    public EggRobot() {
        cpu = new CPU("100100");
        disk = new Disk("001001");
    }

    public void calculate() {
        cpu.run();
        disk.run();
    }

    public void accept(Visitor visitor) {
        cpu.accept(visitor);
        disk.accept(visitor);
    }
}

abstract class Hardware {
    String command;
    public abstract void accept(Visitor visitor);

    public Hardware(String command) {
        this.command = command;
    }

    public void run() {
        System.out.println(command);
    }
}

class CPU extends Hardware {

    public CPU(String command) {
        super(command);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitCPU(this);
    }
}

class Disk extends Hardware {

    public Disk(String command) {
        super(command);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitDisk(this);
    }
}
