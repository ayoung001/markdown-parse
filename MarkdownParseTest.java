import static org.junit.Assert.*;

import org.junit.*;

import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * commands: 
 * javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java
 * java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest
 */

public class MarkdownParseTest 
{
  @Test
  public void testFile1() throws IOException 
  {
    Path fileName = Path.of("test-file.md");
    String contents = Files.readString(fileName);
    assertEquals(List.of("https://something.com","some-page.html"), MarkdownParse.getLinks(contents));
  }

  @Test
  public void testFile2() throws IOException 
  {
    Path fileName = Path.of("test-file2.md");
    String contents = Files.readString(fileName);
    assertEquals(List.of("https://something.com","some-page.html"),MarkdownParse.getLinks(contents));
  }

  @Test
  public void testFile3() throws IOException 
  {
    Path fileName = Path.of("test-file3.md");
    String contents = Files.readString(fileName);
    assertEquals(List.of(),MarkdownParse.getLinks(contents));
  }

  @Test
  public void testFile4() throws IOException 
  {
    Path fileName = Path.of("test-file4.md");
    String contents = Files.readString(fileName);
    assertEquals(List.of("gmail.com"),MarkdownParse.getLinks(contents));
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
