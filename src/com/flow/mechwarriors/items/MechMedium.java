package com.flow.mechwarriors.items;

public class MechMedium extends Mech {

    public MechMedium(String name) {
        super(name, 20, 25,3);
        setWeapon("Laser");
        setWeaponRange(2);
        setStepRange(3);
        setMechType("Medium");
    }

    @Override
    public int maxStep() {
        return 3;
    }

    @Override
    public int maxAttack() {
        return 2;
    }

    @Override
    public boolean isMovable() {
        return true;
    }

    @Override
    public boolean canAttack() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
