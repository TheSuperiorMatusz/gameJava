package game.character;

import game.character.characteristic.CanReceiveDamage;
import game.character.characteristic.KnowsDamageDealt;
import game.character.weapon.specyfication.WeaponBasicBonuses;
import game.character.weapon.specyfication.WeaponVampirismBonus;

public class Vampire extends WarriorWithWeapon implements KnowsDamageDealt {
    private static final int VAMPIRISM = 50;
    public Vampire() {
        super(40,4);
    }
    private int totalVampirism(){
        WeaponBasicBonuses weapon =getWeapon();
        if(weapon instanceof WeaponVampirismBonus vampirismBonus){
        return vampirismBonus.getVampirismBonus() + VAMPIRISM;
    }
        return VAMPIRISM;
    }
    @Override
    public void hit(CanReceiveDamage opponent) {

        int damageDealt = hitAndReportDamage(opponent);
        final int  percent = 100;
        int addHealth =  damageDealt * totalVampirism() / percent;
        int minusAttakcBonus = getBonusAttack() * totalVampirism() / percent;
        addHealth -= minusAttakcBonus;
        setHealthBar(getHealthBar() + addHealth);
        }

    }

