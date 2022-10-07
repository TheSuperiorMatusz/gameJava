package game.army;

import game.character.Healer;
import game.character.WarLord;
import game.character.Warrior;
import game.character.WarriorWithWeapon;
import game.character.characteristic.CanReceiveDamage;
import game.character.characteristic.HasAttack;
import game.character.characteristic.WarriorInArmy;
import game.character.weapon.specyfication.WeaponBasicBonuses;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

public class Army implements Iterable<WarriorWithWeapon> {
    public int getSize() {
        return size;
    }
    private int size=0;

    private  class Node
            extends WarriorWithWeapon
            implements WarriorInArmy {
        WarriorWithWeapon warrior;
        Node next;

        public Node(WarriorWithWeapon warrior) {
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

        @Override
        public void equipWeapon(WeaponBasicBonuses weapon) {
            warrior.equipWeapon(weapon);
        }

        public void healthUnit(Warrior wounded){
            if(next != head){
                if (warrior instanceof Healer healer){
                    healer.heal(wounded);
                }
                next.healthUnit(warrior);
            }

        }

        @Override
        public WarriorWithWeapon getWarrior() {
            return warrior;
        }
    }

    private final Node head=new Node(null);
    private  Node tail=head;

    private WarriorWithWeapon peek(){
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
    private void addToTail(WarriorWithWeapon warrior){
        var node = new Node(warrior);
        node.next = head;
        tail.next = node;
        tail = node;
        size++;
    }
    public void equipWarriorAtPosition(int position, WeaponBasicBonuses weapon){
        position=Math.max(0,position);
        var unit = this.iterator();
        int i =0;
        WarriorWithWeapon warrior=null;
        while (unit.hasNext() && i<=position) {
            warrior = unit.next();
            i++;
        }
        warrior.equipWeapon(weapon);
    }
    private String typeofWarrior(String typeofWarrior){
        return typeofWarrior;
    }
    public void addUnits(Supplier<WarriorWithWeapon> factory, int quantity){
        String typeofWarrior=typeofWarrior(factory.get().getClass().getSimpleName());

        if(typeofWarrior.equals("WarLord")){
            quantity=1;
        }
        for (int i=0; i<quantity;i++){
            addToTail(factory.get());
        }

    }
    public void removeDeadBodies(){
        var it = iterator();
        while (it.hasNext()){
            if(!it.next().isAlive()){
                it.remove();
            }
        }
    }
    private void removeAll() {
        var it = iterator();
        while (it.hasNext()) {
            if (it.next() instanceof WarriorWithWeapon) {
                it.remove();
            }
        }
        tail=head;
    }
    private List toList(){
        var iterator = iterator();
        List<WarriorWithWeapon> specificWarriors= new LinkedList();
        while (iterator.hasNext()){
            specificWarriors.add(iterator.next());
        }
        return specificWarriors;
    }
    private List specific_Units(String specificUnit) {
        List <WarriorWithWeapon> specificWarriors = toList();
        var it = specificWarriors.iterator();
        while (it.hasNext()){
            if(!it.next().getClass().getSimpleName().equals(specificUnit)){
                it.remove();
            }
        }

        return specificWarriors;
        }
        private List attackers(){
            List <WarriorWithWeapon> attackers=toList();
            var it = attackers.iterator();
            while (it.hasNext()){
                if(it.next().getAttackDamage()==0){
                    it.remove();
                }
            }
            if(attackers.get(0) instanceof WarLord){
                attackers.remove(0);
            }
            return attackers;
        }
    private int position(int position){
        if(position<0){
            System.out.println(position);
            position =position+size;
            System.out.println(position);
        }
        return position;
    }
    public WarriorWithWeapon unitAtPosition(int position){
        position=position(position);
        System.out.println(position);
        var unit = this.iterator();
        int i =0;
        System.out.println(position);
        WarriorWithWeapon warrior=null;
        while (unit.hasNext() && i<=position) {
            warrior = unit.next();
            System.out.println(warrior);
            System.out.println(i);
            i++;
        }
        System.out.println(warrior.getClass().getSimpleName());
        return warrior;
    }



    public void moveUnits() {
        List<WarriorWithWeapon> warlord = specific_Units("WarLord");
        if (warlord.size() == 1) {
            List<WarriorWithWeapon> healers = specific_Units("Healer");
            List<WarriorWithWeapon> lineup = specific_Units("Lancer");
            List<WarriorWithWeapon> others = attackers();
            lineup.addAll(others);
            lineup.addAll(1, healers);
            lineup.addAll(warlord);
            removeAll();
            for (int i = 0; i < lineup.size(); i++) {
                lineup.get(i).getClass().getSimpleName();
                addToTail(lineup.get(i));
            }
        }
    }


    public Iterator<WarriorWithWeapon> firstAlive(){
        return new FirstAliveIterator();
    }
    @Override
    public Iterator<WarriorWithWeapon> iterator() {
        return new simpleIterator();
    }
    private class FirstAliveIterator implements Iterator<WarriorWithWeapon>{

        @Override
        public boolean hasNext() {
            while (!isEmpty() && !peek().isAlive()){
                removeFromHead();
            }
            return !isEmpty();
        }

        @Override
        public WarriorWithWeapon next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            var res = peek();
            return res == head ? null : res ;
        }
    }

    private class simpleIterator implements Iterator<WarriorWithWeapon>{
        Node cursor = head;
        Node prev = null;
        @Override
        public boolean hasNext() {
            return cursor.next != head;
        }

        @Override
        public WarriorWithWeapon next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            prev = cursor;
            cursor = cursor.next;
            return cursor.warrior;
        }
        @Override
        public void remove() {
            if(prev == null){
                throw new IllegalStateException();
            }
            prev.next = cursor.next;
            cursor = prev;
            prev = null;
            size--;
        }

    }



}
