package pattern;

import com.sun.org.apache.xalan.internal.xsltc.dom.MultiValuedNodeHeapIterator;

/**
 * 责任链模式：是一种处理请求的模式，它让多个处理器都有机会处理该请求，直到其中某个处理成功为止。
 * 责任链模式把多个处理器串成链，然后让请求在链上传递。
 */
public class ChainPattern {
    public static void main(String[] args) {
        Handler level1 = new Leader();
        Handler level2 = new Boss();
        level1.setNextHandler(level2);

        level1.process(10);
        level1.process(11);
    }
}

abstract class Handler {
    protected Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void process(int info);
}

class Leader extends Handler {

    @Override
    public void process(int info) {
        if (info > 0 && info < 11) {
            System.out.println("Leader handle!");
        } else {
            nextHandler.process(info);
        }
    }
}

class Boss extends Handler {

    @Override
    public void process(int info) {
        System.out.println("Boss handle!");
    }
}