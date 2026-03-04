import creational.singleton.GameSettings;
import creational.builder.CharacterBuilder;
import creational.factory.EnemyFactory;
import creational.factorymethod.EnemySpawner;
import creational.abstractfactory.ModernWarfareFactory;
import creational.prototype.EnemyClone;

public class Main {
  public static void main(String[] args) {
    GameSettings settings = GameSettings.getInstance();
    settings.printStatus();

    CharacterBuilder.GameCharacter squadLeader = new CharacterBuilder()
            .setName("Assault Leader")
            .setEnemy(false)
            .setHealth(120)
            .setArmor(50)
            .build();

    CharacterBuilder.GameCharacter enemyCommander = new CharacterBuilder()
            .setName("Base Commander")
            .setEnemy(true)
            .setHealth(150)
            .setArmor(80)
            .build();

    squadLeader.showStats();
    enemyCommander.showStats();

    EnemyFactory.SimpleEnemy rifleman = EnemyFactory.createEnemy("rifleman");
    rifleman.spawn();

    EnemySpawner spawner = new EnemySpawner.HeavyArmorSpawner();
    spawner.spawn();

    ModernWarfareFactory.FactionFactory modernAssault = new ModernWarfareFactory.AssaultImpl();
    modernAssault.createAlliedUnit().attack();
    modernAssault.createEnemyUnit().defend();

    EnemyClone baseCoconut = new EnemyClone("Coconut Thrower", 100);
    EnemyClone coco1 = baseCoconut.clone();
    EnemyClone coco2 = baseCoconut.clone();
    coco2.setHp(40);

    coco1.display();
    coco2.display();
  }
}