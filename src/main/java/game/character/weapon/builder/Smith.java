package game.character.weapon.builder;

import game.character.weapon.OddWeapon;

public class Smith implements Builder {
    private OddWeapon weapon;

    public Smith() {
        this.reset();
    }

    @Override
    public void reset() {
        this.weapon = new OddWeapon();
    }

    @Override
    public void setAttack(int attack) {
        this.weapon.setAttack(attack);
    }

    @Override
    public void setDefense(int defense) {
        this.weapon.setDefense(defense);
    }

    @Override
    public void setVampirism(int vampirism) {
        this.weapon.setVampirism(vampirism);
    }

    @Override
    public void setHealth(int health) {
        this.weapon.setHealth(health);
    }

    @Override
    public void setHealthpower(int healthpower) {
        this.weapon.setHealthpower(healthpower);
    }

    public OddWeapon getWeapon() {
        OddWeapon product = weapon;
        this.reset();
        return product;
    }
}
