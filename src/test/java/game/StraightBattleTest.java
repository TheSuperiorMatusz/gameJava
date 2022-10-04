package game;

import game.character.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StraightBattleTest {
    @ParameterizedTest
    @DisplayName("Straight Battle Test")
    @MethodSource("provideArmiesForStraightBattle")
    void testBattleBetweenTwoArmiesWithLancers(Army firstArmy,Army secondArmy,boolean expected){
        boolean isAttackingArmyWinner = Battle.straightFight(firstArmy,secondArmy);
        assertEquals(expected,isAttackingArmyWinner);
    }
    private static Stream<Arguments> provideArmiesForStraightBattle(){
        Army firstArmy = new Army();
        Army secondArmy = new Army();
        firstArmy.addUnits(Lancer::new,5);
        firstArmy.addUnits(Vampire::new,3);
        firstArmy.addUnits(Warrior::new,4);
        firstArmy.addUnits(Defender::new,2);
        secondArmy.addUnits(Warrior::new,4);
        secondArmy.addUnits(Defender::new,4);
        secondArmy.addUnits(Vampire::new,6);
        secondArmy.addUnits(Lancer::new,5);
        Army thirdArmy = new Army();
        Army fourhtArmy = new Army();
        thirdArmy.addUnits(Lancer::new,7);
        thirdArmy.addUnits(Vampire::new,3);
        thirdArmy.addUnits(Warrior::new,4);
        thirdArmy.addUnits(Defender::new,2);
        fourhtArmy.addUnits(Warrior::new,4);
        fourhtArmy.addUnits(Defender::new,4);
        fourhtArmy.addUnits(Vampire::new,6);
        fourhtArmy.addUnits(Lancer::new,4);
        Army fifthArmy = new Army();
        Army sixthArmy = new Army();
        fifthArmy.addUnits(Lancer::new,7);
        fifthArmy.addUnits(Vampire::new,3);
        fifthArmy.addUnits(Healer::new,1);
        fifthArmy.addUnits(Warrior::new,4);
        fifthArmy.addUnits(Healer::new,1);
        fifthArmy.addUnits(Defender::new,2);
        sixthArmy.addUnits(Warrior::new,4);
        sixthArmy.addUnits(Defender::new,4);
        sixthArmy.addUnits(Healer::new,1);
        sixthArmy.addUnits(Vampire::new,6);
        sixthArmy.addUnits(Lancer::new,4);
        Army seventhArmy = new Army();
        Army eightArmy = new Army();
        seventhArmy.addUnits(Lancer::new,4);
        seventhArmy.addUnits(Warrior::new,3);
        seventhArmy.addUnits(Healer::new,1);
        seventhArmy.addUnits(Warrior::new,4);
        seventhArmy.addUnits(Healer::new,1);
        seventhArmy.addUnits(Knight::new,2);
        eightArmy.addUnits(Warrior::new,4);
        eightArmy.addUnits(Healer::new,1);
        eightArmy.addUnits(Vampire::new,2);
        eightArmy.addUnits(Lancer::new,4);


        return Stream.of(
                Arguments.of(firstArmy,secondArmy,false),
                Arguments.of(thirdArmy, fourhtArmy,true),
                Arguments.of(fifthArmy,sixthArmy,false),
                Arguments.of(seventhArmy,eightArmy,true)
        );
    }
}
