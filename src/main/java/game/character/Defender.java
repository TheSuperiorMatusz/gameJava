package game.character;

import game.commander.Damage;

public class Defender extends Warrior{
    private static final int DEFENSE = 2;

    public Defender() {
       super(60,3);
    }

    @Override
    protected int receiveDamage(Damage damage) {
         if( damage.getValue() - DEFENSE > 0){
             damage.setValue(damage.getValue()-DEFENSE);
             return super.receiveDamage(damage);
         }else {
             return 0;
         }
    }
}
