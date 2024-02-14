package trivia.question;

public record Question(
        String text
) {

    public Question {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalStateException("Question text must be not empty");
        }
    }

    @Override
    public String toString() {
        return text;
    }

    public enum Category {
        POP,
        SCIENCE,
        SPORTS,
        ROCK;

        @Override
        public String toString() {
            return this.name().substring(0, 1).toUpperCase() + this.name().substring(1).toLowerCase();
        }
    }
}
