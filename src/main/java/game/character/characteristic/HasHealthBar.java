package game.character.characteristic;

public interface HasHealthBar {
    int getHealthBar();
    void setHealthBar(int healt);
    default boolean isAlive() {
        return getHealthBar() > 0;
    }
}
