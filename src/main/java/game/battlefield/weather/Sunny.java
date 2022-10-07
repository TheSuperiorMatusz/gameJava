package game.battlefield.weather;

public class Sunny implements WeatherBonuses {
    @Override
    public int attackerBonus() {
        return 5;
    }

    @Override
    public int defenderBonus() {
        return 5;
    }
}
