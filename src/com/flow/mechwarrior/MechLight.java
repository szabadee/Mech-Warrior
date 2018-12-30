package com.flow.mechwarrior;

public class MechLight extends Mech implements Action {

    public MechLight(String name) {
        super(name, 15, 20);
        setWeapon("Punch");
        setWeaponRange(1);
        setStepRange(4);
        setMechType("Light");
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
