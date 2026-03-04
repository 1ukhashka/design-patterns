package creational.prototype;

public class EnemyClone implements Cloneable {
    private String type;
    private int hp;

    public EnemyClone(String type, int hp) {
        this.type = type;
        this.hp = hp;
    }

    public void setHp(int hp) { this.hp = hp; }

    public void display() {
        System.out.println("Clone: " + type + " | HP: " + hp);
    }

    @Override
    public EnemyClone clone() {
        try {
            return (EnemyClone) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone error");
        }
    }
}