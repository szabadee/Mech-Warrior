package com.flow.mechwarrior;

public class Cell {
    private String[] terrain;
    private boolean isMech;

    public Cell (String[] terrain, boolean isMech) {
        terrain = new String[]{"Plain", "Forest", "Mountain"};
        this.isMech = isMech;
    }

    public String[] getTerrain() {
        return terrain;
    }

    public boolean getIsMech() {
        return isMech;
    }

    public void setMech(boolean mech) {
        isMech = mech;
    }
}
