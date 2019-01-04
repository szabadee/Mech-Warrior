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
        PlayerOne playerOne = new PlayerOne();
        PlayerTwo playerTwo = new PlayerTwo();
        int randomIndex;
        int randomIndex2;
        int hasBeenIndex = mechArmy.size();
        List <Integer> randomIndexes = new ArrayList<>();
        int pairs = 2;
        int counter = 0;
        int randomLineup = 0;

        // Standing up 1-1 MechLights for both player

        do {
            randomIndex = (int) (Math.random() * mechArmy.size() - 1);
            if (mechArmy.get(randomIndex) instanceof MechLight && hasBeenIndex != randomIndex) {
                selectedMechs.add(mechArmy.get(randomIndex));
                playerOne.mechsOfPlayerOne.add(mechArmy.get(randomIndex));
                hasBeenIndex = randomIndex;
                counter++;
                randomIndexes.add(randomIndex);
            }

        } while (counter != 1);

        counter = 0;

        do {
            randomIndex = (int) (Math.random() * mechArmy.size() - 1);
            if (mechArmy.get(randomIndex) instanceof MechLight && hasBeenIndex != randomIndex) {
                selectedMechs.add(mechArmy.get(randomIndex));
                playerTwo.mechsOfPlayerTwo.add(mechArmy.get(randomIndex));
                hasBeenIndex = randomIndex;
                counter++;
                randomIndexes.add(randomIndex);
            }

        } while (counter != 1);

        counter = 0;

        System.out.println("Cool");

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            System.out.println(randomLineup);
            System.out.println(matrix[0][randomLineup].getStandingOnIt());
            if (matrix[0][randomLineup].getStandingOnIt() == false) {
                matrix[0][randomLineup].setMech(playerOne.mechsOfPlayerOne.get(0));
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
                matrix[matrix.length - 1][randomLineup].setMech(playerTwo.mechsOfPlayerTwo.get(0));
                matrix[matrix.length - 1][randomLineup].setStandingOnIt(true);
                counter++;
            }

        } while (counter != 1);

        counter = 0;


        // Standing up 1-1 MechMediums for both player

        do {
            randomIndex = (int) (Math.random() * mechArmy.size() - 1);
            if (mechArmy.get(randomIndex) instanceof MechMedium && hasBeenIndex != randomIndex) {
                selectedMechs.add(mechArmy.get(randomIndex));
                playerOne.mechsOfPlayerOne.add(mechArmy.get(randomIndex));
                hasBeenIndex = randomIndex;
                counter++;
                randomIndexes.add(randomIndex);
            }

        } while (counter != 1);

        counter = 0;

        do {
            randomIndex = (int) (Math.random() * mechArmy.size() - 1);
            if (mechArmy.get(randomIndex) instanceof MechMedium && hasBeenIndex != randomIndex) {
                selectedMechs.add(mechArmy.get(randomIndex));
                playerTwo.mechsOfPlayerTwo.add(mechArmy.get(randomIndex));
                hasBeenIndex = randomIndex;
                counter++;
                randomIndexes.add(randomIndex);
            }

        } while (counter != 1);

        counter = 0;

        System.out.println("Cool2");

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            System.out.println(randomLineup);
            System.out.println(matrix[0][randomLineup].getStandingOnIt());
            if (matrix[0][randomLineup].getStandingOnIt() == false) {
                matrix[0][randomLineup].setMech(playerOne.mechsOfPlayerOne.get(1));
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
                matrix[matrix.length - 1][randomLineup].setMech(playerTwo.mechsOfPlayerTwo.get(1));
                matrix[matrix.length - 1][randomLineup].setStandingOnIt(true);
                counter++;
            }

        } while (counter != 1);

        counter = 0;


        // Standing up 1-1 MechHeavys for both player

        do {
            randomIndex = (int) (Math.random() * mechArmy.size() - 1);
            if (mechArmy.get(randomIndex) instanceof MechHeavy && hasBeenIndex != randomIndex) {
                selectedMechs.add(mechArmy.get(randomIndex));
                playerOne.mechsOfPlayerOne.add(mechArmy.get(randomIndex));
                hasBeenIndex = randomIndex;
                counter++;
                randomIndexes.add(randomIndex);
            }

        } while (counter != 1);

        counter = 0;

        do {
            randomIndex = (int) (Math.random() * mechArmy.size() - 1);
            if (mechArmy.get(randomIndex) instanceof MechHeavy && hasBeenIndex != randomIndex) {
                selectedMechs.add(mechArmy.get(randomIndex));
                playerTwo.mechsOfPlayerTwo.add(mechArmy.get(randomIndex));
                hasBeenIndex = randomIndex;
                counter++;
                randomIndexes.add(randomIndex);
            }

        } while (counter != 1);

        counter = 0;

        System.out.println("Cool3");

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            System.out.println(randomLineup);
            // System.out.println(playerOne.mechsOfPlayerOne);
            if (matrix[0][randomLineup].getStandingOnIt() == false) {
                matrix[0][randomLineup].setMech(playerOne.mechsOfPlayerOne.get(2));
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
                matrix[matrix.length - 1][randomLineup].setMech(playerTwo.mechsOfPlayerTwo.get(2));
                matrix[matrix.length - 1][randomLineup].setStandingOnIt(true);
                counter++;
            }

        } while (counter != 1);

        counter = 0;


        // Standing up 1-1 MechAssaults for both player

        do {
            randomIndex = (int) (Math.random() * mechArmy.size() - 1);
            if (mechArmy.get(randomIndex) instanceof MechAssault && hasBeenIndex != randomIndex) {
                selectedMechs.add(mechArmy.get(randomIndex));
                playerOne.mechsOfPlayerOne.add(mechArmy.get(randomIndex));
                hasBeenIndex = randomIndex;
                counter++;
                randomIndexes.add(randomIndex);
            }

        } while (counter != 1);

        counter = 0;

        do {
            randomIndex = (int) (Math.random() * mechArmy.size() - 1);
            if (mechArmy.get(randomIndex) instanceof MechAssault && hasBeenIndex != randomIndex) {
                selectedMechs.add(mechArmy.get(randomIndex));
                playerTwo.mechsOfPlayerTwo.add(mechArmy.get(randomIndex));
                hasBeenIndex = randomIndex;
                counter++;
                randomIndexes.add(randomIndex);
            }

        } while (counter != 1);

        counter = 0;

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            System.out.println(randomLineup);
            System.out.println(matrix[0][randomLineup].getStandingOnIt());
            if (matrix[0][randomLineup].getStandingOnIt() == false) {
                matrix[0][randomLineup].setMech(playerOne.mechsOfPlayerOne.get(3));
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
                matrix[matrix.length - 1][randomLineup].setMech(playerTwo.mechsOfPlayerTwo.get(3));
                matrix[matrix.length - 1][randomLineup].setStandingOnIt(true);
                counter++;
            }

        } while (counter != 1);

        counter = 0;

        System.out.println("Cool4");

        // System.out.println(selectedMechs.toString());
        // System.out.println(index);
        // System.out.println(randomIndexes);


        // Standing up 2-2 random Mechs for both player

        do {
            randomIndex = (int) (Math.random() * mechArmy.size() - 1);
            if (!randomIndexes.contains(randomIndex)) {
                System.out.println(randomIndex);
                playerOne.mechsOfPlayerOne.add(mechArmy.get(randomIndex));
                counter++;
                randomIndexes.add(randomIndex);
            }

        } while (counter != pairs);

        counter = 0;

        do {
            randomIndex = (int) (Math.random() * mechArmy.size() - 1);
            if (!randomIndexes.contains(randomIndex)) {
                System.out.println(randomIndex);
                playerTwo.mechsOfPlayerTwo.add(mechArmy.get(randomIndex));
                counter++;
                randomIndexes.add(randomIndex);
            }

        } while (counter != pairs);

        counter = 0;

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            System.out.println(randomLineup);
            System.out.println(matrix[0][randomLineup].getStandingOnIt());
            if (matrix[0][randomLineup].getStandingOnIt() == false) {
                matrix[0][randomLineup].setMech(playerOne.mechsOfPlayerOne.get(4));
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
                matrix[matrix.length - 1][randomLineup].setMech(playerTwo.mechsOfPlayerTwo.get(4));
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
                matrix[0][randomLineup].setMech(playerOne.mechsOfPlayerOne.get(5));
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
                matrix[matrix.length - 1][randomLineup].setMech(playerTwo.mechsOfPlayerTwo.get(5));
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
