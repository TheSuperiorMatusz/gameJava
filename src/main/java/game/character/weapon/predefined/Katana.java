package game.character.weapon.predefined;

import game.character.weapon.predefined.specyfication.AllWeaponBonuses;

public class Katana  implements AllWeaponBonuses {
    @Override
    public int getHealthBonus(){
        return -20;
    }

    @Override
    public int getAttackBonus(){
        return 6;
    }

    @Override
    public int getDeffenseBonus(){
        return -5;
    }

    @Override
    public int getVampirismBonus(){
        return 50;
    }

    @Override
    public int getHealtPowerBonus(){
        return 0;
    }
}
