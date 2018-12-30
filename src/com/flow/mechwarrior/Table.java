package com.flow.mechwarrior;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Table {
    private Cell[][] matrix;
    private int size;

    public Table (int size) {
        this.size = size;

        matrix = new Cell[size][size];
        fillTable();
        generateMechs();
        generateBlockage();
    }

    private void fillTable () {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == null) {
                    matrix[i][j] = new Cell();
                }
            }
        }
    }

    private void generateMechs () {
        List<Mech> mechList = new ArrayList<>();
        mechList.add(MechLight);


        Mech mechLight = new MechLight("");
        mechLight.setName();
        MechMedium mechMedium = new MechMedium("Huchback", 20, 25);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[0][4].setMechLight(mechLight);
                matrix[0][4].setCell("L");
                matrix[0][6].setMechMedium(mechMedium);
                matrix[0][6].setCell("M");
                matrix[size - 1][5].setMechLight(mechLight);
                matrix[size - 1][5].setCell("L");
                matrix[size - 1][7].setMechMedium(mechMedium);
                matrix[size - 1][7].setCell("M");
            }
        }
    }

    private void generateBlockage() {
        int x;
        int y;

        for (int i = 0; i < size; i++) {
            x = (int) (Math.random() * (size - 2) + 1);
            y = (int) (Math.random() * size);

            matrix[x][y].isBlockage();
            matrix[x][y].setCell("<>");
        }
    }

    public Cell getCell (int i, int j) {
        return matrix[i][j];
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
