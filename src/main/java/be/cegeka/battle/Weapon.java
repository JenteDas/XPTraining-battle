package be.cegeka.battle;

public enum Weapon {
    BARE_FIST(1),
    AXE(3),
    SWORD(2),
    SPEAR(2);

    private final int attackDamage;

    Weapon(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getAttackDamage() {
        return attackDamage;
    }
}