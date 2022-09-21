package game.character;

import game.commander.SimpleDamage;

public class Vampire extends Warrior{
    private static final int VAMPIRISM = 50;
    private static final int MAX_HEALTH_BAR = 40;
    public Vampire() {
        super(40,4);
    }

    @Override
    public void hit(Warrior opponent) {
        int damageTooponent =opponent.receiveDamage(new SimpleDamage(getAttackDamage(),this));
        int addHealth = (int)((double) damageTooponent * (double) VAMPIRISM/100);
        if(getHealthBar()<MAX_HEALTH_BAR){
            setHealthBar(getHealthBar()+addHealth);
            if(getHealthBar()>MAX_HEALTH_BAR){
                setHealthBar(40);
            }
        }

    }
}
