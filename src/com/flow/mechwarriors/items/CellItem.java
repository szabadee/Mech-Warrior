package com.flow.mechwarriors.items;


import com.flow.mechwarriors.Player;

public class CellItem implements Action {
    private Mech mech;
    private Barrier barrier;
    private boolean isStandingOnIt;
    private Player owner;

    public Mech getMech () {
        return mech;
    }

    public Barrier getBarrier() {
        return barrier;
    }

    public boolean getStandingOnIt () {
        return isStandingOnIt;
    }

    public Player getOwner() {
        return owner;
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
    public boolean isMovable() {
        return false;
    }

    @Override
    public int maxStep() {
        return 0;
    }

    @Override
    public int maxAttack() {
        return 0;
    }

    @Override
    public boolean canMoveOutOfAxis() {
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
