package io.github._1ukhashka.designpatterns.behavioral;

import io.github._1ukhashka.designpatterns.behavioral.chainofresponsibility.L1SupportHandler;
import io.github._1ukhashka.designpatterns.behavioral.chainofresponsibility.L2SupportHandler;
import io.github._1ukhashka.designpatterns.behavioral.chainofresponsibility.L3SupportHandler;
import io.github._1ukhashka.designpatterns.behavioral.chainofresponsibility.SupportRequest;
import io.github._1ukhashka.designpatterns.behavioral.command.Keyboard;
import io.github._1ukhashka.designpatterns.behavioral.command.TextEditor;
import io.github._1ukhashka.designpatterns.behavioral.command.TypeCommand;
import io.github._1ukhashka.designpatterns.behavioral.iterator.Directory;
import io.github._1ukhashka.designpatterns.behavioral.iterator.FileIterator;
import io.github._1ukhashka.designpatterns.behavioral.mediator.CpuComponent;
import io.github._1ukhashka.designpatterns.behavioral.mediator.Motherboard;
import io.github._1ukhashka.designpatterns.behavioral.mediator.RamComponent;
import io.github._1ukhashka.designpatterns.behavioral.memento.BiosHistory;
import io.github._1ukhashka.designpatterns.behavioral.memento.BiosSettings;
import io.github._1ukhashka.designpatterns.behavioral.observer.CoolerFan;
import io.github._1ukhashka.designpatterns.behavioral.observer.CpuTemperatureSensor;
import io.github._1ukhashka.designpatterns.behavioral.observer.SystemLogger;
import io.github._1ukhashka.designpatterns.behavioral.state.PcContext;
import io.github._1ukhashka.designpatterns.behavioral.strategy.FileArchiver;
import io.github._1ukhashka.designpatterns.behavioral.strategy.RarCompression;
import io.github._1ukhashka.designpatterns.behavioral.strategy.ZipCompression;
import io.github._1ukhashka.designpatterns.behavioral.templatemethod.LinuxOs;
import io.github._1ukhashka.designpatterns.behavioral.templatemethod.WindowsOs;
import io.github._1ukhashka.designpatterns.behavioral.visitor.CpuHardware;
import io.github._1ukhashka.designpatterns.behavioral.visitor.DiagnosticVisitor;
import io.github._1ukhashka.designpatterns.behavioral.visitor.RamHardware;
import io.github._1ukhashka.designpatterns.behavioral.visitor.SsdHardware;

public class BehavioralRunner {

    public static void main(String[] args) {

        System.out.println("=== Chain of Responsibility ===");
        L1SupportHandler l1 = new L1SupportHandler();
        L2SupportHandler l2 = new L2SupportHandler();
        L3SupportHandler l3 = new L3SupportHandler();
        l1.setNext(l2).setNext(l3);
        l1.handle(new SupportRequest("PC won't turn on", 1));
        l1.handle(new SupportRequest("Driver crash", 2));
        l1.handle(new SupportRequest("Motherboard failure", 3));

        System.out.println("\n=== Command ===");
        TextEditor editor = new TextEditor();
        Keyboard keyboard = new Keyboard();
        keyboard.pressKey(new TypeCommand(editor, "Hello"));
        keyboard.pressKey(new TypeCommand(editor, ", World"));
        System.out.println("Text: " + editor.getText());
        keyboard.pressUndo();
        System.out.println("Text after undo: " + editor.getText());

        System.out.println("\n=== Iterator ===");
        Directory documents = new Directory("Documents");
        documents.addFile("resume.pdf");
        documents.addFile("notes.txt");
        documents.addFile("photo.png");
        FileIterator iterator = documents.iterator();
        while (iterator.hasNext()) {
            System.out.println("File: " + iterator.next());
        }

        // ── 4. MEDIATOR ─────────────────────────────────────────────
        System.out.println("\n=== Mediator ===");
        Motherboard motherboard = new Motherboard();
        CpuComponent cpu = new CpuComponent(motherboard);
        RamComponent ram = new RamComponent(motherboard);
        motherboard.setCpu(cpu);
        motherboard.setRam(ram);
        cpu.requestMemory();

        // ── 5. MEMENTO ──────────────────────────────────────────────
        System.out.println("\n=== Memento ===");
        BiosSettings bios = new BiosSettings(1200, false);
        BiosHistory history = new BiosHistory();
        System.out.println("Before: " + bios);
        history.push(bios.save());
        bios.setFanSpeed(2400);
        bios.setOverclockEnabled(true);
        System.out.println("After change: " + bios);
        bios.restore(history.pop());
        System.out.println("After restore: " + bios);

        // ── 6. OBSERVER ─────────────────────────────────────────────
        System.out.println("\n=== Observer ===");
        CpuTemperatureSensor sensor = new CpuTemperatureSensor();
        sensor.addObserver(new CoolerFan());
        sensor.addObserver(new SystemLogger());
        sensor.setTemperature(55);
        sensor.setTemperature(85);

        // ── 7. STATE ────────────────────────────────────────────────
        System.out.println("\n=== State ===");
        PcContext pc = new PcContext();
        pc.pressPowerButton();   // OFF -> RUNNING
        pc.pressSleepButton();   // RUNNING -> SLEEP
        pc.pressPowerButton();   // SLEEP -> RUNNING
        pc.pressPowerButton();   // RUNNING -> OFF

        // ── 8. STRATEGY ─────────────────────────────────────────────
        System.out.println("\n=== Strategy ===");
        FileArchiver archiver = new FileArchiver(new ZipCompression());
        archiver.archiveFile("backup.dat");
        archiver.setStrategy(new RarCompression());
        archiver.archiveFile("backup.dat");

        // ── 9. TEMPLATE METHOD ──────────────────────────────────────
        System.out.println("\n=== Template Method ===");
        System.out.println("-- Windows --");
        new WindowsOs().boot();
        System.out.println("-- Linux --");
        new LinuxOs().boot();

        // ── 10. VISITOR ─────────────────────────────────────────────
        System.out.println("\n=== Visitor ===");
        DiagnosticVisitor diagnostic = new DiagnosticVisitor();
        new CpuHardware("Intel Core i9").accept(diagnostic);
        new RamHardware(32).accept(diagnostic);
        new SsdHardware(1024).accept(diagnostic);
    }
}
