package text;

import java.awt.Graphics;
import java.awt.FontMetrics;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

// A wrapping for the Typewriter class
// that fixes text wrapping (lol)
public class TextHandler {
    private final Typewriter typewriter;
    private final int maxWidth;

    public TextHandler(String text, int maxWidth_) {
        typewriter = new Typewriter(text);
        maxWidth = maxWidth_;
    }

    public void pulseTypewriter() {
        typewriter.pulse();
    }

    public String getString(Graphics g) {
        FontMetrics fm = g.getFontMetrics();

        String originalString = typewriter.getString();

        String[] words = originalString.split("\\b"); // get all words in string and add 1 at a time

        ArrayList<String> lines = new ArrayList<String>();
        int lineIndex = 0;

        for (String word : words) {
            if (lineIndex >= lines.size()) lines.add(""); // add new lines to arraylist to avoid out of bounds errors

            String line = lines.get(lineIndex);

            Rectangle2D bounds = fm.getStringBounds(line + word, g);

            if (bounds.getWidth() > maxWidth && !word.matches("[^A-Za-z]+")) { // should be on a new line
                line = "";
                lineIndex++;
                if (lineIndex >= lines.size()) lines.add(""); // add the new line to the arraylist to avoid out of bounds errors
            }

            lines.set(lineIndex, line + word);
        }

        return String.join("\n", lines); // join the lines back together
    }

    // https://stackoverflow.com/questions/4413132/problems-with-newline-in-graphics2d-drawstring
    public void drawString(Graphics g, int x, int y) { // because apparently it doesn't support multiple lines
        String s = getString(g);

        String[] lines = s.split("\n");

        for (String line : lines) {
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
        }
    }
}
