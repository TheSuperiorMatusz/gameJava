package game.character.characteristic;

import game.character.weapon.specyfication.WeaponBasicBonuses;
import game.character.weapon.specyfication.WeaponDefenseBonus;

public interface WeaponDefenceBonus {
    default int defenseBonus(WeaponBasicBonuses weaponBasicBonuses){
        if(weaponBasicBonuses instanceof WeaponDefenseBonus defenseBonus){
            return defenseBonus.getDeffenseBonus();
        }
        return 0;

    }
}
