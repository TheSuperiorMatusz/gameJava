package game.character;

import game.character.characteristic.HasAttack;
import game.character.weapon.predefined.specyfication.WeaponBasicBonuses;

public class WarriorWithWeapon extends Warrior {
    private Warrior warrior;
    private WeaponBasicBonuses weapon=null;
    private  int maxHealthWithBonus;



    public WarriorWithWeapon() {
        this.warrior = new Warrior();
        this.maxHealthWithBonus = warrior.getInitialHealthBar();

    }
    protected WarriorWithWeapon(int health,int attack){
        this.warrior= new Warrior(health,attack);
        this.maxHealthWithBonus = warrior.getInitialHealthBar();
    }
    private WarriorWithWeapon(Warrior warrior, WeaponBasicBonuses weapon){
        this.warrior=warrior;
        this.weapon=weapon;
        this.maxHealthWithBonus = Math.min(0,getBaseHealth()+getBonusHealth());
    }

    public void equipWeapon(WeaponBasicBonuses weapon) {
        if (hasWeapon()) {
            Warrior warrior1 = this.warrior;
            this.warrior = new WarriorWithWeapon(warrior1, this.weapon);
            this.weapon=weapon;
        }else {
            this.weapon = weapon;
        }
    }

    protected Warrior getWarrior(){
        return warrior;
    }
    protected WeaponBasicBonuses getWeapon() {
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
        return getBonusAttack()+getBaseAttack() > 0 ? getBonusAttack()+getBaseAttack() : 0;
    }
    @Override
    public int getHealthBar() {
        return this.maxHealthWithBonus;
    }
    @Override
    public void setHealthBar(int healthBar) {
        this.maxHealthWithBonus = Math.min(getBonusHealth()+getBaseHealth(),healthBar);
    }
    @Override
    public void receiveDamage(HasAttack damager) {
        setHealthBar(getHealthBar()-damager.getAttackDamage());
    }

}
