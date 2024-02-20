package journal.quizzes;

public class QuizAnswer {
    private final String answer;

    protected QuizAnswer(String ans) {
        answer = ans;
    }

    protected boolean isCorrect(String ans) {
        return answer.equals(ans);
    }
}
