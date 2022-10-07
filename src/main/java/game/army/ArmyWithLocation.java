package game.army;

import game.battlefield.location.Location;
import game.character.WarriorWithWeapon;

import java.util.function.Supplier;

public class ArmyWithLocation {
    private Army army;
    private Location location;

    public ArmyWithLocation(){
        this.army= new Army();
        this.location=new Location();
    }
    public ArmyWithLocation(Location location){
        this.location = location;
    }
    public void addUnits(Supplier<WarriorWithWeapon> factory, int quantity){
        army.addUnits(factory,quantity);
    }
    public WarriorWithWeapon unitAtPosition(int position){
        return army.unitAtPosition(position);
    }


}
