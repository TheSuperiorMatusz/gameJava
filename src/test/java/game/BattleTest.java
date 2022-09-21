package game;

import game.character.Defender;
import game.character.Knight;
import game.character.Vampire;
import game.character.Warrior;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class BattleTest {

    @Test
    @DisplayName("First duel")
    void testFight1() {
        var carl = new Warrior();
        var jim= new Knight();

        boolean battle = Battle.fight(carl,jim);

        assertFalse(battle);
    }
    @Test
    @DisplayName("Second duel")
    void testFight2(){
        var ramon= new Knight();
        var slevin= new Warrior();

        boolean battle = Battle.fight(ramon,slevin);

        assertTrue(battle);
    }

    @Test
    @DisplayName("Third duel")
    void testFight3(){
        var bob = new Warrior();
        var mars = new Warrior();

        Battle.fight(bob,mars);
        boolean isBobAlive = bob.isAlive();

        assertTrue(isBobAlive);
    }

    @Test
    @DisplayName("Fourth duel")
    void testFight4(){
        var zeus= new Knight();
        var godKiller= new Warrior();

        Battle.fight(zeus,godKiller);
        boolean isZeusAlive = zeus.isAlive();

        assertTrue(isZeusAlive);
    }

    @Test
    @DisplayName("Fith duel")
    void testFight5(){
        var husband = new Warrior();
        var wife = new Warrior();

        Battle.fight(husband,wife);
        boolean isWifeAlive = wife.isAlive();

        assertFalse(isWifeAlive);
    }
    @Test
    @DisplayName("Sixth duel")
    void testFight6(){
        var dragon = new Warrior();
        var knight = new Knight();

        Battle.fight(dragon,knight);
        boolean isKnightAlive= knight.isAlive();

        assertTrue(isKnightAlive);
    }

    @Test
    @DisplayName("Seventh duel")
    void testFight7(){
        var unit_1 = new Warrior();
        var unit_2 = new Knight();
        var unit_3 = new Warrior();

        Battle.fight(unit_1,unit_2);
        Battle.fight(unit_2,unit_3);
        boolean isUnit_2Alive = unit_2.isAlive();

        assertFalse(isUnit_2Alive);
    }
    @Test
    @DisplayName("Eight duel")
    void checkIfHealthRise(){
        var unit_1 = new Defender();
        var unit_2 = new Rookie();

        Battle.fight(unit_1,unit_2);

        assertEquals(unit_1.getHealthBar(),60);
    }
    @Test
    @DisplayName("Night fight")
    void testfight9(){
        var unit_1 = new Defender();
        var unit_2 = new Vampire();
        var unit_3 = new Warrior();


        assertTrue( Battle.fight(unit_1,unit_2));
    }

    @ParameterizedTest
    @DisplayName("Battle between two armies")
    @MethodSource("provideArmiesForBattle")
    void testBattleBetweenTwoArmies(Army firstArmy,Army secondArmy,boolean expected){
        boolean isAttackingArmyWinner = Battle.fight(firstArmy,secondArmy);
        assertEquals(expected,isAttackingArmyWinner);
    }

    private static Stream<Arguments> provideArmiesForBattle(){
        Army firstArmy = new Army();
        firstArmy.addUnits(Warrior:: new,1);
        Army secondArmy = new Army();
        secondArmy.addUnits(Warrior:: new,2);
        Army thirdArmy = new Army();
        thirdArmy.addUnits(Warrior:: new,2);
        Army fourthArmy = new Army();
        fourthArmy.addUnits(Warrior:: new,3);
        Army fithArmy = new Army();
        fithArmy.addUnits(Warrior:: new,5);
        Army sithArmy = new Army();
        sithArmy.addUnits(Warrior:: new,7);
        Army seventhArmy = new Army();
        seventhArmy.addUnits(Warrior:: new,20);
        Army eightArmy = new Army();
        eightArmy.addUnits(Warrior:: new,21);
        Army ninthArmy = new Army();
        ninthArmy.addUnits(Warrior:: new,10);
        Army tenthArmy = new Army();
        tenthArmy.addUnits(Warrior:: new,11);
        Army eleventhArmy = new Army();
        eleventhArmy.addUnits(Warrior:: new,11);
        Army twelvethArmy = new Army();
        twelvethArmy.addUnits(Warrior:: new,7);
        Army thirteenthArmy = new Army();
        thirteenthArmy.addUnits(Warrior::new,5);
        thirteenthArmy.addUnits(Defender::new,4);
        thirteenthArmy.addUnits(Defender::new,5);
        Army fourteenthArmy = new Army();
        fourteenthArmy.addUnits(Warrior::new,4);
        Army fiftteenthArmy = new Army();
        fiftteenthArmy.addUnits(Defender::new,5);
        fiftteenthArmy.addUnits(Warrior::new,20);
        fiftteenthArmy.addUnits(Defender::new,4);
        Army sixteenthArmy = new Army();
        sixteenthArmy.addUnits(Warrior::new,21);
        Army seventeenthArmy = new Army();
        Army eighteemteenth = new Army();
        seventeenthArmy.addUnits(Warrior::new,10);
        seventeenthArmy.addUnits(Defender::new,5);
        eighteemteenth.addUnits(Warrior::new,5);
        seventeenthArmy.addUnits(Defender::new,10);
        Army nineteenthArmy = new Army();
        Army twentythArmy = new Army();
        nineteenthArmy.addUnits(Defender::new,2);
        nineteenthArmy.addUnits(Warrior::new,1);
        nineteenthArmy.addUnits(Defender::new,1);
        twentythArmy.addUnits(Warrior::new,5);
        Army twentyFirst = new Army();
        Army twentyTwo = new Army();
        twentyFirst.addUnits(Defender::new,5);
        twentyFirst.addUnits(Vampire::new,6);
        twentyFirst.addUnits(Warrior::new,7);
        twentyTwo.addUnits(Warrior::new,6);
        twentyTwo.addUnits(Defender::new,6);
        twentyTwo.addUnits(Vampire::new,6);
        Army twentyThird = new Army();
        Army twentyFourth = new Army();
        twentyThird.addUnits(Defender::new,2);
        twentyThird.addUnits(Vampire::new,3);
        twentyThird.addUnits(Warrior::new,4);
        twentyFourth.addUnits(Warrior::new,4);
        twentyFourth.addUnits(Defender::new,4);
        twentyFourth.addUnits(Vampire::new,3);
        Army twentyFifth = new Army();
        Army twentySixt = new Army();
        twentyFifth.addUnits(Defender::new,11);
        twentyFifth.addUnits(Vampire::new,3);
        twentyFifth.addUnits(Warrior::new,4);
        twentySixt.addUnits(Warrior::new,4);
        twentySixt.addUnits(Defender::new,4);
        twentySixt.addUnits(Vampire::new,13);
        Army twentySeventh = new Army();
        Army twentyEight = new Army();
        twentySeventh.addUnits(Defender::new,9);
        twentySeventh.addUnits(Vampire::new,3);
        twentySeventh.addUnits(Warrior::new,8);
        twentyEight.addUnits(Warrior::new,4);
        twentyEight.addUnits(Defender::new,4);
        twentyEight.addUnits(Vampire::new,13);

        return Stream.of(
                Arguments.of(firstArmy,secondArmy,false),
                Arguments.of(thirdArmy,fourthArmy,false),
                Arguments.of(fithArmy,sithArmy,false),
                Arguments.of(seventhArmy,eightArmy,true),
                Arguments.of(ninthArmy,tenthArmy,true),
                Arguments.of(eleventhArmy,twelvethArmy,true),
                Arguments.of(thirteenthArmy,fourteenthArmy,true),
                Arguments.of(fiftteenthArmy,sixteenthArmy,true),
                Arguments.of(seventeenthArmy,eighteemteenth,true),
                Arguments.of(nineteenthArmy,twentythArmy,false),
                Arguments.of(twentyFirst, twentyTwo,false),
                Arguments.of(twentyThird, twentyFourth,false),
                Arguments.of(twentyFifth,twentySixt,true),
                Arguments.of(twentySeventh,twentyEight,true)
        );
    }
}