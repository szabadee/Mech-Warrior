package com.flow.mechwarrior;

public class MechLight extends Mech implements Action {
    private final int PUNCHRANGE = 1;
    private final int STEPNUMBER = 4;


    public MechLight(String name, int armor, int hp) {
        super(name, armor, hp);
    }


    @Override
    public void step(int i, int j) {

    }

    @Override
    public void attack(Cell matrix, Mech mech) {

    }

    @Override
    public int[] damage(int damage, int[] partOfBody) {
        return new int[0];
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
