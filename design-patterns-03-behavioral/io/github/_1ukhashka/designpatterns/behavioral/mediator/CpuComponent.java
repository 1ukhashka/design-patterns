package io.github._1ukhashka.designpatterns.behavioral.mediator;

public class CpuComponent extends Component {

    public CpuComponent(Mediator mediator) {
        super(mediator);
    }

    @Override
    public String getName() {
        return "CPU";
    }

    public void requestMemory() {
        System.out.println("CPU: requesting memory access");
        mediator.notify(this, "MEMORY_REQUEST");
    }

    public void receiveData(String data) {
        System.out.println("CPU: received data -> " + data);
    }
}
