package pattern;

import javax.swing.*;
import java.util.SplittableRandom;

/**
 * 命令模式：是一种行为设计模式，它可将请求转换为一个包含与请求相关的所有信息的独立对象。
 * 该转换让你能根据不同的请求将方法参数化、延迟请求执行或将其放入队列中，且能实现可撤销操作。
 * ---MVC---
 */
public class CommandPattern {
    public static void main(String[] args) {
        SaveButton saveButton = new SaveButton();
        TextBox textBox = new TextBox();

        PrintCommand printCommand = new PrintCommand(textBox);
        saveButton.bindCommand(printCommand);

        textBox.setContext("goA");
        saveButton.doPrint();

        textBox.setContext("goB");
        saveButton.doPrint();
    }
}

/**
 * GUI save button
 */
class SaveButton {
    private Command command;

    public void bindCommand(Command command) {
        this.command = command;
    }

    public void doPrint() {
        if (command == null) {
            throw new RuntimeException("init fail!");
        }
        command.execute();
    }
}

/**
 * print service
 */
class PrintService {
    public void print(String text) {
        System.out.println(text);
    }
}

/**
 * command
 */
interface Command {
    void execute();
}

/**
 * concrete command
 */
class PrintCommand implements Command {
    private PrintService printService = new PrintService();
    private TextBox textBox;

    public PrintCommand(TextBox textBox) {
        this.textBox = textBox;
    }

    @Override
    public void execute() {
        printService.print(textBox.getContext());
    }
}

class TextBox {
    private String context;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}