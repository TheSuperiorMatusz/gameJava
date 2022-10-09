package game.character.weapon.factories;

import game.character.weapon.predefined.Shield;
import game.character.weapon.predefined.specyfication.WeaponBasicBonuses;

public class ShieldFactory implements WeaponFactory {
    @Override
    public WeaponBasicBonuses createWeapon() {
        return new Shield();
    }
}
