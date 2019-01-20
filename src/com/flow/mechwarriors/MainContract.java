package com.flow.mechwarriors;

import com.flow.mechwarriors.items.CellItem;

import java.util.List;

public interface MainContract {
    interface View {
        void showBattlefield(Battlefield battlefield);
        void setSelection(Position position, boolean selection);
        void updateBattlefieldItem(Position position, CellItem cellItem);
        int selectFromList(String[] list);
        void showPlayers(List<Player> players);
        void selectCurrentPlayer(Player player);
        void highlightRange(Range range, Position center);
        void removeHighLight();

        }
    interface Presenter {
        void onTableItemClicked (Position position);
    }
}
