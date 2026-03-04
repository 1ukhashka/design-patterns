package creational.singleton;

public class GameSettings {
    private static GameSettings instance;
    private String operationName;

    private GameSettings() {
        this.operationName = "Operation 'Give patterns liberty'";
    }

    public static GameSettings getInstance() {
        if (instance == null) {
            instance = new GameSettings();
        }
        return instance;
    }

    public String getOperationName() { return operationName; }
    public void setOperationName(String operationName) { this.operationName = operationName; }

    public void printStatus() {
        System.out.println("Current Operation: " + operationName);
    }
}