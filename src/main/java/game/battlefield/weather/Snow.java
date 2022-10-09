package game.battlefield.weather;

public class Snow implements WeatherBonuses{
    @Override
    public int attackerBonus() {
        return -1;
    }

    @Override
    public int defenderBonus() {
        return -1;
    }
}
