
package fileaccessservice;

import java.util.LinkedHashMap;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * Output different methods using the GUI, and is strategy
 * object used for flexible output.
 * 
 * @author Andy
 */
public class GuiOutput implements OutputStrategy {


    
    /**
     * Displays output in JOptionPane
     * 
     * @param recordOutput
     */
    @Override
    public void displayMsg(String recordOutput) {
        
        JOptionPane.showMessageDialog(null, recordOutput, "Ouput", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Displays output in JOptionPane
     * 
     * @param rawDataFromFile
     */
    @Override
    public void displayRecords(List<LinkedHashMap<String, String>> rawDataFromFile) {
        JOptionPane.showMessageDialog(null, rawDataFromFile);
    }
}
