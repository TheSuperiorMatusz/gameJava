package game.battlefield.location.field;

public class Valley extends PlainField {
    @Override
    public int attackerBonus() {
        return -1;
    }

    @Override
    public int defenderBonus() {
        return 1;
    }
}
