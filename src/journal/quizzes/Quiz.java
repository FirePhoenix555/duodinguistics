package journal.quizzes;

public class Quiz {
    private final QuizQuestion[] questions;
    private int currentQuestionIndex = 0;
    private final String context;

    protected Quiz(QuizQuestion[] qs, String c) {
        questions = qs;
        context = c;
    }

    public boolean gradeAnswer(String ans) {
        QuizQuestion q = getCurrentQuestion();

        return q.isCorrect(ans);
    }

    public QuizQuestion getCurrentQuestion() {
        return questions[currentQuestionIndex];
    }

    public void advanceQuestion() {
        currentQuestionIndex++;
    }

    public QuizQuestion getQuestionByNumber(int index) {
        return questions[index];
    }

    public String getContext() {
        return context;
    }

    public boolean isFinished() {
        return currentQuestionIndex >= questions.length;
    }

    public boolean isPassed() {
        for (int i = questions.length - 1; i >= 0; i--) { // loop backwards for efficiency (only usually have to check last question)
            QuizQuestion q = questions[i];
            if (!q.completed()) return false;
        }

        return true;
    }
}
