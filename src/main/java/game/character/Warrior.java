package game.character;

import game.character.characteristic.CanReceiveDamage;
import game.character.characteristic.HasAttack;
import game.character.characteristic.HasHealthBar;


public class Warrior implements
        HasHealthBar, CanReceiveDamage, HasAttack {
    private int healthBar;
    private final int attackDamage;

    public int getInitialHealthBar() {
        return initialHealthBar;
    }

    private final int initialHealthBar;
    public Warrior() {
        this(50, 5);
    }

    protected Warrior(int healthBar, int attackDamege){
        this.attackDamage = attackDamege;
        this.initialHealthBar=this.healthBar = healthBar;
    }

    @Override
    public void setHealthBar(int healthBar) {
        this.healthBar =Math.min(initialHealthBar,healthBar);
    }

    @Override
    public int getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getHealthBar() {
        return healthBar;
    }



    @Override
    public void receiveDamage(HasAttack damager){
        setHealthBar(getHealthBar()-damager.getAttackDamage());
    }
}
