package com.flow.mechwarriors;

import com.flow.mechwarriors.items.CellItem;
import com.flow.mechwarriors.items.MechLight;
import javafx.geometry.Pos;


public class MainPresenter implements MainContract.Presenter {
    private MainContract.View view;
    private Game game;

    public MainPresenter (MainContract.View view) {
        this.view = view;
        game = new Game();

        view.showBattlefield(game.getBattlefield());
        //view.showPlayers(game.getPlayers());
        //view.selectCurrentPlayer(game.getCurrentPlayer());
    }

    @Override
    public void onTableItemClicked(Position position) {
        CellItem battlefieldItem = game.getBattlefieldItem(position);
        Position selectedPosition = game.getSelectedPosition();
        System.out.println("Érték: " + battlefieldItem);

        //CellItem selectedItem = game.getBattlefieldItem(selectedPosition);


        if (battlefieldItem != null) {
            if (changeItemSelection(position, selectedPosition)) {
                if (selectedPosition != null) {
                    CellItem selectedItem = game.getBattlefieldItem(selectedPosition);
                    if (selectedItem.getStandingOnIt() &&
                            game.isValidStep(selectedPosition, position)) {
                        moveItem(position, selectedPosition);
                    }
                }
            }
        }




        //

        //CellItem selectedItem = game.getBattlefieldItem(selectedPosition);

        /*if (selectedPosition == null) {
            moveItem(position, selectedPosition);
        }*/

        /*
        if (actualPositions[i][j].getSelected()) {
                        actualPositions[i - 1][j].setMech(actualPositions[i][j].getMech());
                        actualPositions[i - 1][j].setStandingOnIt(true);
                        buttons[i - 1][j].setForeground(Color.RED);
                        actualPositions[i][j].setStandingOnIt(false);
                        actualPositions[i - 1][j].setSelected(true);
                        actualPositions[i][j].setSelected(false);
                        System.out.println(actualPositions[i - 1][j].getMech());
                        System.out.println(actualPositions[i][j].getStandingOnIt());

        Player currentPlayer = game.getCurrentPlayer();
        if (battlefieldItem != null) {
            view.removeHighLight();
            if (changeItemSelection(position, selectedPosition)) {
                if (battlefieldItem.getOwner().equals(currentPlayer)) {
                    highlightItemRange(position, battlefieldItem);
                }
            }
        } else {
            if (selectedPosition != null) {
                CellItem selectedItem = game.getBattlefieldItem(selectedPosition);
                if (selectedItem.getStandingOnIt() &&
                    game.isValidStep(selectedPosition, position) &&
                    selectedItem.getOwner().equals(currentPlayer)) {
                    moveItem(position, selectedPosition);
                    nextPlayer();
                }
            } else {
                nextPlayer();
            }
        }*/
    }

    /*private void highlightItemRange(Position itemPosition, CellItem item) {
        view.removeHighLight();

        Position p1 = new Position(
                Math.max(0, itemPosition.x - item.maxStep()),
                Math.max(0, itemPosition.y - item.maxStep()));
        Position p2 = new Position(
                Math.max(9, itemPosition.x + item.maxStep()),
                Math.max(9, itemPosition.y + item.maxStep()));

        Range range = new Range(p1, p2);
        view.highlightRange(range, item.canMoveOutOfAxis() ? null : itemPosition);
    }

    private void nextPlayer() {
        /*game.nextPlayer();
        view.selectCurrentPlayer(game.getCurrentPlayer());

        Position selectedPosition = game.getSelectedPosition();
        if (selectedPosition != null) {
            game.deselectItem();
            view.setSelection(selectedPosition, false);
        }
    }*/

    public boolean changeItemSelection(Position newPosition, Position selectedPosition) {
        game.selectItem(newPosition);
        view.setSelection(newPosition, true);

        if (selectedPosition != null) {
            view.setSelection(selectedPosition, false);

            if (selectedPosition.equals(newPosition)) {
                game.deselectItem();
                return false;
            }
        }

        return true;
    }

    private void moveItem(Position newPosition, Position selectedPosition) {
        game.moveBattlefieldItem(selectedPosition, newPosition);
        game.selectItem(newPosition);

        view.setSelection(selectedPosition, false);

        //view.updateBattlefieldItem(selectedPosition, game.getBattlefieldItem(selectedPosition));
        //view.updateBattlefieldItem(newPosition, game.getBattlefieldItem(newPosition));
        view.showBattlefield(game.getBattlefield());

        view.setSelection(newPosition, true);

        //view.removeHighLight();
    }


}
