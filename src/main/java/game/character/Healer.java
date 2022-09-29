package game.character;

public class Healer extends Warrior {
    private static final int HEALING_POINT = 2;
    public Healer() {
        super(60,0);
    }

    public void heal(Warrior woundedWarrior){
        woundedWarrior.setHealthBar(woundedWarrior.getHealthBar()+ HEALING_POINT);
    }
}
