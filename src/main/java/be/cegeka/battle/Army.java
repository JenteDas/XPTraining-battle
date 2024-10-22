package be.cegeka.battle;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Soldier> soldiers;
    private Soldier frontMan;
    private HeadQuarters headQuarters;

    public Army() {
        this.soldiers = new ArrayList<>();
    }

    public Army(List<Soldier> soldiers) {
        this.soldiers = soldiers;
        this.frontMan = soldiers.getFirst();
    }

    public void enroll(Soldier soldier) {
        soldiers.add(soldier);
        soldier.setId(headQuarters.reportEnlistment(soldier.getName()));
        if (frontMan == null) {
            frontMan = soldier;
        }
    }

    public void killFrontMan() {
        soldiers.removeFirst();
        if (soldiers.isEmpty()) {
            frontMan = null;
        } else {
            replaceFrontMan();
        }
    }

    private void replaceFrontMan() {
        frontMan = soldiers.getFirst();
    }

    public Army fightWar(Army opponentArmy) {
        while (hasSoldiers() && opponentArmy.hasSoldiers()) {
            Soldier winner = frontMenFight(opponentArmy);
            if (winner == frontMan) {
                opponentArmy.killFrontMan();
            } else {
                killFrontMan();
            }
        }
        return hasSoldiers() ? this : opponentArmy;
    }

    private Soldier frontMenFight(Army opponentArmy) {
        return frontMan.attack(opponentArmy.getFrontMan());
    }

    public List<Soldier> getSoldiers() {
        return soldiers;
    }

    public boolean hasSoldiers() {
        return !soldiers.isEmpty();
    }

    public Soldier getFrontMan() {
        return frontMan;
    }
}
