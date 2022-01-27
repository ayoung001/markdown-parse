import static org.junit.Assert.*;
import org.junit.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.io.IOException;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void testMarkdownParse() throws IOException{
        Path fileName = Path.of("/Users/achuthkrishna/Documents/GitHub/markdown-parse/test-file.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> check = List.of("https://something.com", "some-page.html");
        assertEquals(links, check);
    }
}
