package be.cegeka.battle;

public interface HeadQuarters {
    int reportEnlistment(String soldierName);
    void reportCasualty(int soldierId);
    void reportVictory(int remainingNumberOfSoldiers);
}