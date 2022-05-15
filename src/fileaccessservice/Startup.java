
package fileaccessservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * Creates the FileService and has filePath hardcoded, that it passes
 * to various different objects inside the program. Will write and display
 * the passed in data
 * 
 * @author Andy
 */
public class Startup {
    
    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
       //Input filepath into the input strategy pass in the path
       //Create contact class, create contact objects with fields
       String filePath = "C:\\enhancements.csv";
        
       FileService service = new FileService(
               new TextFileWriter(new CsvCommaFormat(true), new GuiInput(filePath), "hours", "fees", "10", "20"),
               new TextFileReader(new CsvCommaFormat(true), new GuiInput(filePath), new ConsoleOutput()));

       
       service.writeFile();
       service.displayFile();
       
    }
    
}
