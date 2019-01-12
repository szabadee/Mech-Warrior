package com.flow.mechwarriors.items;

public class MechAssault extends Mech {

    public MechAssault (String name) {
        super(name, 30, 35);
        setWeapon("Missile");
        setWeaponRange(6);
        setStepRange(1);
        setMechType("Assult");
    }

    @Override
    public boolean isMovable() {
        return true;
    }

    @Override
    public int maxStep() {
        return 1;
    }

    @Override
    public int maxAttack() {
        return 6;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
