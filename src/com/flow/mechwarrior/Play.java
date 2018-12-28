package com.flow.mechwarrior;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Play {
    public static void main(String[] args) {
        List<Mech> mechArmy = new ArrayList<>();
        MechLight mechLight = new MechLight("Raven", 15, 20);
        MechMedium mechMedium = new MechMedium("Huchback", 20, 25);
        mechArmy.add(mechLight);
        mechArmy.add(mechMedium);
        System.out.println(mechArmy.toString());
    }
}
