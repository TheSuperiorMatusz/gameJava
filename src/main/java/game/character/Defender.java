package game.character;

import game.character.characteristic.HasAttack;
import game.character.weapon.specyfication.WeaponBasicBonuses;
import game.character.weapon.specyfication.WeaponDefenseBonus;

public class Defender extends WarriorWithWeapon{
    private static final int DEFENSE = 2;

    public Defender() {
       super(60,3);
    }
    protected int totalDefense(){
        WeaponBasicBonuses weaponBonuses = getWeapon();
        if(weaponBonuses instanceof WeaponDefenseBonus defenseBonus) {
            return DEFENSE + defenseBonus.getDeffenseBonus();
        }
        return DEFENSE;
    }

    @Override
    public void receiveDamage(HasAttack damager) {
        int reduceDamage=Math.max(0,damager.getAttackDamage() - totalDefense()  );
        super.receiveDamage(() -> reduceDamage);
    }

}
