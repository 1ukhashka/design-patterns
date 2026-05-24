package io.github._1ukhashka.designpatterns.behavioral.chainofresponsibility;

public abstract class SupportHandler {

    protected SupportHandler next;

    public SupportHandler setNext(SupportHandler next) {
        this.next = next;
        return next;
    }

    public abstract void handle(SupportRequest request);
}
