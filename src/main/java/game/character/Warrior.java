package game.character;

import game.character.characteristic.CanReceiveDamage;
import game.character.characteristic.HasAttack;
import game.character.characteristic.HasHealthBar;


public class Warrior implements
        HasHealthBar, CanReceiveDamage, HasAttack {
    private int healthBar;

    private int attackDamage;
    public int getInitialHealthBar() {
        return initialHealthBar;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage < 0 ? 0 : attackDamage;
    }

    private final int initialHealthBar;
    public Warrior() {
        this(50, 5);

    }

    public Warrior(int healthBar, int attackDamege){
        this.attackDamage = attackDamege;
        this.initialHealthBar=this.healthBar = healthBar;
    }


    @Override
    public void setHealthBar(int healthBar) {
        this.healthBar =Math.min(initialHealthBar,healthBar);
    }



    @Override
    public int getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getHealthBar() {
        return this.healthBar;
    }



    @Override
    public void receiveDamage(HasAttack damager){
        setHealthBar(getHealthBar()-damager.getAttackDamage());
    }
}
