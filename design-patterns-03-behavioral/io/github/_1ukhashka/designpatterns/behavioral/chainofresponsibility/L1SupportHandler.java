package io.github._1ukhashka.designpatterns.behavioral.chainofresponsibility;

public class L1SupportHandler extends SupportHandler {

    @Override
    public void handle(SupportRequest request) {
        if (request.getLevel() == 1) {
            System.out.println("L1 Support: resolved '" + request.getDescription() + "'");
        } else if (next != null) {
            System.out.println("L1 Support: escalating to L2...");
            next.handle(request);
        }
    }
}
