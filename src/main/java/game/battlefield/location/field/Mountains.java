package game.battlefield.location.field;

public class Mountains extends Valley {
    @Override
    public int attackerBonus() {
        return -5;
    }

    @Override
    public int defenderBonus() {
        return 15;
    }
}
