package io.github._1ukhashka.designpatterns.behavioral.memento;

import java.util.ArrayDeque;
import java.util.Deque;

public class BiosHistory {

    private final Deque<BiosMemento> history = new ArrayDeque<>();

    public void push(BiosMemento memento) {
        history.push(memento);
    }

    public BiosMemento pop() {
        return history.isEmpty() ? null : history.pop();
    }
}
