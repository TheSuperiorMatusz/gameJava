package game.character;

import game.character.characteristic.CanReceiveDamage;
import game.character.characteristic.KnowsDamageDealt;
import game.character.characteristic.WarriorInArmy;

public class Lancer extends Warrior implements KnowsDamageDealt {
    private final static int PENETRATION= 50;

    public Lancer() {
        super(50,6);
    }

    @Override
    public void hit(CanReceiveDamage opponent) {
        int damageDealt = hitAndReportDamage(opponent);
        if(opponent instanceof WarriorInArmy unitInArmy) {
            var theSecond = unitInArmy.getNextBehind();
            if (theSecond != null) {
                int damageToTheSecond = damageDealt * PENETRATION / 100;
                theSecond.receiveDamage(() -> damageToTheSecond);
            }
        }
    }
}
