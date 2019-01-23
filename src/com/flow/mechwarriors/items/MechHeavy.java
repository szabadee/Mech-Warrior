package com.flow.mechwarriors.items;

public class MechHeavy extends Mech {

    public MechHeavy(String name) {
        super(name, 25, 30, 4);
        setWeapon("Ballistic");
        setWeaponRange(3);
        setStepRange(2);
        setMechType("Heavy");
    }

    @Override
    public int maxStep() {
        return 2;
    }

    @Override
    public int maxAttack() {
        return 3;
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
