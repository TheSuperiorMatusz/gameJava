package org.example;

import game.battlefield.location.Location;
import game.battlefield.location.field.River;
import game.battlefield.weather.Snow;
import game.battlefield.weather.Sunny;
import game.battlefield.weather.Windy;

public class Main {
    public static void main(String[] args) {
        /*var myArmy = new Army();
        myArmy.addUnits(WarLord::new, 1);
        myArmy.addUnits(WarriorWithWeapon::new, 2);
        myArmy.addUnits(Lancer::new, 2);
        myArmy.addUnits(Healer::new, 2);

        var enemyArmy = new Army();
        enemyArmy.addUnits(WarLord::new, 3);
        enemyArmy.addUnits(Vampire::new, 1);
        enemyArmy.addUnits(Healer::new, 2);
        enemyArmy.addUnits(Knight::new, 2);
        var it = myArmy.firstAlive();
        System.out.println();
        while (it.hasNext()){
            System.out.println(it.next().getAttackDamage());

        }
        myArmy.moveUnits();
        enemyArmy.moveUnits();
        Battle.fight(myArmy, enemyArmy);*/

        Location location = new Location();
        location.newWeather(new Snow());
        System.out.println(location.attackerBonus());
        System.out.println(location.defenderBonus());
        location.newWeather(new Windy());
        System.out.println(location.attackerBonus());
        System.out.println(location.defenderBonus());
        Location location1 = new Location(new River());
        System.out.println(location1.attackerBonus());
        System.out.println(location1.defenderBonus());
        location1.newWeather(new Sunny());
        System.out.println(location1.attackerBonus());
        System.out.println(location1.defenderBonus());
        location1.newWeather(new Windy());
        System.out.println(location1.attackerBonus());
        System.out.println(location1.defenderBonus());

    }
}
