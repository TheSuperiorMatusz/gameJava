package game.battlefield.weather;

public class Sunny implements WeatherBonuses {
    @Override
    public int attackerBonus() {
        return 1;
    }

    @Override
    public int defenderBonus() {
        return 1;
    }
}
