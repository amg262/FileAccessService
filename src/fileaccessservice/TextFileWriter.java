
package fileaccessservice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * FileWriter object that will write the passed in, or specified data into the 
 * the path of the file
 * 
 * @author Andy
 */
public class TextFileWriter implements FileWritingStrategy<List<LinkedHashMap<String, String>>>  {

    private File data;
    private String filePath;
    private InputStrategy input;
    private FileFormattingStrategy format;
    private PrintWriter out;
    private String h1;
    private String h2;
    private String v1;
    private String v2;
    
    
    
    /**
     *
     * @param writerFormat
     * @param writerInput
     */
    public TextFileWriter(FileFormattingStrategy writerFormat, InputStrategy writerInput) {
        this.format = writerFormat;
        this.input = writerInput;
    }
    
    /**
     *
     * @param writerFormat
     * @param writerInput
     * @param head1
     * @param head2
     * @param val1
     * @param val2
     */
    public TextFileWriter(FileFormattingStrategy writerFormat, InputStrategy writerInput,
            String head1, String head2, String val1, String val2){
        this.format = writerFormat;
        this.input = writerInput;
        this.h1 = head1;
        this.h2 = head2;
        this.v1 = val1;
        this.v2 = val2;
    }
    
    /**
     *
     * @param path
     */
    public TextFileWriter(String path) {
        path = path;
    }



    /**
     *
     * Writes the encoded data to the file
     * 
     * @return input
     * @throws IOException
     */
    @Override
    public List<LinkedHashMap<String, String>> writeFile() throws IOException {
    
        filePath = input.getFilePath();
        data = new File(filePath);
        boolean append = false; 
        
        List<LinkedHashMap<String, String>> input = new ArrayList<LinkedHashMap<String, String>>();
        
        LinkedHashMap<String, String> record = new LinkedHashMap<>();
        record.put(h1, v1);
        record.put(h2, v2);
        input.add(record);

        String d = format.encode(input);
        
        try {
          
          out = new PrintWriter(new BufferedWriter(new FileWriter(data, append)));
      
          out.write(d);
           
          //dont forget!
          out.close();
          } catch (IOException ex) {

        }
        return input;
    }
}
