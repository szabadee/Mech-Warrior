package com.flow.mechwarriors.items;


public class BattlefieldItem implements Action {
    private Mech mech;
    private boolean isStandingOnIt;


    public Mech getMech () {
        return mech;
    }

    public boolean getStandingOnIt () {
        return isStandingOnIt;
    }

    public void setStandingOnIt (boolean isStandingOnIt) {
        this.isStandingOnIt = isStandingOnIt;
    }

    public void setMech (Mech mech) {
        this.mech = mech;
    }

    public boolean isBarrier () {
        return false;
    }

    @Override
    public String toString () {
        if (isStandingOnIt) {
            if (getMech() instanceof MechLight) {
                return getMech().toString();
            } else if (getMech() instanceof MechMedium) {
                return getMech().toString();
            } else if (getMech() instanceof MechHeavy) {
                return (getMech().toString());
            } else if (getMech() instanceof MechAssault) {
                return (getMech().toString());
            }
        } else if (isBarrier()) {
            return "X";
        }

        return null;
    }

    @Override
    public int maxStep() {
        return 6;
    }

    @Override
    public int maxAttack() {
        return 6;
    }

}
