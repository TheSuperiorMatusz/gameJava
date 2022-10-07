package game.battlefield.weather;

public class Windy implements WeatherBonuses {
    @Override
    public int attackerBonus() {
        return -10;
    }

    @Override
    public int defenderBonus() {
        return -5;
    }
}
