package game.character.weapon.factories;

import game.character.weapon.predefined.Katana;
import game.character.weapon.specyfication.WeaponBasicBonuses;

public class KatanaFactory implements WeaponFactory {
    @Override
    public WeaponBasicBonuses createWeapon() {
        return new Katana();
    }
}
