package com.flow.mechwarriors.items;

import java.util.ArrayList;
import java.util.List;

public class MechArmy {

    public List<Mech> generateMechArmy () {
        String[] mechLightNames = {"Flea", "Locust", "Commando", "Javelin", "Osiris", "Raven"};
        String[] mechMediumNames = {"Vulcan", "BlackJack", "Hellspawn", "Vindicator", "Crab", "Huchback"};
        String[] mechHeavyNames = {"Dragon", "Rifleman", "Catapult", "Jagermech", "Archer", "Grasshopper"};
        String[] mechAssaultNames = {"Awesome", "Victor", "Zeus", "Cyclops", "Highlander", "Atlas"};

        List<Mech> mechArmy = new ArrayList<>();

        for (int i = 0; i < mechLightNames.length; i++) {
            Mech mechLight = new MechLight("");
            Mech mechMedium = new MechMedium("");
            Mech mechHeavy = new MechHeavy("");
            Mech mechAssault = new MechAssault("");
            mechLight.setName(mechLightNames[i]);
            mechMedium.setName(mechMediumNames[i]);
            mechHeavy.setName(mechHeavyNames[i]);
            mechAssault.setName(mechAssaultNames[i]);
            mechArmy.add(mechLight);
            mechArmy.add(mechMedium);
            mechArmy.add(mechHeavy);
            mechArmy.add(mechAssault);
        }

        return mechArmy;
    }
}
