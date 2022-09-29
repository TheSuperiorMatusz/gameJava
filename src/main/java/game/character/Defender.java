package game.character;

import game.character.characteristic.HasAttack;

public class Defender extends Warrior{
    private static final int DEFENSE = 2;

    public Defender() {
       super(60,3);
    }
    protected int getDefense(){
        return DEFENSE;
    }
    @Override
    public void receiveDamage(HasAttack damager) {
        int reduceDamage=Math.max(0,damager.getAttackDamage() - getDefense()  );
        super.receiveDamage(() -> reduceDamage);
    }

}
