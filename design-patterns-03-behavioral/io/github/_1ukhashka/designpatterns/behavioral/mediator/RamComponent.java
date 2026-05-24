package io.github._1ukhashka.designpatterns.behavioral.mediator;

public class RamComponent extends Component {

    public RamComponent(Mediator mediator) {
        super(mediator);
    }

    @Override
    public String getName() {
        return "RAM";
    }

    public void sendData() {
        System.out.println("RAM: sending data to bus");
        mediator.notify(this, "DATA_READY");
    }
}
