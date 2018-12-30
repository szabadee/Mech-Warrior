package com.flow.mechwarrior;

public class MechAssault extends Mech implements Action {

    private MechAssault (String name) {
        super(name, 30, 35);
        setWeapon("Missile");
        setWeaponRange(6);
        setStepRange(1);
        setMechType("Assult");
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
}
