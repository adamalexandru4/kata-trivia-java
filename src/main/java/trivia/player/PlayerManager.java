package trivia.player;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {

    private final List<Player> players = new ArrayList<>();
    private int currentPlayer = 0;

    // this boolean doesn't make any sense. It should be bounded to the player, not to the game
    private boolean isGettingOutOfPenaltyBox = true;

    public void addPlayer(String playerName) {
        int numberPlayers = players.size();

        Player newPlayer = new Player(numberPlayers + 1, playerName);
        players.add(newPlayer);

        System.out.println(newPlayer.getName() + " was added");
        System.out.println("They are player number " + newPlayer.getNumber());
    }

    public void nextPlayer() {
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    public void setGettingOutOfPenaltyBox(Player player) {
        isGettingOutOfPenaltyBox = true;

        System.out.println(player + " is getting out of the penalty box");
    }

    public void setIsNotGettingOutOfPenaltyBox(Player player) {
        isGettingOutOfPenaltyBox = false;

        System.out.println(player + " is not getting out of the penalty box");
    }

    public boolean isGettingOutOfPenaltyBox() {
        return isGettingOutOfPenaltyBox;
    }
}
