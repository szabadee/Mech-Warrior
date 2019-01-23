package com.flow.mechwarriors.items;

public interface Action {
    int maxStep();
    int maxAttack();
    boolean isMovable();
    boolean canAttack();
}
