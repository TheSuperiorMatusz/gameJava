package game;

import game.army.Army;
import game.battle.Battle;
import game.character.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WarlordTest {
    @Test
    @DisplayName("WarlordTest")
    void testWarlord(){
        var ronald = new WarLord();
        var heimdall = new Knight();

        assert Battle.fight(heimdall, ronald) == false;

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

// you can provide any other interface for testing the order
       assert myArmy.unitAtPosition(0).getClass() == Lancer.class;
        assert myArmy.unitAtPosition(1).getClass() == Healer.class;
// negative index means from the last position, so -1 == last
        System.out.println(myArmy.unitAtPosition(-1).getClass());
        assert myArmy.unitAtPosition(-1).getClass() == WarLord.class;


      assert enemyArmy.unitAtPosition(-1).getClass() == WarLord.class;
      assert enemyArmy.unitAtPosition(-2).getClass() == Knight.class;
//6, not 8, because only 1 Warlord per army could be
        assert enemyArmy.getSize() == 6;

       assert Battle.fight(myArmy, enemyArmy) == true;



    }
}
