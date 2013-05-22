
package fileaccessservice;

import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * GUi input object used for flexible input when it comes to asking
 * for the file path. Can skip that and just pass it in.
 * 
 * @author Andy
 */
public class GuiInput implements InputStrategy {

    private final String PER = ".";
    private String path;

    /**
     *
     * @param path
     */
    public GuiInput(String path){
        this.path = path;
    }
    
    /**
     *
     */
    public GuiInput(){
    }

    
    /**
     *
     * Prompts user with string of questions to get the filePath
     * piece by piece 
     * 
     * @return filePath.
     */
    @Override
    public String getFilePath() {
        
        
        if (path == null){
     
        String dir = JOptionPane.showInputDialog(null,  "Directory name:     "
                +  "C:" + File.separatorChar + "????", "File Service",  JOptionPane.QUESTION_MESSAGE);

        /////////////////////////////////////////////
        String folder = JOptionPane.showInputDialog(null, "File Name:     " 
                +   "C:" + File.separatorChar + dir + "\\????",  "File Service",  JOptionPane.QUESTION_MESSAGE);

        ///////////////////////////////////////////////
        String ext = JOptionPane.showInputDialog(null, "File Extension:    " 
                +   "C:" + File.separatorChar + dir + File.separatorChar + folder + ".???", "File Service",  JOptionPane.QUESTION_MESSAGE);

        path =  File.separatorChar + dir + File.separatorChar + folder + PER + ext;
        
        }
        else if (path != null){
            path = path;
        }
        return path;
    }

}
