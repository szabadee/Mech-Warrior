package com.flow.mechwarrior;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Play {
    public static void main(String[] args) {
        List<Mech> mechArmy = new ArrayList<>();
        MechLight mechLight = new MechLight("Raven", 20, 20);
        mechArmy.add(mechLight);
        System.out.println(mechArmy.toString());
        mechLight.setLeftLeg(20,10);
        System.out.println(Arrays.toString(mechLight.getLeftLeg()));
    }
}
