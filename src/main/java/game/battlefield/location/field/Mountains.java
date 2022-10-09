package game.battlefield.location.field;

public class Mountains extends Valley {
    @Override
    public int attackerBonus() {
        return 0;
    }

    @Override
    public int defenderBonus() {
        return 2;
    }
}
