
package fileaccessservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * FileReader strategy object that readers the data from the file
 * with the passed in filepath.
 * 
 * @author Andy
 */
public class TextFileReader implements FileReadingStrategy<List<LinkedHashMap<String, String>>> {

    private String filePath;
    private File data;
    private FileFormattingStrategy<List<LinkedHashMap<String, String>>,List<String>> format;
    private InputStrategy input;
    private OutputStrategy output;
    private BufferedReader in;

    /**
     *
     * @param readerFormat
     * @param readerInput
     * @param output
     */
    public TextFileReader(FileFormattingStrategy<List<LinkedHashMap<String, String>>,List<String>>  readerFormat,
            InputStrategy readerInput, OutputStrategy output ) {
        this.format = readerFormat;
        this.input = readerInput;
        this.output = output;
    }

    /**
     *
     * @param path
     */
    public TextFileReader(String path) {
        path = path;
    }

    
    /**
     *
     * Creates bufferedReader object and reads it line by line and adds
     * it to a List where it is returned and decoded.
     * 
     * @return format.decode(rawDataFromFile);
     * @throws IOException
     */
    @Override
    public List<LinkedHashMap<String, String>> readFile() throws IOException {

        filePath = input.getFilePath();
        
        // do acutal file read
        List<String> rawDataFromFile = new ArrayList<String>();
        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new FileReader(filePath));
            String line = in.readLine();
            while (line != null) {
                rawDataFromFile.add(line);
                line = in.readLine();
            }
        } catch(IOException ioe){
            throw ioe;
        }finally{
            if(in != null){
                in.close();
            }
        }
        return format.decode(rawDataFromFile);
    }
        
    /**
     *
     * Used to output the File, which uses a Output strategy object,
     * so the read is never called because it won't display it, this way
     * is more flexible.
     * 
     * @throws IOException
     */
    @Override
    public void outputFile() throws IOException {
        output.displayRecords(readFile());
    }
}
