package game.character;

public class WarLord extends Defender {
    private static final int DEFENSE = 4;
    public WarLord(){
        super(100,4);
    }

    @Override
    public int basicDefense() {
        return DEFENSE;
    }
}
