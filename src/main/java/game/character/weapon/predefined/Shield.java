package game.character.weapon.predefined;

import game.character.weapon.predefined.specyfication.WeaponDefenseBonus;

public class Shield implements WeaponDefenseBonus {
    @Override
    public int getHealthBonus() {
        return 20;
    }

    @Override
    public int getAttackBonus() {
        return -1;
    }

    @Override
    public int getDeffenseBonus() {
        return 2;
    }
}
