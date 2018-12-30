package com.flow.mechwarrior;

public class Cell {
    private MechLight mechLight;
    private MechMedium mechMedium;
    private String cell;

    public boolean isBlockage () {
        return true;
    }

    public boolean isMechLight () {
        return true;
    }

    public boolean isMechMedium () {
        return true;
    }

    public boolean getIsBlockage () {
        return true;
    }

    public MechLight getMechLight () {
        return mechLight;
    }

    public MechMedium getMechMedium () {
        return mechMedium;
    }

    public void setMechLight (MechLight mechLight) {
        this.mechLight = mechLight;
    }

    public void setMechMedium (MechMedium mechMedium) {
        this.mechMedium = mechMedium;
    }

    public void setCell (String cell) {
        this.cell = cell;
    }

    @Override
    public String toString() {
        return cell;
    }
}
