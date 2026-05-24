package io.github._1ukhashka.designpatterns.behavioral.command;

public class TypeCommand implements io.github._1ukhashka.designpatterns.behavioral.command.TextEditor.Command {

    private final TextEditor editor;
    private final String content;

    public TypeCommand(TextEditor editor, String content) {
        this.editor = editor;
        this.content = content;
    }

    @Override
    public void execute() {
        editor.write(content);
        System.out.println("Typed: \"" + content + "\"");
    }

    @Override
    public void undo() {
        editor.deleteLast(content.length());
        System.out.println("Undo typing: \"" + content + "\"");
    }
}
