package com.flow.mechwarriors;

import com.flow.mechwarriors.items.CellItem;
import javafx.geometry.Pos;


public class MainPresenter implements MainContract.Presenter {
    private MainContract.View view;
    private Game game;

    public MainPresenter (MainContract.View view) {
        this.view = view;
        game = new Game();

        view.showBattlefield(game.getBattlefield());
        view.showPlayers(game.getPlayers());
        view.selectCurrentPlayer(game.getCurrentPlayer());
    }

    @Override
    public void onTableItemClicked(Position position) {
        CellItem battlefieldItem = game.getBattlefieldItem(position);
        Player currentPlayer = game.getCurrentPlayer();

        Position selectedPosition = game.getSelectedPosition();
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
                if (selectedItem.isMovable() &&
                    game.isValidStep(selectedPosition, position) &&
                    selectedItem.getOwner().equals(currentPlayer)) {
                    moveItem(position, selectedPosition);
                    nextPlayer();
                }
            } else {
                nextPlayer();
            }
        }
    }

    private void highlightItemRange(Position itemPosition, CellItem item) {
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
        game.nextPlayer();
        view.selectCurrentPlayer(game.getCurrentPlayer());

        Position selectedPosition = game.getSelectedPosition();
        if (selectedPosition != null) {
            game.deselectItem();
            view.setSelection(selectedPosition, false);
        }
    }

    public boolean changeItemSelection(Position position, Position selectedPosition) {
        game.selectItem(position);
        view.setSelection(position, true);

        if (selectedPosition != null) {
            view.setSelection(selectedPosition, false);

            if (selectedPosition.equals(position)) {
                game.deselectItem();
                return false;
            }
        }

        return true;
    }

    private void moveItem(Position position, Position selectedPosition) {
        game.moveBattlefieldItem(selectedPosition, position);
        game.selectItem(position);

        view.setSelection(selectedPosition, false);

        view.updateBattlefieldItem(selectedPosition, null);
        view.updateBattlefieldItem(position, game.getBattlefieldItem(position));

        view.setSelection(position, true);

        view.removeHighLight();
    }

}
