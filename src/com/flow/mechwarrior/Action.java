package com.flow.mechwarrior;

public interface Action {
    void step(int i, int j);
    void attack(Cell matrix, Mech mech);
    int[] damage(int damage, int[] partOfBody);

}
