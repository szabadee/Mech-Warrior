package com.flow.mechwarriors;

import com.flow.mechwarriors.items.CellItem;

import java.util.List;

public interface MainContract {
    interface View {
        void showBattlefield(Battlefield battlefield);
        void setSelection(Position position, boolean selection);
        void showPlayers(List<Player> players);
        void selectCurrentPlayer(Player player);
        void highlightAttackableItems(Range range, Position center);
        void removeHighlight();

        }
    interface Presenter {
        void onTableItemClicked (Position position);
    }
}
