package game.character;

public class Warrior {
    private int healthBar;
    private final int attackDamage;

    public Warrior() {
        this(50, 5);
    }

    protected Warrior(int healthBar, int attackDamege){
        this.attackDamage = attackDamege;
        this.healthBar = healthBar;
    }
    public boolean isAlive(){
        return healthBar > 0;
    }

    public void setHealthBar(int healthBar) {
        this.healthBar = healthBar;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getHealthBar() {
        return healthBar;
    }

    public int getAHit(int damage){
        int newHealthBar= this.healthBar-damage;
        this.setHealthBar(newHealthBar);
        return damage;
    }
}
