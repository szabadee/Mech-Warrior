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
                matrix[i][j] = new Cell();
            }
        }
    }

    private void generateMechs () {
        MechArmy m = new MechArmy();
        List<Mech> mechArmy = m.generateMechArmy();
        List<Mech> selectedMechs = new ArrayList<>();
        int randomIndex;
        int tempIndex = mechArmy.size();
        List <Integer> randomIndexes = new ArrayList<>();
        int pairs = 2;
        int counter = 0;
        int index = 0;
        int randomLineup = 0;

        // Standing up 1-1 MechLights for both player

        do {
            randomIndex = (int) (Math.random() * mechArmy.size() - 1);
            if (mechArmy.get(randomIndex) instanceof MechLight && tempIndex != randomIndex) {
                selectedMechs.add(mechArmy.get(randomIndex));
                tempIndex = randomIndex;
                counter++;
                randomIndexes.add(randomIndex);
                index++;
            }
        } while (counter != pairs);

        counter = 0;

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            System.out.println(randomLineup);
            System.out.println(matrix[0][randomLineup].getStandingOnIt());
            if (matrix[0][randomLineup].getStandingOnIt() == false) {
                matrix[0][randomLineup].setMech(selectedMechs.get(0));
                matrix[0][randomLineup].setStandingOnIt(true);
                counter++;
            }

        } while (counter != 1);

        counter = 0;

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            System.out.println(randomLineup);
            System.out.println(matrix[matrix.length - 1][randomLineup].getStandingOnIt());
            if (matrix[matrix.length - 1][randomLineup].getStandingOnIt() == false) {
                matrix[matrix.length - 1][randomLineup].setMech(selectedMechs.get(1));
                matrix[matrix.length - 1][randomLineup].setStandingOnIt(true);
                counter++;
            }

        } while (counter != 1);

        counter = 0;


        // Standing up 1-1 MechMediums for both player

        do {
            randomIndex = (int) (Math.random() * mechArmy.size() - 1);
            if (mechArmy.get(randomIndex) instanceof MechMedium && tempIndex != randomIndex) {
                selectedMechs.add(mechArmy.get(randomIndex));
                tempIndex = randomIndex;
                counter++;
                randomIndexes.add(randomIndex);
                index++;
            }
        } while (counter != pairs);

        counter = 0;

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            System.out.println(randomLineup);
            System.out.println(matrix[0][randomLineup].getStandingOnIt());
            if (matrix[0][randomLineup].getStandingOnIt() == false) {
                matrix[0][randomLineup].setMech(selectedMechs.get(2));
                matrix[0][randomLineup].setStandingOnIt(true);
                counter++;
            }

        } while (counter != 1);

        counter = 0;

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            System.out.println(randomLineup);
            System.out.println(matrix[matrix.length - 1][randomLineup].getStandingOnIt());
            if (matrix[matrix.length - 1][randomLineup].getStandingOnIt() == false) {
                matrix[matrix.length - 1][randomLineup].setMech(selectedMechs.get(3));
                matrix[matrix.length - 1][randomLineup].setStandingOnIt(true);
                counter++;
            }

        } while (counter != 1);

        counter = 0;


        // Standing up 1-1 MechHeavys for both player

        do {
            randomIndex = (int) (Math.random() * mechArmy.size() - 1);
            if (mechArmy.get(randomIndex) instanceof MechHeavy && tempIndex != randomIndex) {
                selectedMechs.add(mechArmy.get(randomIndex));
                tempIndex = randomIndex;
                counter++;
                randomIndexes.add(randomIndex);
                index++;
            }

        } while (counter != pairs);

        counter = 0;

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            System.out.println(randomLineup);
            System.out.println(matrix[0][randomLineup].getStandingOnIt());
            if (matrix[0][randomLineup].getStandingOnIt() == false) {
                matrix[0][randomLineup].setMech(selectedMechs.get(4));
                matrix[0][randomLineup].setStandingOnIt(true);
                counter++;
            }

        } while (counter != 1);

        counter = 0;

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            System.out.println(randomLineup);
            System.out.println(matrix[matrix.length - 1][randomLineup].getStandingOnIt());
            if (matrix[matrix.length - 1][randomLineup].getStandingOnIt() == false) {
                matrix[matrix.length - 1][randomLineup].setMech(selectedMechs.get(5));
                matrix[matrix.length - 1][randomLineup].setStandingOnIt(true);
                counter++;
            }

        } while (counter != 1);

        counter = 0;


        // Standing up 1-1 MechAssaults for both player

        do {
            randomIndex = (int) (Math.random() * mechArmy.size() - 1);
            if (mechArmy.get(randomIndex) instanceof MechAssault && tempIndex != randomIndex) {
                selectedMechs.add(mechArmy.get(randomIndex));
                tempIndex = randomIndex;
                counter++;
                randomIndexes.add(randomIndex);
                index++;
            }
        } while (counter != pairs);

        counter = 0;

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            System.out.println(randomLineup);
            System.out.println(matrix[0][randomLineup].getStandingOnIt());
            if (matrix[0][randomLineup].getStandingOnIt() == false) {
                matrix[0][randomLineup].setMech(selectedMechs.get(6));
                matrix[0][randomLineup].setStandingOnIt(true);
                counter++;
            }

        } while (counter != 1);

        counter = 0;

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            System.out.println(randomLineup);
            System.out.println(matrix[matrix.length - 1][randomLineup].getStandingOnIt());
            if (matrix[matrix.length - 1][randomLineup].getStandingOnIt() == false) {
                matrix[matrix.length - 1][randomLineup].setMech(selectedMechs.get(7));
                matrix[matrix.length - 1][randomLineup].setStandingOnIt(true);
                counter++;
            }

        } while (counter != 1);

        counter = 0;

        // System.out.println(selectedMechs.toString());
        // System.out.println(index);
        // System.out.println(randomIndexes);


        // Standing up 2-2 random Mechs for both player

        do {
            randomIndex = (int) (Math.random() * mechArmy.size() - 1);
            if (!randomIndexes.contains(randomIndex)) {
                System.out.println(randomIndex);
                selectedMechs.add(mechArmy.get(randomIndex));
                counter++;
                randomIndexes.add(randomIndex);
                index++;
            }

        } while (counter != 4);

        counter = 0;

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            System.out.println(randomLineup);
            System.out.println(matrix[0][randomLineup].getStandingOnIt());
            if (matrix[0][randomLineup].getStandingOnIt() == false) {
                matrix[0][randomLineup].setMech(selectedMechs.get(8));
                matrix[0][randomLineup].setStandingOnIt(true);
                counter++;
            }

        } while (counter != 1);

        counter = 0;

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            System.out.println(randomLineup);
            System.out.println(matrix[matrix.length - 1][randomLineup].getStandingOnIt());
            if (matrix[matrix.length - 1][randomLineup].getStandingOnIt() == false) {
                matrix[matrix.length - 1][randomLineup].setMech(selectedMechs.get(9));
                matrix[matrix.length - 1][randomLineup].setStandingOnIt(true);
                counter++;
            }

        } while (counter != 1);

        counter = 0;

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            System.out.println(randomLineup);
            System.out.println(matrix[0][randomLineup].getStandingOnIt());
            if (matrix[0][randomLineup].getStandingOnIt() == false) {
                matrix[0][randomLineup].setMech(selectedMechs.get(10));
                matrix[0][randomLineup].setStandingOnIt(true);
                counter++;
            }

        } while (counter != 1);

        counter = 0;

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            System.out.println(randomLineup);
            System.out.println(matrix[matrix.length - 1][randomLineup].getStandingOnIt());
            if (matrix[matrix.length - 1][randomLineup].getStandingOnIt() == false) {
                matrix[matrix.length - 1][randomLineup].setMech(selectedMechs.get(11));
                matrix[matrix.length - 1][randomLineup].setStandingOnIt(true);
                counter++;
            }

        } while (counter != 1);


        // System.out.println(selectedMechs.toString());
        System.out.println(randomIndexes);
    }

    private void generateBlockage() {
        int x;
        int y;

        for (int i = 0; i < size; i++) {
            x = (int) (Math.random() * (size - 2) + 1);
            y = (int) (Math.random() * size);

            matrix[x][y] = new Blockage();
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
