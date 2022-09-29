package game;

import game.character.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HealerTests {


    @ParameterizedTest
    @DisplayName("Battle between two armies with Lancers")
    @MethodSource("provideArmiesForBattle")
    void testBattleBetweenTwoArmiesWithLancers(Army firstArmy,Army secondArmy,boolean expected){
        boolean isAttackingArmyWinner = Battle.fight(firstArmy,secondArmy);
        assertEquals(expected,isAttackingArmyWinner);
    }

    private static Stream<Arguments> provideArmiesForBattle(){
        Army firstArmy = new Army();
        Army secondArmy = new Army();
        firstArmy.addUnits(Lancer::new,7);
        firstArmy.addUnits(Vampire::new,3);
        firstArmy.addUnits(Healer::new,1);
        firstArmy.addUnits(Warrior::new,4);
        firstArmy.addUnits(Healer::new,1);
        firstArmy.addUnits(Defender::new,2);
        secondArmy.addUnits(Warrior::new,4);
        secondArmy.addUnits(Defender::new,4);
        secondArmy.addUnits(Healer::new,1);
        secondArmy.addUnits(Healer::new,6);
        secondArmy.addUnits(Lancer::new,4);
        Army thirdsArmy = new Army();
        Army fourthsArmy = new Army();
        thirdsArmy.addUnits(Lancer::new,1);
        thirdsArmy.addUnits(Warrior::new,3);
        thirdsArmy.addUnits(Healer::new,1);
        thirdsArmy.addUnits(Warrior::new,4);
        thirdsArmy.addUnits(Healer::new,1);
        thirdsArmy.addUnits(Knight::new,2);
        fourthsArmy.addUnits(Warrior::new,4);
        fourthsArmy.addUnits(Defender::new,4);
        fourthsArmy.addUnits(Healer::new,1);
        fourthsArmy.addUnits(Vampire::new,6);
        fourthsArmy.addUnits(Lancer::new,4);

        return Stream.of(
                Arguments.of(firstArmy,secondArmy,true),
                Arguments.of(thirdsArmy, fourthsArmy,false)
        );
    }


}
