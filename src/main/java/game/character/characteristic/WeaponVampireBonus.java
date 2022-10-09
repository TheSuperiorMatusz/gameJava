package game.character.characteristic;

import game.character.weapon.predefined.specyfication.WeaponBasicBonuses;
import game.character.weapon.predefined.specyfication.WeaponVampirismBonus;
public interface WeaponVampireBonus {
    default int vampirebonus(WeaponBasicBonuses weaponBasicBonuses){
        if(weaponBasicBonuses instanceof WeaponVampirismBonus weaponVampirismBonus){
           return weaponVampirismBonus.getVampirismBonus();
        }
        return 0;
    }
}
