package com.flow.mechwarriors;

import com.flow.mechwarriors.items.*;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private BattlefieldItem[][] matrix;
    private int size;
    public static Player playerOne;
    public static Player playerTwo;

    public Table(int size) {
        this.size = size;

        matrix = new BattlefieldItem[size][size];
        fillTable();
        generateMechs();
        generateBarrier();
    }

    private void fillTable () {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = new BattlefieldItem();
            }
        }
    }

    private void generateMechs () {
        MechArmy m = new MechArmy();
        List<Mech> mechArmy = m.generateMechArmy();
        List<Mech> mechsOfPlayerOne = new ArrayList<>();
        List<Mech> mechsOfPlayerTwo = new ArrayList<>();
        playerOne = new Player("       Player 1: Chuck", mechsOfPlayerOne);
        playerTwo = new Player("       Player 2: Norris", mechsOfPlayerTwo);
        int randomIndex;
        int ascendingIndex = 0;
        int hasBeenIndex = mechArmy.size();
        List<Integer> randomIndexes = new ArrayList<>();
        int pairs = 2;
        int counter = 0;
        int randomLineup;

        // Standing up 1-1 MechLights for both player

        do {
            randomIndex = (int) (Math.random() * mechArmy.size() - 1);
            if (mechArmy.get(randomIndex) instanceof MechLight && hasBeenIndex != randomIndex) {
                mechsOfPlayerOne.add(mechArmy.get(randomIndex));
                hasBeenIndex = randomIndex;
                counter++;
                randomIndexes.add(randomIndex);
            }

        } while (counter != 1);

        counter = 0;

        do {
            randomIndex = (int) (Math.random() * mechArmy.size() - 1);
            if (mechArmy.get(randomIndex) instanceof MechLight && hasBeenIndex != randomIndex) {
                mechsOfPlayerTwo.add(mechArmy.get(randomIndex));
                hasBeenIndex = randomIndex;
                counter++;
                randomIndexes.add(randomIndex);
            }

        } while (counter != 1);

        counter = 0;

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            if (matrix[0][randomLineup].getStandingOnIt() == false) {
                matrix[0][randomLineup].setMech(mechsOfPlayerOne.get(ascendingIndex));
                matrix[0][randomLineup].setStandingOnIt(true);
                matrix[0][randomLineup].getMech().setOwner(playerOne);
                counter++;
            }

        } while (counter != 1);

        counter = 0;

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            if (matrix[matrix.length - 1][randomLineup].getStandingOnIt() == false) {
                matrix[matrix.length - 1][randomLineup].setMech(mechsOfPlayerTwo.get(ascendingIndex));
                matrix[matrix.length - 1][randomLineup].setStandingOnIt(true);
                matrix[matrix.length - 1][randomLineup].getMech().setOwner(playerTwo);
                counter++;
            }

        } while (counter != 1);

        ascendingIndex++;
        counter = 0;


        // Standing up 1-1 MechMediums for both player

        do {
            randomIndex = (int) (Math.random() * mechArmy.size() - 1);
            if (mechArmy.get(randomIndex) instanceof MechMedium && hasBeenIndex != randomIndex) {
                mechsOfPlayerOne.add(mechArmy.get(randomIndex));
                hasBeenIndex = randomIndex;
                counter++;
                randomIndexes.add(randomIndex);
            }

        } while (counter != 1);

        counter = 0;

        do {
            randomIndex = (int) (Math.random() * mechArmy.size() - 1);
            if (mechArmy.get(randomIndex) instanceof MechMedium && hasBeenIndex != randomIndex) {
                mechsOfPlayerTwo.add(mechArmy.get(randomIndex));
                hasBeenIndex = randomIndex;
                counter++;
                randomIndexes.add(randomIndex);
            }

        } while (counter != 1);

        counter = 0;

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            if (matrix[0][randomLineup].getStandingOnIt() == false) {
                matrix[0][randomLineup].setMech(mechsOfPlayerOne.get(ascendingIndex));
                matrix[0][randomLineup].setStandingOnIt(true);
                matrix[0][randomLineup].getMech().setOwner(playerOne);
                counter++;
            }

        } while (counter != 1);

        counter = 0;

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            if (matrix[matrix.length - 1][randomLineup].getStandingOnIt() == false) {
                matrix[matrix.length - 1][randomLineup].setMech(mechsOfPlayerTwo.get(ascendingIndex));
                matrix[matrix.length - 1][randomLineup].setStandingOnIt(true);
                matrix[matrix.length - 1][randomLineup].getMech().setOwner(playerTwo);
                counter++;
            }

        } while (counter != 1);

        ascendingIndex++;
        counter = 0;


        // Standing up 1-1 MechHeavys for both player

        do {
            randomIndex = (int) (Math.random() * mechArmy.size() - 1);
            if (mechArmy.get(randomIndex) instanceof MechHeavy && hasBeenIndex != randomIndex) {
                mechsOfPlayerOne.add(mechArmy.get(randomIndex));
                hasBeenIndex = randomIndex;
                counter++;
                randomIndexes.add(randomIndex);
            }

        } while (counter != 1);

        counter = 0;

        do {
            randomIndex = (int) (Math.random() * mechArmy.size() - 1);
            if (mechArmy.get(randomIndex) instanceof MechHeavy && hasBeenIndex != randomIndex) {
                mechsOfPlayerTwo.add(mechArmy.get(randomIndex));
                hasBeenIndex = randomIndex;
                counter++;
                randomIndexes.add(randomIndex);
            }

        } while (counter != 1);

        counter = 0;

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            if (matrix[0][randomLineup].getStandingOnIt() == false) {
                matrix[0][randomLineup].setMech(mechsOfPlayerOne.get(ascendingIndex));
                matrix[0][randomLineup].setStandingOnIt(true);
                matrix[0][randomLineup].getMech().setOwner(playerOne);
                counter++;
            }

        } while (counter != 1);

        counter = 0;

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            if (matrix[matrix.length - 1][randomLineup].getStandingOnIt() == false) {
                matrix[matrix.length - 1][randomLineup].setMech(mechsOfPlayerTwo.get(ascendingIndex));
                matrix[matrix.length - 1][randomLineup].setStandingOnIt(true);
                matrix[matrix.length - 1][randomLineup].getMech().setOwner(playerTwo);
                counter++;
            }

        } while (counter != 1);

        ascendingIndex++;
        counter = 0;


        // Standing up 1-1 MechAssaults for both player

        do {
            randomIndex = (int) (Math.random() * mechArmy.size() - 1);
            if (mechArmy.get(randomIndex) instanceof MechAssault && hasBeenIndex != randomIndex) {
                mechsOfPlayerOne.add(mechArmy.get(randomIndex));
                hasBeenIndex = randomIndex;
                counter++;
                randomIndexes.add(randomIndex);
            }

        } while (counter != 1);

        counter = 0;

        do {
            randomIndex = (int) (Math.random() * mechArmy.size() - 1);
            if (mechArmy.get(randomIndex) instanceof MechAssault && hasBeenIndex != randomIndex) {
                mechsOfPlayerTwo.add(mechArmy.get(randomIndex));
                hasBeenIndex = randomIndex;
                counter++;
                randomIndexes.add(randomIndex);
            }

        } while (counter != 1);

        counter = 0;

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            if (matrix[0][randomLineup].getStandingOnIt() == false) {
                matrix[0][randomLineup].setMech(mechsOfPlayerOne.get(ascendingIndex));
                matrix[0][randomLineup].setStandingOnIt(true);
                matrix[0][randomLineup].getMech().setOwner(playerOne);
                counter++;
            }

        } while (counter != 1);

        counter = 0;

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            if (matrix[matrix.length - 1][randomLineup].getStandingOnIt() == false) {
                matrix[matrix.length - 1][randomLineup].setMech(mechsOfPlayerTwo.get(ascendingIndex));
                matrix[matrix.length - 1][randomLineup].setStandingOnIt(true);
                matrix[matrix.length - 1][randomLineup].getMech().setOwner(playerTwo);
                counter++;
            }

        } while (counter != 1);

        ascendingIndex++;
        counter = 0;


        // Standing up 2-2 random Mechs for both player

        do {
            randomIndex = (int) (Math.random() * mechArmy.size() - 1);
            if (!randomIndexes.contains(randomIndex)) {
                mechsOfPlayerOne.add(mechArmy.get(randomIndex));
                counter++;
                randomIndexes.add(randomIndex);
            }

        } while (counter != pairs);

        counter = 0;

        do {
            randomIndex = (int) (Math.random() * mechArmy.size() - 1);
            if (!randomIndexes.contains(randomIndex)) {
                mechsOfPlayerTwo.add(mechArmy.get(randomIndex));
                counter++;
                randomIndexes.add(randomIndex);
            }

        } while (counter != pairs);

        counter = 0;

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            if (matrix[0][randomLineup].getStandingOnIt() == false) {
                matrix[0][randomLineup].setMech(mechsOfPlayerOne.get(ascendingIndex));
                matrix[0][randomLineup].setStandingOnIt(true);
                matrix[0][randomLineup].getMech().setOwner(playerOne);
                counter++;
            }

        } while (counter != 1);

        counter = 0;

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            if (matrix[matrix.length - 1][randomLineup].getStandingOnIt() == false) {
                matrix[matrix.length - 1][randomLineup].setMech(mechsOfPlayerTwo.get(ascendingIndex));
                matrix[matrix.length - 1][randomLineup].setStandingOnIt(true);
                matrix[matrix.length - 1][randomLineup].getMech().setOwner(playerTwo);
                counter++;
            }

        } while (counter != 1);

        ascendingIndex++;
        counter = 0;

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            if (matrix[0][randomLineup].getStandingOnIt() == false) {
                matrix[0][randomLineup].setMech(mechsOfPlayerOne.get(ascendingIndex));
                matrix[0][randomLineup].setStandingOnIt(true);
                matrix[0][randomLineup].getMech().setOwner(playerOne);
                counter++;
            }

        } while (counter != 1);

        counter = 0;

        do {
            randomLineup = (int) (Math.random() * matrix.length - 1);
            if (matrix[matrix.length - 1][randomLineup].getStandingOnIt() == false) {
                matrix[matrix.length - 1][randomLineup].setMech(mechsOfPlayerTwo.get(ascendingIndex));
                matrix[matrix.length - 1][randomLineup].setStandingOnIt(true);
                matrix[matrix.length - 1][randomLineup].getMech().setOwner(playerTwo);
                counter++;
            }

        } while (counter != 1);

        System.out.println(randomIndexes);
    }

    private void generateBarrier() {
        int x;
        int y;

        for (int i = 0; i < size; i++) {
            x = (int) (Math.random() * (size - 2) + 1);
            y = (int) (Math.random() * size);

            matrix[x][y] = new Barrier();
        }
    }

    public BattlefieldItem getCell (int i, int j) {
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
