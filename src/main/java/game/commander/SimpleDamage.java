package game.commander;

import game.character.Warrior;
import game.commander.Damage;

public class SimpleDamage implements Damage {
    private int value;
    Warrior damageDealer;

    public SimpleDamage(int value, Warrior damageDealer) {
        this.value = value;
        this.damageDealer = damageDealer;
    }

    @Override
    public Warrior getDamageDealer() {
        return damageDealer;
    }

    @Override
    public int getValue() {
        return value;
    }
    @Override
    public void setValue(int newValue) {
        this.value = newValue;
    }

}
