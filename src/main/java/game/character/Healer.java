package game.character;

import game.character.characteristic.WeaponHealingPowerBonus;

public class Healer extends WarriorWithWeapon implements WeaponHealingPowerBonus {
    private static final int HEALING_POWER = 2;
    public Healer() {
        super(60,0);
    }
    private int bonusHealingPower(){
        Warrior warrior = getWarrior();
        if(warrior instanceof  WarriorWithWeapon warriorWithWeapon){
            int res = healingBonus(warriorWithWeapon.getWeapon()) + healingBonus(getWeapon());
            return res;
        }
        if(hasWeapon()){
            return healingBonus(getWeapon());
        }
        return 0;
    }
    private int basicHealingPower(){
        return HEALING_POWER;
    }
    private int HealingPower(){
      return basicHealingPower()+bonusHealingPower();

    }

    public void heal(Warrior woundedWarrior){
        woundedWarrior.setHealthBar(woundedWarrior.getHealthBar()+ HealingPower());
    }
}
