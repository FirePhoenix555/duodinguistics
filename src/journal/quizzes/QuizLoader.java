package journal.quizzes;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// https://www.geeksforgeeks.org/parse-json-java/
public class QuizLoader {

    // loads all quiz data from the quiz file
    private static JSONArray loadFile(String filepath) throws IOException, ParseException {
        FileReader fr = new FileReader(filepath);
        Object obj = new JSONParser().parse(fr);
        return (JSONArray) obj; // read that as an array (assuming properly formatted quiz file)
    }

    // loads an individual indexed quiz
    public static Quiz load(String filepath, int quizNumber) {
        JSONArray j;

        try {
            j = loadFile(filepath);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        JSONObject quizObject = (JSONObject) j.get(quizNumber); // get the requested quiz
        JSONArray questionArray = (JSONArray) quizObject.get("questions"); // get the questions array

        QuizQuestion[] qqs = new QuizQuestion[questionArray.size()]; // make a new array for storing the quizquestion objects

        for (int i = 0; i < qqs.length; i++) {
            JSONObject questionObject = (JSONObject) questionArray.get(i);

            String question = (String) questionObject.get("question");
            String answer = (String) questionObject.get("answer");

            QuizQuestion quizQuestion = new QuizQuestion(question, answer);

            qqs[i] = quizQuestion;
        }

        String context = (String) quizObject.get("context");

        return new Quiz(qqs,context);
    }
}
