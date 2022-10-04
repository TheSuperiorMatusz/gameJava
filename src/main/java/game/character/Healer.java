package game.character;

import game.character.weapon.specyfication.WeaponBasicBonuses;
import game.character.weapon.specyfication.WeaponHealingBonus;

public class Healer extends WarriorWithWeapon {
    private static final int HEALING_POINT = 2;
    public Healer() {
        super(60,0);
    }

    private int HealingPower(){
        WeaponBasicBonuses weaponBonuses = getWeapon();
        if(weaponBonuses instanceof WeaponHealingBonus healingBonus) {
            return HEALING_POINT + healingBonus.getHealtPowerBonus();
        }
        return HEALING_POINT;
    }

    public void heal(Warrior woundedWarrior){
        woundedWarrior.setHealthBar(woundedWarrior.getHealthBar()+ HealingPower());
    }
}
