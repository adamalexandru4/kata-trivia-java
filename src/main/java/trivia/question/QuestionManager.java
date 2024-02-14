package trivia.question;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.Map;

import static trivia.question.Question.Category.*;
import static trivia.question.Question.Category.ROCK;

public class QuestionManager {

    Map<Question.Category, LinkedList<Question>> questions = new EnumMap<>(Question.Category.class);

    public void generateForCategory(Question.Category category) {
        LinkedList<Question> categoryQuestions = new LinkedList<>();

        for (int i = 0; i < 50; i++) {
            categoryQuestions.add(new Question(category.toString() + " Question " + i));
        }

        questions.put(category, categoryQuestions);
    }

    private Question getQuestionFor(Question.Category category) {
        LinkedList<Question> categoryQuestions = questions.get(category);
        return categoryQuestions.removeFirst();
    }

    public void askQuestion(int location) {
        Question.Category category = currentCategory(location);
        System.out.println("The category is " + category);

        Question question = getQuestionFor(category);
        System.out.println(question);
    }


    private Question.Category currentCategory(int location) {
        int category = location % 4;
        return switch (category) {
            case 0 -> POP;
            case 1 -> SCIENCE;
            case 2 -> SPORTS;
            default -> ROCK;
        };
    }
}
