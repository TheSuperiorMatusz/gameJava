package game;

import game.army.Army;
import game.battle.Battle;
import game.character.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BattleTestLancers {
    @ParameterizedTest
    @DisplayName("Battle between two armies with Lancers")
    @MethodSource("provideArmiesForBattle")
    void testBattleBetweenTwoArmiesWithLancers(Army firstArmy, Army secondArmy, boolean expected){
        boolean isAttackingArmyWinner = Battle.fight(firstArmy,secondArmy);
        assertEquals(expected,isAttackingArmyWinner);
    }
    private static Stream<Arguments> provideArmiesForBattle(){
        Army firstArmy = new Army();
        Army secondArmy = new Army();
        firstArmy.addUnits(Lancer::new,7);
        firstArmy.addUnits(Vampire::new,3);
        firstArmy.addUnits(WarriorWithWeapon::new,4);
        firstArmy.addUnits(Defender::new,2);
        secondArmy.addUnits(WarriorWithWeapon::new,4);
        secondArmy.addUnits(Defender::new,4);
        secondArmy.addUnits(Vampire::new,6);
        secondArmy.addUnits(Lancer::new,4);
        Army warriorsArmy = new Army();
        Army lancersArmy = new Army();
        warriorsArmy.addUnits(WarriorWithWeapon::new,2);
        lancersArmy.addUnits(Lancer::new,1);
        lancersArmy.addUnits(WarriorWithWeapon::new,1);

        return Stream.of(
                Arguments.of(firstArmy,secondArmy,true),
                Arguments.of(warriorsArmy,lancersArmy,false)
        );
    }
}
