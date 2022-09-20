package game;

import game.character.Warrior;

public class Rookie extends Warrior {
    @Override
    public int getAttackDamage() {
        return 1;
    }
}
