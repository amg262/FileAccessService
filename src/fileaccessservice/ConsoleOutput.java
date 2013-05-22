
package fileaccessservice;

import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * Output that uses the Console to output the records, or message
 * 
 * @author Andy
 */
public class ConsoleOutput implements OutputStrategy {

    /**
     *
     * Prints out the records in console
     * 
     * @param recordOutput
     */
    @Override
    public void displayMsg(String recordOutput) {
        
        System.out.println(recordOutput);
        
    }

    /**
     *
     * Displays the rawdata in console
     * 
     * @param rawDataFromFile
     */
    @Override
    public void displayRecords(List<LinkedHashMap<String, String>> rawDataFromFile) {
        System.out.println(rawDataFromFile);
    }
    
}
