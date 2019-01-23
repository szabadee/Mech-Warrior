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
                // highlightItemRange(position, battlefieldItem);

                for (int i = 0; i < 20; ++i) {
                    for (int j = 0; j < 20; ++j) {
                        Position to = new Position(i, j);
                        if (!to.equals(position)) {
                            view.highlightAttackableItem(to, game.isValidAttack(position, to));
                        }
                    }
                }

                if (selectedPosition != null) {
                    BattlefieldItem selectedItem = game.getBattlefieldItem(selectedPosition);

                    if (selectedItem.getStandingOnIt() &&
                            selectedItem.getMech().canAttack() &&
                            game.isValidAttack(selectedPosition, position) &&
                            selectedItem.getMech().getOwner().equals(currentPlayer)) {
                        game.attack(position, selectedItem.getMech().getAttackForce());
                        view.setSelection(selectedPosition, false);
                        nextPlayer();
                        view.showBattlefield(game.getBattlefield());
                        view.removeHighlight();
                        view.message(0);
                    } else {
                        if (selectedItem.getStandingOnIt() &&
                                game.isValidStep(selectedPosition, position) &&
                                selectedItem.getMech().getOwner().equals(currentPlayer)) {
                            moveItem(position, selectedPosition);
                            nextPlayer();
                            view.message(0);
                        } else {
                            view.message(1);
                        }
                    }
                }
            }
        } else {
            if (Table.playerOne.getUniqueMechs().size() == 0) {
                view.message(3);
            }
            if (Table.playerTwo.getUniqueMechs().size() == 0) {
                view.message(4);
            }
        }
    }

    private void highlightItemRange(Position itemPosition, BattlefieldItem item) {

        Position p1 = new Position(
                Math.max(0, itemPosition.x - item.getMech().maxStep()),
                Math.max(0, itemPosition.y - item.getMech().maxStep()));
        Position p2 = new Position(
                Math.max(item.getMech().maxStep(), itemPosition.x + item.getMech().maxStep()),
                Math.max(item.getMech().maxStep(), itemPosition.y + item.getMech().maxStep()));

        Range range = new Range(p1, p2);
        //game.barrierListener(range, itemPosition);

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
