package io.github._1ukhashka.designpatterns.behavioral.command;

public class TextEditor {

    private StringBuilder text = new StringBuilder();

    public void write(String content) {
        text.append(content);
    }

    public void deleteLast(int length) {
        int start = Math.max(0, text.length() - length);
        text.delete(start, text.length());
    }

    public String getText() {
        return text.toString();
    }

    public static interface Command {
        void execute();
        void undo();
    }
}
