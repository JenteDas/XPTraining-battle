package be.cegeka.battle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ArmyTest {

    @Test
    void construction_anArmyWithSoldiersMustHaveAFrontMan() {
        Soldier soldier1 = new Soldier("name1");
        Soldier soldier2 = new Soldier("name2");
        Army army = new Army(List.of(soldier1, soldier2));

        assertThat(army.getFrontMan()).isEqualTo(soldier1);
    }

    @Test
    void construction_anArmyWithoutSoldiersMustNotHaveAFrontMan() {
        Army army = new Army();

        assertThat(army.getFrontMan()).isNull();
    }

    @Test
    void givenAnArmyWithoutFrontMan_whenEnrollSoldier_thenFrontManIsTheEnrolledSoldier() {
        Soldier soldier = new Soldier("name");
        Army army = new Army();

        army.enroll(soldier);

        assertThat(army.getFrontMan()).isEqualTo(soldier);
    }

    @Test
    void givenAnArmyWithFrontMan_whenEnrollSoldier_thenFrontManIsNotChanged() {
        Soldier soldier1 = new Soldier("name1");
        Soldier soldier2 = new Soldier("name2");
        Army army = new Army(new ArrayList<>(List.of(soldier1)));

        army.enroll(soldier2);

        assertThat(army.getFrontMan()).isEqualTo(soldier1);
    }

    @Test
    void givenArmy_whenFightsWarAgainstOpponentArmy_thenReturnLastManStanding() {
        Soldier soldier1 = new Soldier("name1", Weapon.AXE);
        Soldier soldier2 = new Soldier("name2", Weapon.BARE_FIST);
        Soldier soldier3 = new Soldier("name3", Weapon.BARE_FIST);
        Army army = new Army(new ArrayList<>(List.of(soldier1, soldier2, soldier3)));
        Soldier opponent1 = new Soldier("name1", Weapon.AXE);
        Soldier opponent2 = new Soldier("name2", Weapon.BARE_FIST);
        Soldier opponent3 = new Soldier("name3", Weapon.BARE_FIST);
        Army opponentArmy = new Army(new ArrayList<>(List.of(opponent1, opponent2, opponent3)));

        Army lastManStanding = army.fightWar(opponentArmy);

        assertThat(lastManStanding).isEqualTo(army);
    }

}
