package com.flow.mechwarrior;

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
            mechLight.setName(mechLightNames[i]);
            mechArmy.add(mechLight);
        }

        for (int i = 0; i < mechMediumNames.length; i++) {
            Mech mechMedium = new MechMedium("");
            mechMedium.setName(mechMediumNames[i]);
            mechArmy.add(mechMedium);
        }

        for (int i = 0; i < mechHeavyNames.length; i++) {
            Mech mechHeavy = new MechHeavy("");
            mechHeavy.setName(mechHeavyNames[i]);
            mechArmy.add(mechHeavy);
        }

        for (int i = 0; i < mechAssaultNames.length; i++) {
            Mech mechAssault = new MechAssault("");
            mechAssault.setName(mechAssaultNames[i]);
            mechArmy.add(mechAssault);
        }

        return mechArmy;
    }
}
