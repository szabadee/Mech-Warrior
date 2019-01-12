package com.flow.mechwarriors;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();
    private Position selectedPosition;
    private Battlefield battlefield = new Battlefield();

    private int currentPlayerIndex = 0;

    public Game() {
    }

    public void selectItem(Position position) {
        selectedPosition = position;
    }

    public Position getSelectedPosition() {
        return selectedPosition;
    }

    public Battlefield getBattlefield() {
        return battlefield;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
