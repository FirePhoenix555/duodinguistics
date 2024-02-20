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

        boolean correct = q.isCorrect(ans);

        // todo maybe remove later in favor of advancing question manually elsewhere
        if (correct) advanceQuestion();

        return correct;
    }

    public QuizQuestion getCurrentQuestion() {
        if (isFinished()) return null;
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
