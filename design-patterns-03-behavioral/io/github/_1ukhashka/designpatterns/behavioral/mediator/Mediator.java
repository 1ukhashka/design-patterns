package io.github._1ukhashka.designpatterns.behavioral.mediator;

public interface Mediator {
    void notify(Component sender, String event);
}
