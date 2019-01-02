package com.flow.mechwarrior;

public class Mech {
    private String mechType;
    private String name;
    private String weapon;
    private int weaponRange;
    private int stepRange;
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

    public String getWeapon() {
        return weapon;
    }

    public int getWeaponRange() {
        return weaponRange;
    }

    public int getStepRange() {
        return stepRange;
    }

    public String getMechType() {
        return mechType;
    }

    // endregion

    // region Setters

    public void setName(String name) {
        this.name = name;
    }

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

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void setWeaponRange(int weaponRange) {
        this.weaponRange = weaponRange;
    }

    public void setStepRange(int stepRange) {
        this.stepRange = stepRange;
    }

    public void setMechType(String mechType) {
        this.mechType = mechType;
    }

    // endregion


    @Override
    public String toString() {
        return "<html><font style=\"font-family: 'Arial'; font-size: 12pt;\">" +
                mechType + "<br>" +
                name + "<br>" +
                weapon + "<br>" +
                weaponRange + "<br>" +
                stepRange + "<br><br>[armor] - - [hp] - - - - -<br> &nbsp;&nbsp;&nbsp; " +
                leftLeg[0] + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " + leftLeg[1] + "<br> &nbsp;&nbsp;&nbsp; " +
                rightLeg[0] + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " + rightLeg[1] + "<br> &nbsp;&nbsp;&nbsp; " +
                leftArm[0] + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " + leftArm[1] + "<br> &nbsp;&nbsp;&nbsp; " +
                rightArm[0] + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " + rightArm[1] + "<br> &nbsp;&nbsp;&nbsp; " +
                leftShoulder[0] + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " + leftShoulder[1] + "<br> &nbsp;&nbsp;&nbsp; " +
                rightShoulder[0] + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " + rightShoulder[1] + "<br> &nbsp;&nbsp;&nbsp; " +
                torso[0] + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " + torso[1] + "<br> &nbsp;&nbsp;&nbsp; " +
                head[0] + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; " + head[1] + "<br>" +
                "</html>";
    }
}
