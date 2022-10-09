package game.character.characteristic;

import game.character.weapon.predefined.specyfication.WeaponBasicBonuses;
import game.character.weapon.predefined.specyfication.WeaponDefenseBonus;

public interface WeaponDefenceBonus {
    default int defenseBonus(WeaponBasicBonuses weaponBasicBonuses){
        if(weaponBasicBonuses instanceof WeaponDefenseBonus defenseBonus){
            return defenseBonus.getDeffenseBonus();
        }
        return 0;

    }
}
