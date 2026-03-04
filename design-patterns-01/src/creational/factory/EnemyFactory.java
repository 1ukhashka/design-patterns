package creational.factory;

public class EnemyFactory {
    public interface SimpleEnemy { void spawn(); }

    public static class Rifleman implements SimpleEnemy {
        public void spawn() { System.out.println("Enemy Rifleman spawned!"); }
    }
    public static class LightTank implements SimpleEnemy {
        public void spawn() { System.out.println("Enemy Light Tank deployed!"); }
    }

    public static SimpleEnemy createEnemy(String type) {
        if (type.equalsIgnoreCase("rifleman")) return new Rifleman();
        else if (type.equalsIgnoreCase("light tank")) return new LightTank();
        throw new IllegalArgumentException("Unknown enemy type");
    }
}