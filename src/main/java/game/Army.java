package game;

import game.character.Warrior;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Supplier;

public class Army {
    private Queue<Warrior> army = new ArrayDeque<>();

    public void addUnits(Supplier<Warrior> factory, int amount){

        for (int i=0; i<amount;i++){
            army.add(factory.get());
        }


    }

    public Queue<Warrior> getArmy() {
        return army;
    }
}
