package com.flow.mechwarrior;

import java.util.Arrays;

public class Table {
    private Cell[][] matrix;
    private int size;

    public Table (int size) {
        this.size = size;

        matrix = new Cell[size][size];
        fillTable();
        generateMechs();
    }

    private void fillTable () {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = new Cell();
                matrix[i][j].setCell("•");
            }
        }
    }

    private void generateMechs () {
        MechLight mechLight = new MechLight("Raven", 15, 20);
        MechMedium mechMedium = new MechMedium("Huchback", 20, 25);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[4][0].setMechLight(mechLight);
                matrix[4][0].setCell("L");
                matrix[6][0].setMechMedium(mechMedium);
                matrix[6][0].setCell("M");
                matrix[5][size - 1].setMechLight(mechLight);
                matrix[5][size - 1].setCell("L");
                matrix[7][size - 1].setMechMedium(mechMedium);
                matrix[7][size - 1].setCell("M");
            }
        }
    }

    @Override
    public String toString() {
        String table = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                table += ' ' + matrix[i][j].toString();
            }
            table += '\n';
        }

        return table;
    }
}
