package com.flow.mechwarrior;

public class MechLight extends Mech implements Action {
    private static final String mechType = "Light";
    private static final String weapon = "Punch";
    private static final int weaponRange = 1;
    private static final int steprange = 4;


    public MechLight(String name, int armor, int hp) {
        super(name, armor, hp);
        setWeapon(this.weapon);
        setWeaponRange(this.weaponRange);
        setStepRange(this.steprange);
        setMechType(this.mechType);
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
