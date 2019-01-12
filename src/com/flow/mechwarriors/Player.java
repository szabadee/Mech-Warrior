package com.flow.mechwarriors;

import com.flow.mechwarriors.items.Mech;

import java.util.List;

public class Player {
    private final String name;
    private List<Mech> uniqueMechs;

    public Player(String name, List<Mech> uniqeMechs) {
        this.name = name;
        this.uniqueMechs = uniqeMechs;
    }

    public String getName() {
        return name;
    }

    public List getUniqueMechs() {
        return uniqueMechs;
    }

    @Override
    public String toString() {
        return name;
    }
}
