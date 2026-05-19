package io.github._1ukhashka.designpatterns.structural.proxy;

public class ProtectedStorageProxy implements Storage {

    private final Storage hardDrive = new HardDriveStorage();
    private final String adminPassword;

    public ProtectedStorageProxy(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public void readData(String filename) {
        hardDrive.readData(filename);
    }

    @Override
    public void writeData(String filename, String content) {
        // write requires authentication
    }

    public void writeData(String filename, String content, String password) {
        if (adminPassword.equals(password)) {
            hardDrive.writeData(filename, content);
        } else {
            System.out.println("Proxy: access denied. Wrong password.");
        }
    }
}
