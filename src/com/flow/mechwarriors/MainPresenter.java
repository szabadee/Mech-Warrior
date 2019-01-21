package com.flow.mechwarriors;

import com.flow.mechwarriors.items.BattlefieldItem;


public class MainPresenter implements MainContract.Presenter {
    private MainContract.View view;
    private Game game;

    public MainPresenter(MainContract.View view) {
        this.view = view;
        game = new Game();

        view.showBattlefield(game.getBattlefield());
        view.showPlayers(game.getPlayers());
        view.selectCurrentPlayer(game.getCurrentPlayer());
    }

    @Override
    public void onTableItemClicked(Position position) {
        Player currentPlayer = game.getCurrentPlayer();
        BattlefieldItem battlefieldItem = game.getBattlefieldItem(position);
        Position selectedPosition = game.getSelectedPosition();

        if (battlefieldItem != null) {
            if (changeItemSelection(position, selectedPosition)) {

                if (selectedPosition != null) {
                    BattlefieldItem selectedItem = game.getBattlefieldItem(selectedPosition);

                    if (selectedItem.getStandingOnIt() &&
                            game.isValidAttack(selectedPosition, position) &&
                            selectedItem.getMech().getOwner().equals(currentPlayer)) {
                        game.removeItem(position);
                        view.setSelection(selectedPosition, false);
                        nextPlayer();
                        view.showBattlefield(game.getBattlefield());
                    } else {
                        if (selectedItem.getStandingOnIt() &&
                                game.isValidStep(selectedPosition, position) &&
                                selectedItem.getMech().getOwner().equals(currentPlayer)) {
                            moveItem(position, selectedPosition);
                            nextPlayer();
                        }
                    }
                }
            }
        }
    }

    /*
    } else {
            if (selectedPosition != null) {
                CellItem selectedItem = game.getCellItem(selectedPosition);
                if (selectedItem.isMovable() &&
                        game.isValidStep(selectedPosition, position) &&
                        selectedItem.getOwner().equals(currentPlayer)) {
                    moveItem(position, selectedPosition);
                    nextPlayer();
                }
     */

    private void attackableItems(Position itemPosition, BattlefieldItem item) {
        view.removeHighlight();

        Position p1 = new Position(
                Math.max(0, itemPosition.x - item.getMech().maxAttack()),
                Math.max(0, itemPosition.y - item.getMech().maxAttack()));
        Position p2 = new Position(
                Math.max(item.getMech().maxStep(), itemPosition.x + item.getMech().maxAttack()),
                Math.max(item.getMech().maxStep(), itemPosition.y + item.getMech().maxAttack()));

        Range range = new Range(p1, p2);
        view.highlightAttackableItems(range, itemPosition);

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
        view.showBattlefield(game.getBattlefield());
        view.setSelection(newPosition, true);

        view.removeHighlight();
    }

}
