package game.character;

import game.character.characteristic.CanReceiveDamage;
import game.character.characteristic.KnowsDamageDealt;

public class Vampire extends Warrior implements KnowsDamageDealt {
    private static final int VAMPIRISM = 50;
    public Vampire() {
        super(40,4);
    }

    @Override
    public void hit(CanReceiveDamage opponent) {
        int damageDealt = hitAndReportDamage(opponent);
        final int  percent = 100;
        int addHealth =  (damageDealt) * VAMPIRISM / percent;
        setHealthBar(getHealthBar() + addHealth);
        }

    }

