package creational.builder;

public class CharacterBuilder {
    public static class GameCharacter {
        public String name;
        public boolean isEnemy;
        public int health;
        public int armor;

        public GameCharacter(String name, boolean isEnemy, int health, int armor) {
            this.name = name;
            this.isEnemy = isEnemy;
            this.health = health;
            this.armor = armor;
        }

        public void showStats() {
            String side = isEnemy ? "[ENEMY]" : "[ALLIED]"; // true - enemy , false - allied
            System.out.println(side + " " + name + " | HP: " + health + " | Armor: " + armor);
        }
    }


    private String name;
    private boolean isEnemy;
    private int health;
    private int armor;

    public CharacterBuilder setName(String name) { this.name = name; return this; }
    public CharacterBuilder setEnemy(boolean isEnemy) { this.isEnemy = isEnemy; return this; }
    public CharacterBuilder setHealth(int health) { this.health = health; return this; }

    public CharacterBuilder setArmor(int armor) { this.armor = armor; return this; }

    public GameCharacter build() {
        return new GameCharacter(name, isEnemy, health, armor); // tut
    }
}