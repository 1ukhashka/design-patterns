package io.github._1ukhashka.designpatterns.behavioral.visitor;

public interface HardwareComponent {
    void accept(HardwareVisitor visitor);
}
