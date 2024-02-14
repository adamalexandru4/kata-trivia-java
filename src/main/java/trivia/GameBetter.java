package trivia;

import trivia.player.Player;
import trivia.player.PlayerManager;
import trivia.question.Question;
import trivia.question.QuestionManager;

import static trivia.question.Question.Category.values;


public class GameBetter implements IGame {

    private final QuestionManager questionManager;
    private final PlayerManager players;

    public GameBetter() {
        this.questionManager = new QuestionManager();
        this.players = new PlayerManager();

        for (Question.Category category : values()) {
            this.questionManager.generateForCategory(category);
        }
    }

    public boolean add(String playerName) {
        players.addPlayer(playerName);
        return true;
    }

    public void roll(int roll) {
        Player player = players.getCurrentPlayer();

        System.out.println(player + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (player.isInPenaltyBox()) {
            if (isEven(roll)) {
                players.setGettingOutOfPenaltyBox(player);
                playTurn(player, roll);
            } else {
                players.setIsNotGettingOutOfPenaltyBox(player);
            }

        } else {
            playTurn(player, roll);
        }

    }

    private boolean isEven(int roll) {
        return roll % 2 != 0;
    }

    private void playTurn(Player player, int roll) {
        player.moveTo(roll);
        questionManager.askQuestion(player.getLocation());
    }

    public boolean wasCorrectlyAnswered() {
        Player player = players.getCurrentPlayer();

        if (player.isInPenaltyBox() && !players.isGettingOutOfPenaltyBox()) {
            players.nextPlayer();
            return true;
        }

        System.out.println("Answer was correct!!!!");
        player.addReward();

        boolean winner = isWinner(player);
        players.nextPlayer();

        return !winner;
    }

    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");

        Player player = players.getCurrentPlayer();
        player.goToPenaltyBox();

        players.nextPlayer();
        return true;
    }

    private boolean isWinner(Player player) {
        return player.getCoins() == 6;
    }


}
