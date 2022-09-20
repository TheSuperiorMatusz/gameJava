package game.character;

public class Vampire extends Warrior{
    private static final double VAMPIRISM = 0.5;
    private static final int MAX_HEALTH_BAR = 40;
    public Vampire() {
        super(40,4);
    }

    @Override
    public int getAHit(int damage) {
        super.getAHit(damage);
        return 0;
    }
}
