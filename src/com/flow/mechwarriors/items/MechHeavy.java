package com.flow.mechwarriors.items;

public class MechHeavy extends Mech {

    public MechHeavy(String name) {
        super(name, 25, 30, 4, true, true);
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
    public String toString() {
        return super.toString();
    }
}
