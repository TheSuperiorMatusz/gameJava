package game.character.weapon.factories;

import game.character.weapon.predefined.specyfication.WeaponBasicBonuses;

public interface WeaponFactory {
    WeaponBasicBonuses createWeapon();
}
