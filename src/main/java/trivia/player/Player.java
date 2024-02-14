package trivia.player;

public final class Player {
    private final int number;
    private final String name;

    private int location;
    private int coins;
    private boolean inPenaltyBox;


    public Player(int number, String name) {
        if (number < 0) {
            throw new IllegalStateException("Player number must be greater than 0");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalStateException("Player name must be not empty");
        }
        this.number = number;
        this.name = name;
        this.location = 0;
        this.coins = 0;
        this.inPenaltyBox = false;
    }

    public void moveTo(int place) {
        this.location = this.location + place;

        if (this.location > 11) {
            this.location = this.location - 12;
        }

        System.out.println(name + "'s new location is " + location);
    }

    public void addReward() {
        this.coins = this.coins + 1;

        System.out.println(name + " now has " + coins + " Gold Coins.");
    }

    public void goToPenaltyBox() {
        this.inPenaltyBox = true;

        System.out.println(name + " was sent to the penalty box");
    }

    public void exitFromPenaltyBox() {
        this.inPenaltyBox = false;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public int getCoins() {
        return coins;
    }

    public boolean isInPenaltyBox() {
        return inPenaltyBox;
    }

    @Override
    public String toString() {
        return name;
    }
}
