import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.*;
import org.junit.*;

public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    
    @Test
    public void testGetLinksTestFile4() throws IOException{
        try {
            
            Path fileName = Path.of("test-file.md");
            String content = Files.readString(fileName);
            ArrayList<String> links = MarkdownParse.getLinks(content);
            String[] expected = {};
            assertArrayEquals(expected, links.toArray());
        } catch (IOException e) {
            System.out.println("File Not Found");
        }
        }
        
    

    @Test
    public void testGetLinks1(){
        try{
            assertEquals(MarkdownParse.getLinks(Files.readString(Path.of("test-file.md"))), List.of("https://something.com","some-thing.html"));
        }catch(Exception e){} 
    }

    @Test
    public void testGetLinks2(){
        try{
            assertEquals(MarkdownParse.getLinks(Files.readString(Path.of("test-file2.md"))), List.of("https://google.com","some-thing.html"));
        }catch(Exception e){} 
    }

    @Test
    public void testGetLinks3(){
        try{
            assertEquals(MarkdownParse.getLinks(Files.readString(Path.of("test-file3.md"))), List.of("more text here"));
            System.out.println("true");
        }catch(Exception e){
            System.out.println("there's an error");
        } 
    }

    @Test
    public void testGetLinks4(){
        try{
            assertEquals(MarkdownParse.getLinks(Files.readString(Path.of("test-file4.md"))), List.of());
        }catch(Exception e){} 
    }

}

