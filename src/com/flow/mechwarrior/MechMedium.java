package com.flow.mechwarrior;

public class MechMedium extends Mech implements Action {

    public MechMedium(String name) {
        super(name, 20, 25);
        setWeapon("Laser");
        setWeaponRange(2);
        setStepRange(3);
        setMechType("Medium");
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
