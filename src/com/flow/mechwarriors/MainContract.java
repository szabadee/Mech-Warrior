package com.flow.mechwarriors;

import java.util.List;

public interface MainContract {
    interface View {
        void showBattlefield(Battlefield battlefield);
        void setSelection(Position position, boolean selection);
        void showPlayers(List<Player> players);
        void selectCurrentPlayer(Player player);
        void highlightRange(Range range, Position center);
        void removeHighlight();
        void message(int messageCode);
        void highlightAttackableItem(Position position, boolean highlight);

        }
    interface Presenter {
        void onTableItemClicked (Position position);
    }
}
