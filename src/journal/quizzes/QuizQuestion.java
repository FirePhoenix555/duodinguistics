package journal.quizzes;

public class QuizQuestion {
    private final String question;
    private final QuizAnswer answer;
    private boolean userCorrect = false;

    protected QuizQuestion(String ques, String ans) {
        question = ques;
        answer = new QuizAnswer(ans);
    }

    protected String getQuestion() {
        return question;
    }

    protected QuizAnswer getAnswer() {
        return answer;
    }

    protected boolean isCorrect(String ans) {
        if (answer.isCorrect(ans)) {
            userCorrect = true;
            return true;
        } else {
            return false;
        }
    }

    protected boolean completed() {
        return userCorrect;
    }
}
