package game.character.characteristic;

public interface KnowsDamageDealt extends  HasAttack {
    default int hitAndReportDamage(CanReceiveDamage opponent){
        int healthOponentBeforeHit = opponent.getHealthBar();
         HasAttack.super.hit(opponent);
        int healtOponentAfterHit = opponent.getHealthBar();
        int damageDealt = healthOponentBeforeHit- healtOponentAfterHit;
        return damageDealt;
    }
}
