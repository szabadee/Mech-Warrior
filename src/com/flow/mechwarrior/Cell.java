package com.flow.mechwarrior;

public class Cell {
    private boolean isBlockage;
    private MechLight mechLight;
    private MechMedium mechMedium;
    private String cell;


    public boolean getIsBlockage() {
        return true;
    }

    public MechLight getMechLight() {
        return mechLight;
    }

    public MechMedium getMechMedium() {
        return mechMedium;
    }

    public void setMechLight(MechLight mechLight) {
        this.mechLight = mechLight;
    }

    public void setMechMedium(MechMedium mechMedium) {
        this.mechMedium = mechMedium;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    @Override
    public String toString() {
        return cell;
    }
}
