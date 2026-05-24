package io.github._1ukhashka.designpatterns.behavioral.mediator;

public abstract class Component {

    protected Mediator mediator;

    public Component(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract String getName();
}
