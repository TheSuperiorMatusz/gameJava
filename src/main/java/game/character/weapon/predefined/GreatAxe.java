package game.character.weapon.predefined;

import game.character.weapon.specyfication.WeaponDefenseBonus;
import game.character.weapon.specyfication.WeaponVampirismBonus;

public class GreatAxe implements WeaponVampirismBonus, WeaponDefenseBonus {
    @Override
    public int getHealthBonus() {
        return -15;
    }

    @Override
    public int getAttackBonus() {
        return 5;
    }

    @Override
    public int getDeffenseBonus() {
        return -2;
    }

    @Override
    public int getVampirismBonus() {
        return 10;
    }
}
