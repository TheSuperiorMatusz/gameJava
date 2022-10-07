package game.character.characteristic;

public interface HasDefense {
     int basicDefense();
     int bonusDefense();

    default int totalDefense(){
        return basicDefense()+bonusDefense();
    }
}
