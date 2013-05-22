
package fileaccessservice;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Andy
 */
public class FileService {

    private FileReadingStrategy reader;
    private FileWritingStrategy writer;

    
    /**
     *
     * @param writer
     * @param reader
     */
    public FileService(FileWritingStrategy writer, FileReadingStrategy reader) {
        this.writer = writer;
        this.reader = reader;
    }

    
    /**
     *
     * Runs the writer objects writeFile method
     * 
     * @throws IOException
     */
    public void writeFile() throws IOException {
        writer.writeFile();
    }

    
    /**
     *
     * Runs the writer objects readFile method
     * 
     * @throws IOException
     */
    public void readFile() throws IOException{
        reader.readFile();
    }
    
    /**
     *
     * Runs the writer objects outputFile method
     * 
     * @throws IOException
     */
    public void displayFile() throws IOException{
        reader.outputFile();
    }
}
