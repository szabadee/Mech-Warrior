package com.flow.mechwarrior;

public class Cell {
    private Mech mech;
    private boolean standingOnIt;


    public void setStandingOnIt (boolean standingOnIt) {
        this.standingOnIt = standingOnIt;
    }

    public void setMech (Mech mech) {
        this.mech = mech;
    }

    public Mech getMech () {
        return mech;
    }

    public boolean getStandingOnIt () {
        return standingOnIt;
    }

    public boolean isBlockage () {
        return false;
    }

    @Override
    public String toString () {
        if (standingOnIt) {
            if (getMech() instanceof MechLight) {
                return getMech().toString();
            } else if (getMech() instanceof MechMedium) {
                return getMech().toString();
            } else if (getMech() instanceof MechHeavy) {
                return (getMech().toString());
            } else if (getMech() instanceof MechAssault) {
                return (getMech().toString());
            }
        } else if (isBlockage()) {
            return "<>";
        }

        return null;
    }
}
