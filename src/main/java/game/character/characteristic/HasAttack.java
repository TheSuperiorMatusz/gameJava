package game.character.characteristic;

@FunctionalInterface
public interface HasAttack {
    int getAttackDamage();

    default void hit(CanReceiveDamage opponent) {
        opponent.receiveDamage(this);
    }
}
