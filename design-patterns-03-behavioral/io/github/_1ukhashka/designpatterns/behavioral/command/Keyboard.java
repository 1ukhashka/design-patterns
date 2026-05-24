package io.github._1ukhashka.designpatterns.behavioral.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class Keyboard {

    private final Deque<io.github._1ukhashka.designpatterns.behavioral.command.TextEditor.Command> history = new ArrayDeque<>();

    public void pressKey(io.github._1ukhashka.designpatterns.behavioral.command.TextEditor.Command command) {
        command.execute();
        history.push(command);
    }

    public void pressUndo() {
        if (!history.isEmpty()) {
            history.pop().undo();
        } else {
            System.out.println("Nothing to undo.");
        }
    }
}
