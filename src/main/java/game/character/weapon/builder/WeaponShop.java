package game.character.weapon.builder;

import game.character.weapon.OddWeapon;

public class WeaponShop {
    Smith smith = new Smith();

    public OddWeapon orderWeapon(int health,int attack, int defense,
                                 int vampirism, int healthPower){
        smith.reset();
        smith.setAttack(attack);
        smith.setHealth(health);
        smith.setDefense(defense);
        smith.setVampirism(vampirism);
        smith.setHealthpower(healthPower);
        return smith.getWeapon();

    }

}
