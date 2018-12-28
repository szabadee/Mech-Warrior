package com.flow.mechwarrior;

import java.util.ArrayList;
import java.util.List;

public class MechArmy {

    public void mechsGenerator() {
        List<Mech> mechArmy = new ArrayList<>();
        Mech mechLight = new Mech("Raven", 20, 20);
        mechArmy.add(mechLight);
        System.out.println(mechArmy.toString());
    }

}
