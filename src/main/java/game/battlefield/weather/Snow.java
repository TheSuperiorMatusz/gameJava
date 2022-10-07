package game.battlefield.weather;

public class Snow implements WeatherBonuses{
    @Override
    public int attackerBonus() {
        return -10;
    }

    @Override
    public int defenderBonus() {
        return -10;
    }
}
