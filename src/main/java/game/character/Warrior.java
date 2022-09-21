package game.character;

import game.commander.Damage;
import game.commander.SimpleDamage;

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

    public void hit(Warrior opponent){
        opponent.receiveDamage(new SimpleDamage(getAttackDamage(),this));
    }

    protected int receiveDamage(Damage damage){
        setHealthBar(healthBar-damage.getValue());
        return damage.getValue();
    }
}
