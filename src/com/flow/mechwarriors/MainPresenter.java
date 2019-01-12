package com.flow.mechwarriors;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View view;
    private Game game;

    public MainPresenter (MainContract.View view) {
        this.view = view;
        game = new Game();

        view.showBattlefield(game.getBattlefield());
        view.showPlayers(game.getPlayers());

    }



    @Override
    public void onTableItemClicked(Position position) {

    }
}
