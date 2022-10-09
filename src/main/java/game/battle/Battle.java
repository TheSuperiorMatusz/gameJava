package game.battle;

import game.army.Army;
import game.army.ArmyWithLocation;
import game.battlefield.location.Location;
import game.character.Warrior;

public class Battle {

   public static boolean fight(Warrior warrior1, Warrior warrior2){
       Warrior attacker = warrior1;
       Warrior defender = warrior2;
       while (attacker.isAlive()){
           attacker.hit(defender);
           Warrior swap = attacker;
           attacker = defender;
           defender = swap;

       }
       return warrior1.isAlive();
   }
 /*  public static boolean fight(Army firstArmy,Army secondArmy){
       Queue<Warrior> armyAttacking =  firstArmy.getArmy();
       Queue<Warrior> armyDefending = secondArmy.getArmy();
       Warrior warriorAttacking  = armyAttacking.peek();
       Warrior warriorDefending = armyDefending.peek();

       while (true){
          boolean isFirstWarriorWinner =fight(warriorAttacking,warriorDefending);

           if(isFirstWarriorWinner){
               armyDefending.remove();
               warriorDefending = armyDefending.peek();
           }else {
               armyAttacking.remove();
               warriorAttacking = armyAttacking.peek();
           }

           if(armyAttacking.isEmpty()){
               return false;
           }
           if(armyDefending.isEmpty()){
               return true;
           }
       }
   }*/
    public static boolean fight(Army army1, Army army2){

        var it1 = army1.firstAlive();
        var it2 = army2.firstAlive();

        while (it1.hasNext() && it2.hasNext()){
            fight(it1.next(),it2.next());
        }

        return it1.hasNext();
    }

    public static boolean straightFight(Army firstAmry, Army secondArmy) {
        while (true) {
            var iterableFirstArmy = firstAmry.iterator();
            var iterableSecondArmy = secondArmy.iterator();

            if(!iterableFirstArmy.hasNext()){
                return false;
            }
            if(!iterableSecondArmy.hasNext()){
                return true;
            }

            while (iterableFirstArmy.hasNext() && iterableSecondArmy.hasNext()) {
                fight(iterableFirstArmy.next(), iterableSecondArmy.next());
            }
            firstAmry.removeDeadBodies();
            secondArmy.removeDeadBodies();

        }
    }
    public static boolean weatherBattle(Location location
            , Army firstArmy, Army secondArmy){
        ArmyWithLocation attackingarmy = new ArmyWithLocation(firstArmy,true,location);
        ArmyWithLocation defendingArmy = new ArmyWithLocation(secondArmy,false,location);
       var attackingIterator = attackingarmy.iterator();
        var defendingIterator = defendingArmy.iterator();
        while (defendingIterator.hasNext() && attackingIterator.hasNext()){
            System.out.println(attackingIterator.next().getAttackDamage() + "now bonuses");
            System.out.println(defendingIterator.next().getAttackDamage());
        }
       return fight(attackingarmy.getArmy(),defendingArmy.getArmy());
    }
}
