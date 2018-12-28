package com.flow.mechwarrior;

import java.util.ArrayList;
import java.util.List;

public class MechArmy {

    public void mechsGenerator() {
    List<Mech> mechArmy = new ArrayList<>();
    MechLight mechLigth = new MechLight("Raven", 20, 20);
    mechArmy.add(mechLigth);
    }
}
