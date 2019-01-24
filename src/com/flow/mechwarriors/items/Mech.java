package com.flow.mechwarriors.items;


import com.flow.mechwarriors.Player;


public abstract class Mech implements Action {
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
    private int attackForce;
    private Player owner;
    private boolean isMovable;
    private boolean canAttack;

    public Mech(String name, int armor, int hp, int attackForce, boolean isMovable, boolean canAttack) {
        this.name = name;
        leftLeg = new int[]{armor, hp};
        rightLeg = new int[]{armor, hp};
        leftArm = new int[]{armor, hp};
        rightArm = new int[]{armor, hp};
        leftShoulder = new int[]{armor, hp};
        rightShoulder = new int[]{armor, hp};
        torso = new int[]{armor, hp};
        head = new int[]{armor, hp};
        this.attackForce = attackForce;
        this.isMovable = isMovable;
        this.canAttack = canAttack;
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

    public Player getOwner() {
        return owner;
    }

    public int getAttackForce() {
        return attackForce;
    }

    public boolean getIsMovable() {
        return isMovable;
    }

    public boolean getCanAttack() {
        return canAttack;
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

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public void setMovable(boolean movable) {
        this.isMovable = movable;
    }

    public void setCanAttack(boolean canAttack) {
        this.canAttack = canAttack;
    }

    // endregion

    @Override
    public String toString() {
        return "<html><font style=\"font-family: 'Arial'; font-size: 14pt; color: red;\">" +
                mechType + "<br>" +
                name + "<br>" +
                weapon + "<br>" +
                weaponRange + "<br>" +
                attackForce + "<br>" +
                stepRange + "<br><br><br>[armor] - - [hp] - - -<br><&emsp;" +
                leftLeg[0] + "&emsp;&emsp;&emsp;" + leftLeg[1] + "<br>&emsp;" +
                rightLeg[0] + "&emsp;&emsp;&emsp;" + rightLeg[1] + "<br>&emsp;" +
                leftArm[0] + "&emsp;&emsp;&emsp;" + leftArm[1] + "<br>&emsp;" +
                rightArm[0] + "&emsp;&emsp;&emsp;" + rightArm[1] + "<br>&emsp;" +
                leftShoulder[0] + "&emsp;&emsp;&emsp;" + leftShoulder[1] + "<br>&emsp;" +
                rightShoulder[0] + "&emsp;&emsp;&emsp;" + rightShoulder[1] + "<br>&emsp;" +
                torso[0] + "&emsp;&emsp;&emsp;" + torso[1] + "<br>&emsp;" +
                head[0] + "&emsp;&emsp;&emsp;" + head[1] + "<br>" +
                "</html>";
    }

}
