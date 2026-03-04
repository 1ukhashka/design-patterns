package creational.factorymethod;

public abstract class EnemySpawner {
    public interface SpawnerEnemy { void action(); }

    public void spawn() {
        SpawnerEnemy enemy = createEnemy();
        enemy.action();
    }
    protected abstract SpawnerEnemy createEnemy();

    public static class HeavyArmorSpawner extends EnemySpawner {
        @Override
        protected SpawnerEnemy createEnemy() {
            return () -> System.out.println("Enemy 'Heavy Tank' breaking through the defense line!");
        }
    }
}