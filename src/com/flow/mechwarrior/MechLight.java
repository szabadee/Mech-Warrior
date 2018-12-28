package com.flow.mechwarrior;

public class MechLight extends Mech implements Action {
    private final int punchRange = 1;

    public MechLight(String name, int armor, int hp) {
        super(name, armor, hp);
    }

    @Override
    public void step(int i, int j) {

    }

    @Override
    public void attack(int i, int j, int[] partOfBody) {

    }

    @Override
    public int[] damage(int damage, int[] partOfBody) {
        return new int[0];
    }
}
