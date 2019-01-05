package com.flow.mechwarrior;

public class Cell {
    private Mech mech;
    private boolean isStandingOnIt;
    private boolean isSelected;


    public void setStandingOnIt (boolean isStandingOnIt) {
        this.isStandingOnIt = isStandingOnIt;
    }

    public void setMech (Mech mech) {
        this.mech = mech;
    }

    public void setSelected (boolean selected) {
        isSelected = selected;
    }

    public Mech getMech () {
        return mech;
    }

    public boolean getStandingOnIt () {
        return isStandingOnIt;
    }

    public boolean getSelected () {
        return isSelected;
    }

    public boolean isBlockage () {
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
        } else if (isBlockage()) {
            return "<>";
        }

        return null;
    }
}
