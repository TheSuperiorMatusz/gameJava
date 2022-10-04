package game.character.weapon.builder;

public interface Builder {
    void reset();
    void setAttack(int attack);
    void setDefense(int defense);
    void setVampirism(int vampirism);
    void setHealth(int health);
    void setHealthpower(int healthpower);

}
