package game.character;

import game.character.characteristic.CanReceiveDamage;
import game.character.characteristic.WeaponVampireBonus;
import game.character.characteristic.KnowsDamageDealt;



public class Vampire extends WarriorWithWeapon implements KnowsDamageDealt, WeaponVampireBonus {
    private static final int VAMPIRISM = 50;
    public Vampire() {
        super(40,4);
    }
    private int bonusVampirism(){
        Warrior warrior = getWarrior();
        if(warrior instanceof  WarriorWithWeapon warriorWithWeapon){
            int res = vampirebonus(warriorWithWeapon.getWeapon()) + vampirebonus(getWeapon());
            return res;
        }
        if(hasWeapon()){
            return vampirebonus(getWeapon());
        }
        return 0;
    }
    private int basicVampirism(){
        Warrior warrior = getWarrior();
        if(warrior instanceof  Vampire vampire){
            return vampire.basicVampirism();
        }
        return VAMPIRISM;
    }
    private int totalVampirism(){
      return bonusVampirism()+basicVampirism();
    }
    @Override
    public void hit(CanReceiveDamage opponent) {

        int damageDealt = hitAndReportDamage(opponent);
        final int  percent = 100;
        int addHealth =  damageDealt * totalVampirism() / percent;
        int minusAttakcBonus = getBonusAttack() * totalVampirism() / percent;
        setHealthBar(getHealthBar() + addHealth);
        }

    }

