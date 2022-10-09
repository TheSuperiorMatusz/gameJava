package game.character.weapon.factories;

import game.character.weapon.predefined.MagicWand;
import game.character.weapon.predefined.specyfication.WeaponBasicBonuses;

public class MagicWandFactory implements WeaponFactory{
    @Override
    public WeaponBasicBonuses createWeapon() {
        return new MagicWand();
    }
}
