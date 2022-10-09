package game.character;

import game.character.characteristic.HasAttack;
import game.character.characteristic.HasDefense;
import game.character.characteristic.WeaponDefenceBonus;

public class Defender extends WarriorWithWeapon implements WeaponDefenceBonus, HasDefense {
    private static final int DEFENSE = 2;

    public Defender() {
       super(60,3);
    }
    Defender(int health, int attack){
        super(health,attack);
    }
    public int bonusDefense(){
        Warrior warrior = getWarrior();
        if(warrior instanceof  WarriorWithWeapon warriorWithWeapon){
            int res = defenseBonus(warriorWithWeapon.getWeapon()) + defenseBonus(getWeapon());
            return res;
        }

        if(hasWeapon()){
            return defenseBonus(getWeapon());
        }
        return 0;
    }
    public int basicDefense(){
        return DEFENSE;
    }

    @Override
    public void receiveDamage(HasAttack damager) {
        int reduceDamage=Math.max(0,damager.getAttackDamage() - totalDefense() );
        super.receiveDamage(() -> reduceDamage);
    }

}
