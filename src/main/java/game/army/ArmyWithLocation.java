package game.army;

import game.battlefield.location.Location;
import game.character.WarriorWithWeapon;

import java.util.Iterator;
import java.util.function.Supplier;

public class ArmyWithLocation {
    private Army army;
    private Location location;
    private boolean isAttacking;


    public Army getArmy() {
        return army;
    }

    public ArmyWithLocation(){
        this.army= new Army();
    }
    public ArmyWithLocation(Army army,boolean isAttacking,Location location){
        this.army= army;
        this.isAttacking = isAttacking;
        this.location = location;
        settingBonuses();
    }

    public ArmyWithLocation(Location location){
        this.location = location;
        settingBonuses();
    }
    private void settingBonuses(){
        var armyIterator = army.iterator();
        var amyBasicAttackGetter = army.iterator();
        while (armyIterator.hasNext()){
            int basicWarriorAttack = amyBasicAttackGetter.next().getAttackDamage();
            System.out.println(basicWarriorAttack + " This me");
            if(isAttacking){
                int locationAttackerBonus= location.attackerBonus();
                System.out.println(basicWarriorAttack + locationAttackerBonus + "Attack bonuses");
                armyIterator.next().setAttackDamage(basicWarriorAttack + locationAttackerBonus);
            }else {
                int locationDefenderBonus = location.defenderBonus();
                armyIterator.next().setAttackDamage(basicWarriorAttack + locationDefenderBonus);
            }
        }
    }
    public void addUnits(Supplier<WarriorWithWeapon> factory, int quantity){
        army.addUnits(factory,quantity);
    }
    public WarriorWithWeapon unitAtPosition(int position){
        return army.unitAtPosition(position);
    }

    public Iterator<WarriorWithWeapon> firstAlive(){
        return  army.firstAlive();
    }
    public Iterator<WarriorWithWeapon> iterator() {
        return army.iterator();
    }

}
