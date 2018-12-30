package com.flow.mechwarrior;

public class MechHeavy extends Mech implements Action {

    public MechHeavy(String name) {
        super(name, 25, 30);
        setWeapon("Ballistic");
        setWeaponRange(3);
        setStepRange(2);
        setMechType("Heavy");
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
