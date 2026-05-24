package io.github._1ukhashka.designpatterns.behavioral.chainofresponsibility;

public class L3SupportHandler extends SupportHandler {

    @Override
    public void handle(SupportRequest request) {
        System.out.println("L3 Support (engineer): resolved '" + request.getDescription() + "'");
    }
}
