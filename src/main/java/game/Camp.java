package game;

import game.character.Knight;
import game.character.Warrior;

public class Camp {

    public Warrior getWarrior(String warriorType){
        warriorType = warriorType.toLowerCase();
        if(warriorType == null){
            return null;
        }
        if(warriorType.equals("warrior")){
            return new Warrior();
        }
        if(warriorType.equals("knight")){
            return new Knight();
        }

        return null;
    }

}
