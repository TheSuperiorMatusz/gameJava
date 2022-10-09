package game.battlefield.location.field;

public class River extends PlainField {
    @Override
    public int attackerBonus() {
        return -2;
    }

    @Override
    public int defenderBonus() {
        return 2;
    }
}
