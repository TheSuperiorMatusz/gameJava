package game.character;

import game.character.characteristic.HasAttack;
import game.character.weapon.specyfication.WeaponBasicBonuses;

public class WarriorWithWeapon extends Warrior {
    private Warrior warrior;
    private WeaponBasicBonuses weapon=null;

    public WarriorWithWeapon() {
        this.warrior = new Warrior();

    }
    protected WarriorWithWeapon(Warrior warrior, WeaponBasicBonuses weapon){
        this.warrior=warrior;
        this.weapon=weapon;
    }

    public WarriorWithWeapon(int healthBar,int attackDamage) {
        this.warrior = new Warrior(healthBar,attackDamage);
    }

    public void equipWeapon(WeaponBasicBonuses weapon) {
        if (weapon != weapon) {
            Warrior warrior1 = this.warrior;
            this.warrior = new WarriorWithWeapon(warrior1, weapon);
        }else {
            this.weapon = weapon;
        }
    }

    public WeaponBasicBonuses getWeapon() {
        return weapon;
    }
    public int getBonusAttack(){
        if(warrior instanceof WarriorWithWeapon warriorWithWeapon){
            int res = warriorWithWeapon.getBonusAttack() + weapon.getAttackBonus();
            return res;
        }
        if(hasWeapon()){
            return weapon.getAttackBonus();
        }
        return 0;
    }
    public boolean hasWeapon(){
        if(weapon!=null){
            return true;
        }
        return false;
    }
    private int getBaseAttack(){
        if(warrior instanceof  WarriorWithWeapon warriorWithWeapon){
            return warriorWithWeapon.getBaseAttack();
        }
        return warrior.getAttackDamage();
    }
    private int getBonusHealth(){
        if(warrior instanceof WarriorWithWeapon warriorWithWeapon){
            int res = warriorWithWeapon.getBonusHealth() + weapon.getHealthBonus();
            return res;
        }
        if(!hasWeapon()){
            return 0;
        }
        return weapon.getHealthBonus();
    }

    private int getBaseHealth(){
        if(warrior instanceof  WarriorWithWeapon warriorWithWeapon){
            return warriorWithWeapon.getBaseHealth();
        }
        return warrior.getHealthBar();
    }
    @Override
    public int getAttackDamage() {
        return getBonusAttack()+getBaseAttack();
    }

    @Override
    public int getHealthBar() {
        return getBaseHealth()+getBonusHealth();
    }
    @Override
    public void setHealthBar(int healthBar) {
        warrior.setHealthBar(healthBar);
    }
    @Override
    public void receiveDamage(HasAttack damager) {
        warrior.receiveDamage(damager);
    }

}
