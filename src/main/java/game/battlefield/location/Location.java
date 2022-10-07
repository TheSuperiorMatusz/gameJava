package game.battlefield.location;

import game.battlefield.location.field.PlainField;
import game.battlefield.weather.WeatherBonuses;

public class Location extends PlainField {
    private PlainField location;
    private WeatherBonuses weather=null;

    public Location(){
        this.location= new PlainField();
    }
    public Location(PlainField location){
        this.location=location;
    }
    private Location(PlainField location,WeatherBonuses weatherBonuses){
            this.location=location;
            this.weather = weatherBonuses;
    }
    public void newWeather(WeatherBonuses weather){
        if(hasWeather()) {
            PlainField prev = this.location;
            this.location = new Location(prev, this.weather);
            this.weather = weather;
        }else {
            this.weather=weather;
        }
    }

    private boolean hasWeather(){
        if(weather!=null){
            return true;
        }else {
            return false;
        }
    }
    private int locationAttackerBonus(){
        if(location instanceof Location location) {
            return location.locationAttackerBonus();
        }
        return location.attackerBonus();
    }
    private int weatherAttackerBonus()
    {
        if (location instanceof Location location) {
            int res = location.weatherAttackerBonus() + weather.attackerBonus();
            return res;
        }
        if (hasWeather()) {
            return weather.attackerBonus();
        }
        return 0;

    }
    @Override
    public int attackerBonus() {
        return locationAttackerBonus() + weatherAttackerBonus();
    }

    private int locationDefenderBonus(){
        if(location instanceof Location location) {
            return location.defenderBonus();
        }
        return location.defenderBonus();
    }
    private int weatherDefenderBonus()
    {
        if (location instanceof Location location) {
            int res = location.weatherDefenderBonus() + weather.defenderBonus();
            return res;
        }
        if (hasWeather()) {
            return weather.defenderBonus();
        }
        return 0;

    }

    @Override
    public int defenderBonus() {
        return locationDefenderBonus()+weatherDefenderBonus();
    }
}
