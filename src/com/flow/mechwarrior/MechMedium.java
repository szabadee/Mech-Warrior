package com.flow.mechwarrior;

public class MechMedium extends Mech implements Action {
    private final int laserRange = 2;

    public MechMedium(String name, int armor, int hp) {
        super(name, armor, hp);
    }

    @Override
    public void step(int i, int j) {

    }

    @Override
    public void attack(int i, int j, Mech mech, int[] partOfBody) {

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
