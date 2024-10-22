package be.cegeka.battle;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SoldierTest {

    @Test
    void construction_aSoldierMustHaveAName() {
        Soldier soldier = new Soldier("name");

        assertThat(soldier.getName()).isEqualTo("name");
    }

    @Test
    void construction_aSoldierMustHaveAName_cannotBeNull() {
        assertThatThrownBy(() -> new Soldier(null))
                .hasMessage("A soldier must have a name")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void construction_aSoldierMustHaveAName_cannotBeEmpty() {
        assertThatThrownBy(() -> new Soldier(""))
                .hasMessage("A soldier must have a name")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void construction_aSoldierMustHaveAName_cannotBeBlank() {
        assertThatThrownBy(() -> new Soldier("     "))
                .hasMessage("A soldier must have a name")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void construction_aSoldierMustHaveAWeapon() {
        Soldier soldier = new Soldier("name", Weapon.AXE);

        assertThat(soldier.getWeapon()).isEqualTo(Weapon.AXE);
    }

    @Test
    void construction_aSoldierMustHaveAWeapon_defaultIsBareFist() {
        Soldier soldier = new Soldier("name");

        assertThat(soldier.getWeapon()).isEqualTo(Weapon.BARE_FIST);
    }

    @Test
    void givenOpponentHasWeakerWeapon_whenAttack_thenSoldierWins() {
        Soldier soldier = new Soldier("name", Weapon.AXE);
        Soldier opponent = new Soldier("opponent", Weapon.BARE_FIST);

        assertThat(soldier.attack(opponent)).isEqualTo(soldier);
    }

    @Test
    void givenOpponentHasEqualWeapon_whenAttack_thenSoldierWins() {
        Soldier soldier = new Soldier("name", Weapon.AXE);
        Soldier opponent = new Soldier("opponent", Weapon.AXE);

        assertThat(soldier.attack(opponent)).isEqualTo(soldier);
    }
}