package com.flow.mechwarriors.items;

public class MechLight extends Mech {

    public MechLight(String name) {
        super(name, 15, 20, 2, true, true);
        setWeapon("Punch");
        setWeaponRange(1);
        setStepRange(4);
        setMechType("Light");
    }

    @Override
    public int maxStep() {
        return 4;
    }

    @Override
    public int maxAttack() {
        return 1;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
