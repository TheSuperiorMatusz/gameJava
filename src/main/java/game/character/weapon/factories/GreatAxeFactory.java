package game.character.weapon.factories;

import game.character.weapon.predefined.GreatAxe;
import game.character.weapon.predefined.specyfication.WeaponBasicBonuses;

public class GreatAxeFactory implements WeaponFactory {
    @Override
    public WeaponBasicBonuses createWeapon() {
        return new GreatAxe();
    }
}
