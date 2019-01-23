package com.flow.mechwarriors;

import com.flow.mechwarriors.items.BattlefieldItem;

public class Battlefield {
    public static BattlefieldItem[][] battlefield;
    private final int size = 20;
    private Table table = new Table(size);


    public Battlefield() {
        battlefield = new BattlefieldItem[size][size];
        drawBattlefield();
    }

    public void drawBattlefield() {
        for (int i = 0; i < battlefield.length; i++) {
            for (int j = 0; j < battlefield.length; j++) {
                battlefield[i][j] = table.getCell(i, j);
            }
        }
    }

}
