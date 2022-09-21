package game;

import game.character.Warrior;

import java.util.Queue;

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
   public static boolean fight(Army firstArmy,Army secondArmy){
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
   }
}
