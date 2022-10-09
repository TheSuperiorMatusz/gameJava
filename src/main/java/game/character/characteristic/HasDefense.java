package game.character.characteristic;

public interface HasDefense extends WeaponDefenceBonus {
     int basicDefense();
     int bonusDefense();

    default int totalDefense(){
        return basicDefense()+bonusDefense();
    }
}
