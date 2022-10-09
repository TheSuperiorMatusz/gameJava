package game.character.weapon.predefined;

import game.character.weapon.predefined.specyfication.WeaponBasicBonuses;

public class Sword implements WeaponBasicBonuses {
    @Override
    public int getHealthBonus() {
        return 5;
    }

    @Override
    public int getAttackBonus() {
        return 2;
    }
}
