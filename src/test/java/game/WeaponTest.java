package game;

import game.army.Army;
import game.battle.Battle;
import game.character.*;
import game.character.weapon.OddWeapon;
import game.character.weapon.builder.WeaponShop;
import game.character.weapon.predefined.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeaponTest {
    @ParameterizedTest
    @DisplayName("Fights with weapon")
    @MethodSource("provideWeaponsforFights")
    void fightsWithWeaponTests(WarriorWithWeapon warrior1,WarriorWithWeapon warrior2,boolean expected){
        boolean isFirstWinner = Battle.fight(warrior1,warrior2);
        assertEquals(isFirstWinner,expected);
    }


    private static Stream<Arguments> provideWeaponsforFights(){
        var unit_1= new WarriorWithWeapon();
        var unit_2 = new Vampire();
        WeaponShop weaponShop = new WeaponShop();
        var weapon1= weaponShop.orderWeapon(-10,5,0,40,0);
        unit_1.equipWeapon(weapon1);
        unit_2.equipWeapon(new Sword());
        var unit_3 = new Defender();
        var unit_4 = new Lancer();
        unit_3.equipWeapon(new Shield());
        unit_4.equipWeapon(new GreatAxe());
        var unit_5 = new Healer();
        var unit_6 = new Knight();
        unit_5.equipWeapon(new MagicWand());
        unit_6.equipWeapon(new Katana());
        var unit_7 = new Defender();
        var unit_8 = new Vampire();
        Shield shield = new Shield();
        MagicWand magicWand = new MagicWand();
        Shield shield1= new Shield();
        Katana katana = new Katana();
        unit_7.equipWeapon(shield);
        unit_7.equipWeapon(magicWand);
        unit_8.equipWeapon(shield1);
        unit_8.equipWeapon(katana);

        return Stream.of(
                Arguments.of(unit_1,unit_2,true),
                Arguments.of(unit_3, unit_4,false),
                Arguments.of(unit_5,unit_6,false),
                Arguments.of(unit_7,unit_8,false)
        );
    }
    @ParameterizedTest
    @DisplayName("Armies with weapon")
    @MethodSource("provideWeaponsforBattles")
    void battlesWithWeaponTests(Army army1, Army army2, boolean expected){
        boolean isFirstWinner = Battle.fight(army1,army2);
        assertEquals(isFirstWinner,expected);
    }
    private static Stream<Arguments> provideWeaponsforBattles(){
        Katana katana = new Katana();
        Shield shield = new Shield();
        Army army1 = new Army();
        Army army2 = new Army();
        army1.addUnits(Defender::new,2);
        army2.addUnits(Knight::new,1);
        army2.addUnits(Vampire::new,1);
        army1.equipWarriorAtPosition(0,katana);
        army1.equipWarriorAtPosition(1,shield);
        army2.equipWarriorAtPosition(0,katana);
        army2.equipWarriorAtPosition(1,katana);
        WeaponShop weaponShop = new WeaponShop();
        OddWeapon weapon1 = weaponShop.orderWeapon(-20,6,1,40,-2);
        OddWeapon weapon2 = weaponShop.orderWeapon(20,-2,2,-55,3);
        Army army3 = new Army();
        Army army4 = new Army();
        army3.addUnits(Knight::new,3);
        army4.addUnits(WarriorWithWeapon::new,1);
        army4.addUnits(Defender::new,2);
        army3.equipWarriorAtPosition(0,weapon1);
        army3.equipWarriorAtPosition(1,weapon1);
        army3.equipWarriorAtPosition(2,weapon2);
        army4.equipWarriorAtPosition(0,weapon1);
        army3.equipWarriorAtPosition(1,weapon2);
        army3.equipWarriorAtPosition(2,weapon2);
        OddWeapon weapon3 = weaponShop.orderWeapon(-20, 1, 1, 40, -2);
        OddWeapon weapon4 = weaponShop.orderWeapon(20, 2, 2, -55, 3);
        Army army5 = new Army();
        Army army6 = new Army();
        army5.addUnits(Vampire::new,3);
        army6.addUnits(WarriorWithWeapon::new,1);
        army6.addUnits(Defender::new,2);
        army5.equipWarriorAtPosition(0,weapon3);
        army5.equipWarriorAtPosition(1,weapon3);
        army5.equipWarriorAtPosition(2,weapon3);
        army6.equipWarriorAtPosition(0,weapon3);
        army6.equipWarriorAtPosition(1,weapon4);
        army6.equipWarriorAtPosition(2,weapon4);
        Army army7 = new Army();
        Army army8 = new Army();
        army7.addUnits(Vampire::new,2);
        army7.addUnits(Rookie::new,2);
        army8.addUnits(WarriorWithWeapon::new,1);
        army8.addUnits(Defender::new,2);
        army7.equipWarriorAtPosition(0,katana);
        army7.equipWarriorAtPosition(1,katana);
        army7.equipWarriorAtPosition(2,shield);
        army8.equipWarriorAtPosition(0,katana);
        army8.equipWarriorAtPosition(1,shield);
        army8.equipWarriorAtPosition(2,shield);
        GreatAxe greatAxe=new GreatAxe();
        Army army9 = new Army();
        Army army10 = new Army();
        army9.addUnits(Vampire::new,3);
        army10.addUnits(WarriorWithWeapon::new,1);
        army10.addUnits(Defender::new,1);
        army9.equipWarriorAtPosition(0,greatAxe);
        army9.equipWarriorAtPosition(1,greatAxe);
        army9.equipWarriorAtPosition(2,greatAxe);
        army10.equipWarriorAtPosition(0,new Sword());
        army10.equipWarriorAtPosition(1,new Sword());
        Army army11 = new Army();
        Army army12 = new Army();
        army11.addUnits(Rookie::new,3);
        army12.addUnits(Defender::new,1);
        army12.addUnits(Healer::new,1);
        MagicWand  magicWand = new MagicWand();
        army11.equipWarriorAtPosition(0,katana);
        army11.equipWarriorAtPosition(1,katana);
        army11.equipWarriorAtPosition(2,katana);
        army12.equipWarriorAtPosition(0,magicWand);
        army12.equipWarriorAtPosition(1,magicWand);





        return Stream.of(
                Arguments.of(army1,army2,false),
                Arguments.of(army3, army4,true),
                Arguments.of(army5,army6,false),
                Arguments.of(army7,army8,true),
                Arguments.of(army9,army10,true),
                Arguments.of(army11,army12,false)
        );
    }
}
