package com.flow.mechwarrior;

import java.util.ArrayList;
import java.util.List;

public class MechArmy {

    public List<Mech> generateMechArmy () {
        String[] mechLightNames = {"Flea", "Locust", "Commando", "Javelin", "Osiris", "Raven"};
        String[] mechMediumtNames = {"Vulcan", "BlackJack", "Hellspawn", "Vindicator", "Crab", "Huchback"};
        String[] mechHeavyNames = {"Dragon", "Rifleman", "Catapult", "Jagermech", "Archer", "Grasshopper"};
        String[] mechAssaulttNames = {"Awesome", "Victor", "Zeus", "Cyclops", "Highlander", "Atlas"};

        List<Mech> mechArmy = new ArrayList<>();

        for (int i = 0; i < mechLightNames.length; i++) {
            Mech mechLight = new MechLight("");
            mechLight.setName(mechLightNames[i]);
            mechArmy.add(mechLight);
        }

        }

}
