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
    
    @Test
    public void testSnippet1() throws IOException
    {
      Path fileName = Path.of("snippet1.md");
      String contents = Files.readString(fileName);
      assertEquals(List.of("`google.com","google.com","ucsd.edu"),MarkdownParse.getLinks(contents));
    }
  
    @Test
    public void testSnippet2() throws IOException
    {
      Path fileName = Path.of("snippet2.md");
      String contents = Files.readString(fileName);
      assertEquals(List.of("a.com","a.com(())","example.com"),MarkdownParse.getLinks(contents));
    }
  
    @Test
    public void testSnippet3() throws IOException
    {
      Path fileName = Path.of("snippet3.md");
      String contents = Files.readString(fileName);
      assertEquals(List.of("https://www.twitter.com ","https://ucsd-cse15l-w22.github.io/","https://cse.ucsd.edu"),MarkdownParse.getLinks(contents));
    }
}
