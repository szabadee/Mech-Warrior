package com.flow.mechwarrior;

public class Cell {
    private boolean isBlockage;
    private boolean isMech;

    public Cell (boolean isBlockage, boolean isMech) {
        this.isBlockage = isBlockage;
        this.isMech = isMech;
    }

    public boolean getIsBlockage () {
        return isBlockage;
    }

    public boolean getMech () {
        return isMech;
    }

    public void setBlockage (boolean isBlockage) {
        this.isBlockage = isBlockage;
    }

    public void setMech (boolean isMech) {
        this.isMech = isMech;
    }

    @Override
    public String toString() {
        if (isMech == true) {
            return "M";
        } else if (isBlockage == true){
            return "::";
        } else {
            return " ";
        }
    }
}
