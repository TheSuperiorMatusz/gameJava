package game.character.characteristic;

import game.character.weapon.specyfication.WeaponBasicBonuses;
import game.character.weapon.specyfication.WeaponHealingBonus;

public interface WeaponHealingPowerBonus {
    default int healingBonus(WeaponBasicBonuses weaponBasicBonuses){
        if(weaponBasicBonuses instanceof WeaponHealingBonus healingBonus){
            return healingBonus.getHealtPowerBonus();
        }
        return 0;
    }
}
