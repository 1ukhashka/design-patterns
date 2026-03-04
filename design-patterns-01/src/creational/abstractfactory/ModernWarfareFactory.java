package creational.abstractfactory;

public class ModernWarfareFactory {
    public interface AlliedUnit { void attack(); }
    public interface EnemyUnit { void defend(); }

    public interface FactionFactory {
        AlliedUnit createAlliedUnit();
        EnemyUnit createEnemyUnit();
    }

    public static class AssaultImpl implements FactionFactory {
        public AlliedUnit createAlliedUnit() {
            return () -> System.out.println("Allied Special Forces getting patterns to evacuation helicopter!");
        }
        public EnemyUnit createEnemyUnit() {
            return () -> System.out.println("Enemy Sniper taking cover!");
        }
    }
}