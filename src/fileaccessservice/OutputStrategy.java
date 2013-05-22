
package fileaccessservice;

import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * Interface that has methods every Output Strategy object
 * must implement and define. Basis for all displaying done
 * with the program.
 * 
 * @author Andy
 */
public interface OutputStrategy {
    
    /**
     * Will Display message in either Gui or Console
     * 
     * @param recordOutput
     */
    public abstract void displayMsg(String recordOutput);
    
    /**
     * Will display the records in either GUI or console
     * 
     * @param rawDataFromFile
     */
    public abstract void displayRecords(List<LinkedHashMap<String, String>> rawDataFromFile);
    
}
