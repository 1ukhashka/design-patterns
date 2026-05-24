package io.github._1ukhashka.designpatterns.behavioral.chainofresponsibility;

public class L2SupportHandler extends SupportHandler {

    @Override
    public void handle(SupportRequest request) {
        if (request.getLevel() == 2) {
            System.out.println("L2 Support: resolved '" + request.getDescription() + "'");
        } else if (next != null) {
            System.out.println("L2 Support: escalating to L3...");
            next.handle(request);
        }
    }
}
