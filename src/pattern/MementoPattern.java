package pattern;

import java.util.Optional;
import java.util.Stack;

/**
 * 备忘录模式：是一种行为设计模式，允许在不暴露对象实现细节的情况下保存和恢复对象之前的状态。
 */
public class MementoPattern {
    public static void main(String[] args) {
        History history = new History();
        Document document = new Document();
        document.change("abc");
        history.add(document.save());

        document.change("efg");
        history.add(document.save());

        document.change("hij");
        history.add(document.save());

        document.change("klm");

        document.resume(history.getLastVersion());
        document.print();

        document.resume(history.getLastVersion());
        document.print();
    }
}

interface Memento {

}

class Document {
    private String content;

    public BackUp save() {
        return new BackUp(content);
    }

    public void resume(BackUp backUp) {
        content = backUp.content;
    }

    public void change(String content) {
        this.content = content;
    }

    public void print() {
        System.out.println(content);
    }
}

class BackUp implements Memento {
    String content;

    public BackUp(String content) {
        this.content = content;
    }
}

class History {
    Stack<BackUp> backUpStack = new Stack<>();

    public void add(BackUp backUp) {
        backUpStack.add(backUp);
    }

    public BackUp getLastVersion() {
        return backUpStack.pop();
    }
}
