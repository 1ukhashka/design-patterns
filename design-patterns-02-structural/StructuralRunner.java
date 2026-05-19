package io.github._1ukhashka.designpatterns.structural;

import io.github._1ukhashka.designpatterns.structural.adapter.Computer;
import io.github._1ukhashka.designpatterns.structural.adapter.Ps2Keyboard;
import io.github._1ukhashka.designpatterns.structural.adapter.Ps2ToUsbAdapter;
import io.github._1ukhashka.designpatterns.structural.bridge.DisplayPortConnection;
import io.github._1ukhashka.designpatterns.structural.bridge.GamingMonitor;
import io.github._1ukhashka.designpatterns.structural.bridge.HdmiConnection;
import io.github._1ukhashka.designpatterns.structural.bridge.OfficeMonitor;
import io.github._1ukhashka.designpatterns.structural.composite.ComputerAssembly;
import io.github._1ukhashka.designpatterns.structural.composite.ComputerPart;
import io.github._1ukhashka.designpatterns.structural.decorator.BasicMonitor;
import io.github._1ukhashka.designpatterns.structural.decorator.BlueLightFilterDecorator;
import io.github._1ukhashka.designpatterns.structural.decorator.Display;
import io.github._1ukhashka.designpatterns.structural.decorator.StandDecorator;
import io.github._1ukhashka.designpatterns.structural.facade.ComputerFacade;
import io.github._1ukhashka.designpatterns.structural.flyweight.PixelColorFactory;
import io.github._1ukhashka.designpatterns.structural.proxy.ProtectedStorageProxy;

public class StructuralRunner {

    public static void main(String[] args) {

        System.out.println("=== Adapter ===");
        Ps2Keyboard ps2Keyboard = new Ps2Keyboard();
        Computer computer = new Computer(new Ps2ToUsbAdapter(ps2Keyboard));
        computer.plugIn();

        System.out.println("\n=== Bridge ===");
        new GamingMonitor(new DisplayPortConnection()).display();
        new OfficeMonitor(new HdmiConnection()).display();

        System.out.println("\n=== Composite ===");
        ComputerAssembly pc = new ComputerAssembly("Full PC");
        pc.add(new ComputerPart("CPU Intel i7", 350.0));
        pc.add(new ComputerPart("RAM 16GB", 80.0));

        ComputerAssembly storage = new ComputerAssembly("Storage");
        storage.add(new ComputerPart("SSD 512GB", 60.0));
        storage.add(new ComputerPart("HDD 2TB", 55.0));
        pc.add(storage);

        pc.showDetails();

        System.out.println("\n=== Decorator ===");
        Display monitor = new BasicMonitor();
        System.out.println(monitor.getDescription() + " = $" + monitor.getCost());

        monitor = new StandDecorator(monitor);
        monitor = new BlueLightFilterDecorator(monitor);
        System.out.println(monitor.getDescription() + " = $" + monitor.getCost());

        System.out.println("\n=== Facade ===");
        ComputerFacade facade = new ComputerFacade();
        facade.pressStartButton();
        facade.pressShutdownButton();

        System.out.println("\n=== Flyweight ===");
        PixelColorFactory.getPixelColor("red").draw(0, 0);
        PixelColorFactory.getPixelColor("red").draw(1, 0);
        PixelColorFactory.getPixelColor("blue").draw(2, 0);
        System.out.println("Cached color objects: " + PixelColorFactory.getCachedCount());

        System.out.println("\n=== Proxy ===");
        ProtectedStorageProxy proxy = new ProtectedStorageProxy("admin123");
        proxy.readData("report.txt");
        proxy.writeData("report.txt", "secret data", "wrongpass");
        proxy.writeData("report.txt", "secret data", "admin123");
    }
}
