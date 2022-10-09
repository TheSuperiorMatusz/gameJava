package game.character.weapon;

import game.character.weapon.predefined.specyfication.AllWeaponBonuses;

public class OddWeapon implements AllWeaponBonuses {

    private int attack;
    private int defense;
    private int vampirism;
    private int health;
    private int healthpower;

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setVampirism(int vampirism) {
        this.vampirism = vampirism;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setHealthpower(int healthpower) {
        this.healthpower = healthpower;
    }

    @Override
    public int getHealthBonus() {
        return health;
    }

    @Override
    public int getAttackBonus() {
        return attack;
    }

    @Override
    public int getDeffenseBonus() {
        return defense;
    }

    @Override
    public int getHealtPowerBonus() {
        return healthpower;
    }

    @Override
    public int getVampirismBonus() {
        return vampirism;
    }
}
