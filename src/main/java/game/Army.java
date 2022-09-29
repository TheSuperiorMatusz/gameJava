package game;

import game.character.Healer;
import game.character.characteristic.CanReceiveDamage;
import game.character.characteristic.HasAttack;
import game.character.Warrior;
import game.character.characteristic.WarriorInArmy;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

public class Army implements Iterable<Warrior> {


    private  class Node
            extends Warrior
            implements WarriorInArmy {
        Warrior warrior;
        Node next;

        public Node(Warrior warrior) {
            this.warrior = warrior;
            this.next = this;
        }

        @Override
        public Warrior getNextBehind() {
            return next == head ? null : next;
        }

        @Override
        public void setHealthBar(int healthBar) {
            warrior.setHealthBar(healthBar);
        }

        @Override
        public int getAttackDamage() {
            return warrior.getAttackDamage();
        }

        @Override
        public int getHealthBar() {
            return warrior.getHealthBar();
        }

        @Override
        public void receiveDamage(HasAttack damager) {
            warrior.receiveDamage(damager);
        }

        @Override
        public void hit(CanReceiveDamage opponent) {
            warrior.hit(opponent);
            next.healthUnit(warrior);
        }

        public void healthUnit(Warrior wounded){
            if(next != head){
                if (warrior instanceof Healer healer){
                    healer.heal(wounded);
                }
                next.healthUnit(warrior);
            }

        }

    }

    private final Node head=new Node(null);
    private  Node tail=head;

    private Warrior peek(){
        return head.next;
    }
    boolean isEmpty(){
        return  tail == head;
    }
    private void removeFromHead(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        if(tail == head.next){
            tail = head;
        }
        head.next = head.next.next ;
    }
    private void addToTail(Warrior warrior){
        var node = new Node(warrior);
        node.next = head;
        tail.next = node;
        tail = node;


    }

    public void addUnits(Supplier<Warrior> factory, int quantity){

        for (int i=0; i<quantity;i++){
            addToTail(factory.get());
        }


    }
    public Iterator<Warrior> firstAlive(){
        return new FirstAliveIterator();
    }
    @Override
    public Iterator<Warrior> iterator() {
        return new simpleIterator();
    }
    private class FirstAliveIterator implements Iterator<Warrior>{

        @Override
        public boolean hasNext() {
            while (!isEmpty() && !peek().isAlive()){
                removeFromHead();
            }
            return !isEmpty();
        }

        @Override
        public Warrior next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            var res = peek();
            return res == head ? null : res ;
        }
    }

    private class simpleIterator implements Iterator<Warrior>{
        Node cursor = head;
        @Override
        public boolean hasNext() {
            return cursor.next != head;
        }
        @Override
        public Warrior next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            cursor = cursor.next;
            return cursor;
        }
    }



}
