package be.cegeka.battle;


import com.google.common.base.Strings;

public class Soldier {

    private final String name;
    private Weapon weapon;
    private int id;

    public Soldier(String name, Weapon weapon) {
        if (Strings.isNullOrEmpty(name) || Strings.isNullOrEmpty(name.trim())) {
            throw new IllegalArgumentException("A soldier must have a name");
        }

        this.name = name;
        this.weapon = weapon;
    }

    public Soldier(String name) {
        this(name, Weapon.BARE_FIST);
    }

    public String getName() {
        return this.name;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public Soldier attack(Soldier opponent) {
        if (this.weapon.getAttackDamage() >= opponent.weapon.getAttackDamage()) {
            return this;
        }
        return opponent;
    }
}
