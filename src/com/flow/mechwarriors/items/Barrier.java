package com.flow.mechwarriors.items;


public class Barrier extends CellItem implements Action {

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

    public boolean isBarrier () {
        return true;
    }

    @Override
    public String toString() {
        return "<>";
    }
}
