package com.flow.mechwarrior;

public class MechLight extends Mech implements Action {
    private final int WEAPONRANGE = 1;
    private final int STEPRANGE = 4;
    private final String WEAPON = "Punch";


    public MechLight(String name, int armor, int hp) {
        super(name, armor, hp);
        setWeapon(this.WEAPON);
        setWeaponRange(this.WEAPONRANGE);
        setStepRange(this.STEPRANGE);
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
