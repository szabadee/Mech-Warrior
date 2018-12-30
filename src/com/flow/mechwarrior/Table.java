package com.flow.mechwarrior;

import java.util.*;

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
        MechArmy m = new MechArmy();
        List<Mech> mechArmy = m.generateMechArmy();
        List<Mech> selectedMechs = new ArrayList<>();
        int randomIndex;
        int temp = mechArmy.size();
        int tempCounter = 0;
        int pairs = 2;
        int counter = 0;
        int randomLineup = 0;

        do {
            randomIndex = (int) (Math.random() * mechArmy.size() - 1);
            if (mechArmy.get(randomIndex) instanceof MechLight && temp != randomIndex) {
                selectedMechs.add(mechArmy.get(randomIndex));
                temp = randomIndex;
                counter++;
            }
        } while (counter != pairs);

        System.out.println(selectedMechs.toString());
        System.out.println(selectedMechs.get(1));
        counter = 0;

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            System.out.println(matrix[0][randomLineup]);
            if (matrix[0][randomLineup].isMech()) {
                matrix[0][randomLineup].setMechLight((MechLight) selectedMechs.get(0));
                matrix[0][randomLineup].setCell("L");
                System.out.println(matrix[0][randomLineup]);
                counter++;
            }

        } while (counter != 1);

        counter = 0;

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            if (matrix[matrix.length - 1][randomLineup].isMech()) {
                matrix[matrix.length - 1][randomLineup].setMechLight((MechLight) selectedMechs.get(1));
                matrix[matrix.length - 1][randomLineup].setCell("L");
                System.out.println(matrix[matrix.length - 1][randomLineup]);
                counter++;
            }

        } while (counter != 1);
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
