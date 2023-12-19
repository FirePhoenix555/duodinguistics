import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.util.Objects;

public class FontLoader {
    public static Font loadFont(String filePath) throws IOException, FontFormatException {
        return Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(FontLoader.class.getResourceAsStream(filePath)));
    }
}
