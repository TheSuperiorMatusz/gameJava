package game.battlefield.location.field;

public class Valley extends PlainField {
    @Override
    public int attackerBonus() {
        return -5;
    }

    @Override
    public int defenderBonus() {
        return 8;
    }
}
