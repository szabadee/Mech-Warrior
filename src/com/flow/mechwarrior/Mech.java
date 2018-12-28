package com.flow.mechwarrior;

public abstract class Mech {
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


    // endregion

    // region Setters

    public void setLeftLeg(int[] leftLeg) {
        this.leftLeg = leftLeg;
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

}
