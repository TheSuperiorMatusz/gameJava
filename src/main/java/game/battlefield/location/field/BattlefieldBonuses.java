package game.battlefield.location.field;

public interface BattlefieldBonuses {
    default int attackerBonus(){
        return 0;
    }
    default int defenderBonus(){
        return 0;
    }
}
