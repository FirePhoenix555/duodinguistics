package text;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.util.Objects;

public class FontLoader {
    /*
     * Creates a Font object by reading from a font file (e.g. a TTF file) at an inputted file path.
     *
     * @param  filePath    The path to the file containing the font. Paths are relative to the FontLoader class file.
     * @return The Font object created by reading the file from the inputted path.
     * @throws IOException If the provided path is invalid (as a path).
     * @throws FontFormatException If the provided path does not point to a valid font file.
     */
    public static Font loadFont(String filePath) throws IOException, FontFormatException {
        return Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(FontLoader.class.getResourceAsStream(filePath)));
    }
}
