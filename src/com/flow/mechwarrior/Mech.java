package com.flow.mechwarrior;

public class Mech {
    private String name;
    private int[] leftLeg;
    private int[] rightLeg;
    private int[] leftArm;
    private int[] rightArm;
    private int[] leftShoulder;
    private int[] rightShoulder;
    private int[] torso;
    private int[] head;

    public Mech(String name, int armor, int hp) {
        this.name = name;
        leftLeg = new int[]{armor, hp};
        rightLeg = new int[]{armor, hp};
        leftArm = new int[]{armor, hp};
        rightArm = new int[]{armor, hp};
        leftShoulder = new int[]{armor, hp};
        rightShoulder = new int[]{armor, hp};
        torso = new int[]{armor, hp};
        head = new int[]{armor, hp};
    }

    // region Getters

    public int[] getLeftLeg() {
        return leftLeg;
    }

    public int[] getRightLeg() {
        return rightLeg;
    }

    public int[] getLeftArm() {
        return leftArm;
    }

    public int[] getRightArm() {
        return rightArm;
    }

    public int[] getLeftShoulder() {
        return leftShoulder;
    }

    public int[] getRightShoulder() {
        return rightShoulder;
    }

    public int[] getTorso() {
        return torso;
    }

    public int[] getHead() {
        return head;
    }

    public String getName() {
        return name;
    }

    // endregion

    // region Setters

    public void setLeftLeg(int armor, int hp) {
        this.leftLeg = new int[]{armor, hp};
    }

    public void setRightLeg(int[] rightLeg) {
        this.rightLeg = rightLeg;
    }

    public void setLeftArm(int[] leftArm) {
        this.leftArm = leftArm;
    }

    public void setRightArm(int[] rightArm) {
        this.rightArm = rightArm;
    }

    public void setLeftShoulder(int[] leftShoulder) {
        this.leftShoulder = leftShoulder;
    }

    public void setRightShoulder(int[] rightShoulder) {
        this.rightShoulder = rightShoulder;
    }

    public void setTorso(int[] torso) {
        this.torso = torso;
    }

    public void setHead(int[] head) {
        this.head = head;
    }


    // endregion


    @Override
    public String toString() {
        return "\nName: \t\t" + name + "\n" +
                "Left leg: \tarmor[" + leftLeg[0] + "] \thp[" + leftLeg[1] + "]\n" +
                "Right leg: \tarmor[" + rightLeg[0] + "] \thp[" + rightLeg[1] + "]\n" +
                "Left arm: \tarmor[" + leftArm[0] + "] \thp[" + leftArm[1] + "]\n" +
                "Right arm: \tarmor[" + rightArm[0] + "] \thp[" + rightArm[1] + "]\n" +
                "Left shd: \tarmor[" + leftShoulder[0] + "] \thp[" + leftShoulder[1] + "]\n" +
                "Right shd: \tarmor[" + rightShoulder[0] + "] \thp[" + rightShoulder[1] + "]\n" +
                "Torso: \t\tarmor[" + torso[0] + "] \thp[" + torso[1] + "]\n" +
                "Head: \t\tarmor[" + head[0] + "] \thp[" + head[1] + "]\n\n";
    }
}
