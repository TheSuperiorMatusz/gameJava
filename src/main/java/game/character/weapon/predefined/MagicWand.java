package game.character.weapon.predefined;

import game.character.weapon.predefined.specyfication.WeaponHealingBonus;

public class MagicWand implements WeaponHealingBonus {
    @Override
    public int getHealthBonus() {
        return 30;
    }

    @Override
    public int getAttackBonus() {
        return 3;
    }

    @Override
    public int getHealtPowerBonus() {
        return 3;
    }
}
