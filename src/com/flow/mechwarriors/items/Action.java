package com.flow.mechwarriors.items;

public interface Action {
    boolean isMovable();
    int maxStep();
    int maxAttack();
    boolean canMoveOutOfAxis();
}
