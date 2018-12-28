package com.flow.mechwarrior;

public interface Action {
    void step(int i, int j);
    void attack(int i, int j, int[] partOfBody);
    int[] damage(int damage, int[] partOfBody);

}
