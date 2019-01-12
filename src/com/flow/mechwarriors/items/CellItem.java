package com.flow.mechwarriors.items;


public class CellItem {
    private Mech mech;
    private Barrier barrier;
    private boolean isStandingOnIt;

    public Mech getMech () {
        return mech;
    }

    public Barrier getBarrier() {
        return barrier;
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

    public void setBarrier(Barrier barrier) {
        this.barrier = barrier;
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
            return "<>";
        }

        return null;
    }

}
