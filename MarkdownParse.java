//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            //edited this
            currentIndex = openBracket;
            
            int closeBracket = markdown.indexOf("]", openBracket);
            //edited this
            currentIndex = closeBracket;            
            
            int openParen = markdown.indexOf("(", closeBracket);
            //edited this
            currentIndex = openParen;
            
            int closeParen = markdown.indexOf(")", openParen);
            //edited this
            currentIndex = closeParen;            
            
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex += 1;

            if ((markdown.indexOf("[", currentIndex) == -1) || (markdown.indexOf("]", currentIndex) == -1) ||
            (markdown.indexOf("(", currentIndex) == -1) || (markdown.indexOf(")", currentIndex) == -1)){
                break;
            } //include if statement 
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
