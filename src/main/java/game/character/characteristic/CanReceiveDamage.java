package game.character.characteristic;

public interface CanReceiveDamage extends HasHealthBar {
    void receiveDamage(HasAttack damager);
}
