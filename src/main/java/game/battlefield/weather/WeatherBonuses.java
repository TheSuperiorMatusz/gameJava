package game.battlefield.weather;

public interface WeatherBonuses {
    default int attackerBonus(){
        return 0;
    }
    default int defenderBonus(){
        return 0;
    }
}
