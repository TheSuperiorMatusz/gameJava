package game.commander;

import game.character.Warrior;

public interface Damage {
    Warrior getDamageDealer();
    int getValue();
    void setValue(int newValue);
}
