package org.example;

import game.army.Army;
import game.battle.Battle;
import game.battlefield.location.Location;
import game.battlefield.weather.Sunny;
import game.battlefield.weather.Windy;
import game.character.*;

public class Main {
    public static void main(String[] args) {
        var myArmy = new Army();
        myArmy.addUnits(WarLord::new, 1);
        myArmy.addUnits(WarriorWithWeapon::new, 2);
        myArmy.addUnits(Lancer::new, 2);
        myArmy.addUnits(Healer::new, 2);

        var enemyArmy = new Army();
        enemyArmy.addUnits(WarLord::new, 3);
        enemyArmy.addUnits(Vampire::new, 1);
        enemyArmy.addUnits(Healer::new, 2);
        enemyArmy.addUnits(Knight::new, 2);
        myArmy.moveUnits();
        enemyArmy.moveUnits();
        Lancer lancer = new Lancer();
        lancer.setAttackDamage(22);
        System.out.println(lancer.getAttackDamage());
        lancer.setHealthBar(22);

       Location location = new Location();
       location.newWeather(new Sunny());
       location.newWeather(new Windy());

        System.out.println(Battle.weatherBattle(location,myArmy,enemyArmy));

       /* Army firstArmy = new Army();
        Army secondArmy = new Army();
        firstArmy.addUnits(Lancer::new,5);
        firstArmy.addUnits(Vampire::new,3);
        firstArmy.addUnits(WarriorWithWeapon::new,4);
        firstArmy.addUnits(Defender::new,2);
        secondArmy.addUnits(WarriorWithWeapon::new,4);
        secondArmy.addUnits(Defender::new,4);
        secondArmy.addUnits(Vampire::new,6);
        secondArmy.addUnits(Lancer::new,5);
        System.out.println(Battle.fight(firstArmy,secondArmy));
        var myArmy = new Army();
        myArmy.addUnits(WarLord::new, 1);
        myArmy.addUnits(WarriorWithWeapon::new, 2);
        myArmy.addUnits(Lancer::new, 2);
        myArmy.addUnits(Healer::new, 2);

        var enemyArmy = new Army();
        enemyArmy.addUnits(WarLord::new, 3);
       enemyArmy.addUnits(Vampire::new, 1);
        enemyArmy.addUnits(Healer::new, 2);
        enemyArmy.addUnits(Knight::new, 2);

        myArmy.moveUnits();
        enemyArmy.moveUnits();
        Battle.fight(myArmy,enemyArmy);
*/
    }
}
