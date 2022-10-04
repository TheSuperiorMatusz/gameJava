package org.example;

import game.Battle;
import game.character.Vampire;
import game.character.WarriorWithWeapon;
import game.character.weapon.OddWeapon;
import game.character.weapon.builder.WeaponShop;
import game.character.weapon.predefined.Sword;

public class Main {
    public static void main(String[] args) {
        var unit_1 = new WarriorWithWeapon();
        var unit_2 = new Vampire();
        WeaponShop weaponShop = new WeaponShop();
        OddWeapon weapon1 = weaponShop.orderWeapon(-10,5,0,40,0);
        Sword sword = new Sword();
        unit_1.equipWeapon(weapon1);
        unit_2.equipWeapon(sword);
        var unit_3 = new Vampire();
//        unit_2.hit(unit_1);
        unit_3.hit(unit_1);
        System.out.println(Battle.fight(unit_1,unit_3));


       /* var unit_3 = new Defender();
        var unit_4 = new Lancer();
        Shield shield=new Shield();
        GreatAxe greatAxe = new GreatAxe();
        unit_3.equipWeapon(shield);
        unit_4.equipWeapon(greatAxe);
        System.out.println(Battle.fight(unit_3,unit_4));

        var unit_5 = new Healer();
        var unit_6 = new Knight();
        MagicWand magicWand = new MagicWand();
        Katana katana = new Katana();
        unit_5.equipWeapon(magicWand);
        unit_6.equipWeapon(katana);
        System.out.println(Battle.fight(unit_5,unit_6));
*/
    }
}
