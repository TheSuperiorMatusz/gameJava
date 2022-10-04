package game.character.weapon.factories;

import game.character.weapon.predefined.Sword;
import game.character.weapon.specyfication.WeaponBasicBonuses;

public class SwordFactory implements WeaponFactory {
    @Override
    public WeaponBasicBonuses createWeapon() {
        return new Sword();
    }
}
