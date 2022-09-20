package game.character;

public class Defender extends Warrior{
    private static final int DEFENSE = 2;

    public Defender() {
       super(60,3);
    }

    @Override
    public int getAHit(int damage) {
         int realDamage = damage - DEFENSE;
         if(realDamage>0){
             int newHealthBar = this.getHealthBar() - realDamage;
             this.setHealthBar(newHealthBar);
             return realDamage;
         }else {
             return 0;
         }
    }
}
